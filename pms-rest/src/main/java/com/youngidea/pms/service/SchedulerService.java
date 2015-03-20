/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.youngidea.pms.service;

import com.youngidea.pms.entity.promotion.PeriodicSchedule;
import com.youngidea.pms.entity.promotion.Promotion;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;

import javax.ejb.Local;
import java.util.Date;

/**
 *
 * @author sean
 */
@Local
public interface SchedulerService {
    
    Scheduler schedule(JobDetail job, PeriodicSchedule periodicSchedule) throws SchedulerException;
    
    Date addTimeToDate(Date currentDate, Long timeAddition);

    void scheduleForPromotion(Promotion promotion) throws SchedulerException, InterruptedException;
}
