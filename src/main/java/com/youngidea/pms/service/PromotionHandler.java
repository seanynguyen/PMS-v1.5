/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.youngidea.pms.service;

import com.youngidea.pms.entity.promotion.PromotionPrice;
import com.youngidea.pms.entity.promotion.PromotionRule;
import com.youngidea.pms.ultilities.OrdersList;
import java.util.List;

/**
 *
 * @author sean
 */
public interface PromotionHandler {
    List<PromotionPrice> retrievePromotionPrices(PromotionRule promotionRule, OrdersList customerOrders);
}
