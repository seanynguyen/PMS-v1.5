/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.ultilities;

import com.youngidea.pms.service.BillingService;
import org.quartz.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sean
 */
public class ValidatePromotionJob implements Job {

    public static final String BILLING_SERVICE = "BillingService";
    public static final String PERIOD = "period";
    
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobKey key = context.getJobDetail().getKey();

        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
//      String jobSays = dataMap.getString("TobeDisplayed");
        BillingService billingService = (BillingService) dataMap.get("BillingService");
        Long period = dataMap.getLong("period");
        
        System.out.println(billingService.testQuartz());
        try {
            Thread.sleep(period);
        } catch (InterruptedException ex) {
            Logger.getLogger(ValidatePromotionJob.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(billingService.testQuartz2());
   }

}
