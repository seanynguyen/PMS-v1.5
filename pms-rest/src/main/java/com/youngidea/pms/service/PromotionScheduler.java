/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.youngidea.pms.service;

import com.youngidea.pms.entity.promotion.Promotion;
import org.quartz.SchedulerException;

import javax.ejb.Local;

/**
 *
 * @author sean
 */
@Local
public interface PromotionScheduler {
    
    public void schedule(final Promotion promotion) throws SchedulerException;
}
