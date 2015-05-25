/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.youngidea.pms.core.ultilities;

import java.util.Date;

/**
 *
 * @author sean
 */
public class SchedulerHelper {
    
    public static Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }
    
    public static Date addTimeToDate(Date currentDate, Long timeAddition) {
        return new Date(currentDate.getTime() + timeAddition);
    }
    
}
