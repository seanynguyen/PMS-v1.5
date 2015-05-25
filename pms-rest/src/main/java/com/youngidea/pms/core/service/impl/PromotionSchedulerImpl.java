/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.core.service.impl;

import com.google.common.collect.MapMaker;
import com.youngidea.pms.core.facade.GenericFacade;
import com.youngidea.pms.core.service.BillingService;
import com.youngidea.pms.core.service.SchedulerService;
import com.youngidea.pms.core.ultilities.SchedulerHelper;
import com.youngidea.pms.core.ultilities.ValidatePromotionJob;
import com.youngidea.pms.core.entity.promotion.PeriodicSchedule;
import com.youngidea.pms.core.entity.promotion.Promotion;
import com.youngidea.pms.core.service.PromotionScheduler;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.concurrent.ConcurrentMap;

import static org.quartz.JobBuilder.newJob;

/**
 *
 * @author sean
 */
@Stateless
public class PromotionSchedulerImpl implements PromotionScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(PromotionSchedulerImpl.class);

    @EJB
    private SchedulerService schedulerService;

    @EJB
    private BillingService billingService;

    @EJB
    private GenericFacade genericFacade;

    private final ConcurrentMap<Long, Scheduler> schedulers = new MapMaker().makeMap();

    private JobBuilder jobBuilder;

    @PostConstruct
    public void init() {
        jobBuilder = newJob();
        // load all running schedule from databse and execute once server is redeployed
        for (Promotion promotion : genericFacade.findAll(Promotion.class)) {
            schedule(promotion);
        }
    }

//    @Override
//    public void cancel(ScheduledTest scheduledTest) throws ScheduleTestException {
//        ScheduledRunnerBean scheduledRunnerBean = scheduledFutures.remove(scheduledTest.getId());
//        if (scheduledRunnerBean != null) {
//            scheduledRunnerBean.getFuture().cancel(true); // right here
//            LOGGER.info("Cancel scheduled test for TestSuite [" + scheduledTest.getSuite().getId() + "]");
//        }
//    }
//
//    
//    @Override
//    public void pauseOrPlay(ScheduledTest scheduledTest) throws ScheduleTestException {
//        if (scheduledTest.isActive()) {
//            cancel(scheduledTest);
//        } else {
//            schedule(scheduledTest);
//        }
//        scheduledTest.setActive(!scheduledTest.isActive());
//        genericWicketDAO.saveBaseEntity(scheduledTest);
//    }
    // using pause and resume version
    
    public boolean pauseOrResumePromotionScheduler2(PeriodicSchedule schedule) throws SchedulerException {
        if (schedulers.containsKey(schedule.getId())) {
            if (!schedule.isIsActive()) {
                schedulers.get(schedule.getId()).resumeAll();
            } else {
                schedulers.get(schedule.getId()).pauseAll();
            }
            schedule.setIsActive(!schedule.isIsActive());
            genericFacade.edit(PeriodicSchedule.class, schedule);
        }
        return schedule.isIsActive();
    }

    public boolean pauseOrResumePromotionScheduler(Promotion promotion) throws SchedulerException {
        PeriodicSchedule schedule = promotion.getPeriodicSchedule();
        if (schedule.isIsActive()) {
            schedule(promotion);
        } else {
            cancelPromotionScheduler(promotion.getPeriodicSchedule());
        }
        schedule.setIsActive(!schedule.isIsActive());
        genericFacade.edit(PeriodicSchedule.class, schedule);
        return schedule.isIsActive();
    }

    public void cancelPromotionScheduler(PeriodicSchedule schedule) {
        try {
            schedulers.remove(schedule.getId()).shutdown();
        } catch (SchedulerException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void schedule(Promotion promotion) {
//        System.out.println("ID: ------->" + promotion.getId());
//        System.out.println("Start time: ---->" + promotion.getPeriodicSchedule().getPeriodicStartTime());
        if (promotion.getPeriodicSchedule().isIsActive()
                && SchedulerHelper.getCurrentDate().before(promotion.getPeriodicSchedule().getEndTime())) {
            JobDetail resumePromotionJob = jobBuilder.withIdentity(promotion.getId().toString(), "group1").ofType(ValidatePromotionJob.class).build();
            resumePromotionJob.getJobDataMap().put("BillingService", billingService);
            resumePromotionJob.getJobDataMap().put("period", promotion.getPeriod());
            try {
                schedulers.put(promotion.getPeriodicSchedule().getId(),
                        schedulerService.schedule(resumePromotionJob, promotion.getPeriodicSchedule()));
            } catch (SchedulerException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }

    // using pause and resume version
    public void schedule2(Promotion promotion) throws SchedulerException {
//        System.out.println("ID: ------->" + promotion.getId());
//        System.out.println("Start time: ---->" + promotion.getPeriodicSchedule().getPeriodicStartTime());
        if (SchedulerHelper.getCurrentDate().before(promotion.getPeriodicSchedule().getEndTime())) {
            JobDetail resumePromotionJob = jobBuilder.withIdentity(promotion.getId().toString(), "group1").ofType(ValidatePromotionJob.class).build();
            resumePromotionJob.getJobDataMap().put("BillingService", billingService);
            resumePromotionJob.getJobDataMap().put("period", promotion.getPeriod());
            Scheduler scheduler = schedulerService.schedule(resumePromotionJob, promotion.getPeriodicSchedule());
            if (promotion.getPeriodicSchedule().isIsActive()) {
                scheduler.pauseAll();
            }
            schedulers.put(promotion.getPeriodicSchedule().getId(), scheduler);
        }
    }
}
