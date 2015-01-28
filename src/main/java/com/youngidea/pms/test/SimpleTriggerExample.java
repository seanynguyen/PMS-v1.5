/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.test;

/**
 *
 * @author sean
 */
import java.util.Date;
import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.JobBuilder.newJob;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import static org.quartz.TriggerBuilder.newTrigger;
import org.quartz.impl.StdSchedulerFactory;

public class SimpleTriggerExample {

    public static void main(String[] args) throws Exception {
        JobDetail job = newJob(HelloJob.class)
                .withIdentity("job", "group1")
                .build();
        job.getJobDataMap().put("TobeDisplayed", "YEAHHHHH");
        //configure the scheduler time
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();

        Date runTime = evenMinuteDate(new Date());

// Trigger the job to run on the next round minute
        Trigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(5).repeatForever())
                .build();

        // Tell quartz to schedule the job using our trigger
        sched.scheduleJob(job, trigger);
        sched.start();
        Thread.sleep(30L * 1000L);
        sched.shutdown(true);
    }
}
