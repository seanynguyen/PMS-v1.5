/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.service.impl;

import com.google.common.collect.MapMaker;
import com.youngidea.pms.entity.promotion.PeriodicSchedule;
import com.youngidea.pms.entity.promotion.Promotion;
import com.youngidea.pms.entity.promotion.Schedule;
import com.youngidea.pms.facade.GenericFacade;
import com.youngidea.pms.service.BillingService;
import com.youngidea.pms.service.SchedulerService;
import com.youngidea.pms.test.HelloJob;
import com.youngidea.pms.ultilities.PausePromotionJob;
import com.youngidea.pms.ultilities.PeriodicType;
import com.youngidea.pms.ultilities.SchedulerHelper;
import com.youngidea.pms.ultilities.ValidatePromotionJob;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.ProjectStage;
import org.apache.log4j.BasicConfigurator;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.JobBuilder.newJob;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import static org.quartz.TriggerBuilder.newTrigger;
import org.quartz.impl.StdSchedulerFactory;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author sean
 */
@Stateless
public class SchedulerServiceImpl implements SchedulerService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerServiceImpl.class);

    @EJB
    private BillingService billingService;
    
    @EJB
    private GenericFacade genericFacade;
    
    private SchedulerFactory schedulerFactory;
    
    private TriggerBuilder<Trigger> triggerBuilder1;
    
    private JobBuilder jobBuilder;
    
    private ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
    
    private final ConcurrentMap<Long, ScheduledFuture> scheduledFutures = new MapMaker().makeMap();

    // List<Scheduler>
    
    @PostConstruct
    private void init() {
        schedulerFactory = new StdSchedulerFactory();
        triggerBuilder1 = newTrigger();
        jobBuilder = newJob();
        // To enable quartz logging
        BasicConfigurator.configure();
        // Load promotion schedule from database, remember that promotion's start date and time must be after current date
        // The target is for dealing with server redeployment
        scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10);
    }

    // we ignore isActive for now to avoid complexity !
    @Override
    public Scheduler schedule(JobDetail job, PeriodicSchedule periodicSchedule) throws SchedulerException { // just job and trigger
        Scheduler scheduler = schedulerFactory.getScheduler();
        triggerBuilder1.withIdentity("JobKey:"+job.getKey());
        scheduler.scheduleJob(job, 
                configureTrigger(periodicSchedule));
//        startScheduler(scheduler, periodicSchedule.getStartTime(), periodicSchedule.getEndTime()); 
        scheduler.start();
        return scheduler;
    }

    public void scheduleForPromotion(Promotion promotion) throws SchedulerException, InterruptedException {
        System.out.println("ID: ------->" + promotion.getId());
        System.out.println("Start time: ---->" + promotion.getPeriodicSchedule().getPeriodicStartTime());
        JobDetail resumePromotionJob = jobBuilder.withIdentity("ResumePromo" + promotion.getId(), "group1").ofType(ValidatePromotionJob.class).build();
        resumePromotionJob.getJobDataMap().put("BillingService", billingService);
//        resumePromotionJob.getJobDataMap().put("PromotionRules", promotion.getPromotionRule());
        resumePromotionJob.getJobDataMap().put("period", promotion.getPeriod());
        System.out.println(resumePromotionJob.getKey());
        schedule(resumePromotionJob, promotion.getPeriodicSchedule());
    }
    
    public Date addTimeToDate(Date currentDate, Long timeAddition) {
        return new Date(currentDate.getTime() + timeAddition);
    }
    
    private Trigger configureTrigger(PeriodicSchedule schedule) {
        // code
        // bo sot truong hop: currentTime.after(scheduler.getEndTime())
        // cach nhau it nhat 30s moi work
        Date currentDate = SchedulerHelper.getCurrentDate();
        Date startTime = currentDate.after(schedule.getStartTime()) ? 
                currentDate : schedule.getStartTime();
        triggerBuilder1.startAt(startTime);
        triggerBuilder1.endAt(schedule.getEndTime());
//        System.out.println("---------> Start time: " + schedule.getStartTime());
//        System.out.println("---------> Actual start time: " + new Date(System.currentTimeMillis() + 60000L));
        Date periodicTime = schedule.getPeriodicStartTime(); 
        switch (schedule.getType()) {
            case DAILY:
                triggerBuilder1
                        .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(periodicTime.getHours(), 
                                periodicTime.getMinutes()));
                System.out.println(periodicTime.getHours() + ":" + periodicTime.getMinutes() + ":" + periodicTime.getSeconds());
                break;
            case WEEKLY:
                triggerBuilder1
                        .withSchedule(CronScheduleBuilder.weeklyOnDayAndHourAndMinute(periodicTime.getDay(), 
                                periodicTime.getHours(), periodicTime.getMinutes()));
                break;
            case MONTHLY:
                triggerBuilder1
                        .withSchedule(CronScheduleBuilder.monthlyOnDayAndHourAndMinute(periodicTime.getDate(), 
                                periodicTime.getHours(), periodicTime.getMinutes()));
                break;    
            default:
        }
        return triggerBuilder1.build();
    }
    
    private void startScheduler(Scheduler scheduler, Date startTime, Date endTime) throws SchedulerException {
//        Scheduler scheduler = schedulerFactory.getScheduler();
        Long executionTime = new Date(System.currentTimeMillis()).after(startTime) ? 
                endTime.getTime() - System.currentTimeMillis() : System.currentTimeMillis();
        scheduler.start();
        // Timer to shut the fuck up down
//        Thread.sleep(executionTime);
//        scheduler.shutdown();
    }
}
