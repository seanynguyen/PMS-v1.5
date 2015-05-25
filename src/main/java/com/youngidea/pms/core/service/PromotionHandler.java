/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.youngidea.pms.core.service;

import com.youngidea.pms.core.ultilities.OrdersList;
import com.youngidea.pms.core.entity.promotion.PromotionPrice;
import com.youngidea.pms.core.entity.promotion.PromotionRule;

import java.util.List;

/**
 *
 * @author sean
 */
public interface PromotionHandler {
    List<PromotionPrice> retrievePromotionPrices(PromotionRule promotionRule, OrdersList customerOrders);
}
