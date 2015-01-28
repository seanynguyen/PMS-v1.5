/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.ultilities;

import com.youngidea.pms.service.BillingService;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

/**
 *
 * @author sean
 */
public class PausePromotionJob implements Job {

    public static String BILLING_SERVICE;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
//        JobKey key = context.getJobDetail().getKey();
//
//        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
//
////      String jobSays = dataMap.getString("TobeDisplayed");
//        BillingService billingService = (BillingService) dataMap.get("BillingService");

        System.out.println("OFF");
    }

}
