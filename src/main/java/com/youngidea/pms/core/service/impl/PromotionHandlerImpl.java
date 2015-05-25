/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.core.service.impl;

import com.youngidea.pms.core.converter.OrdersConverter;
import com.youngidea.pms.core.entity.order.DiscountOrder;
import com.youngidea.pms.core.entity.order.RuleOrder;
import com.youngidea.pms.core.entity.promotion.PromotionCondition;
import com.youngidea.pms.core.entity.promotion.PromotionPrice;
import com.youngidea.pms.core.entity.promotion.PromotionRule;
import com.youngidea.pms.core.api.rest.model.OrderRequestModel;
import com.youngidea.pms.core.service.PromotionHandler;
import com.youngidea.pms.core.ultilities.OrdersList;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author sean
 */
@Stateless
public class PromotionHandlerImpl implements PromotionHandler {
    // tim nho nhat
    private int getRuleMatchedTimes(int ruleOrderQuan, int orderQuan, int prevSmallest) {
        int matchedTime = orderQuan / ruleOrderQuan;
//        System.out.println("Prev Smallest: " + prevSmallest);
        if (matchedTime <= prevSmallest) {
            return matchedTime;
        }
        if (prevSmallest == 0) { // initial value detected.
            return matchedTime;
        }
        return prevSmallest;
    }

    @Override
    public List<PromotionPrice> retrievePromotionPrices(PromotionRule promotionRule, OrdersList customerOrders) {
//        int ruleMatchedTimes = customerOrders.get(0).getQuantity();
        int ruleMatchedTimes = 0;
        List<PromotionPrice> promotionPrices = new ArrayList();
        boolean ruleFullfil = true;
        for (RuleOrder ruleOrder : promotionRule.getRuleOrders()) {
            boolean validated = false;
            for (OrderRequestModel orderBean : customerOrders) {
                // neu order exist trong rule
                System.out.println(">>>>>>>>>>>>>>>>> Customer Order: " + orderBean.getPriceId());
                System.out.println(">>>>>>>>>>>>>>>>> Rule Order after changed: " + OrdersConverter.convert(ruleOrder).getPriceId());
                if (orderBean.is(OrdersConverter.convert(ruleOrder))) { // co the cho nay sai
                    // chua du quantity so voi rule -> ruleMatchedTime = 0
                    // thieu truong hop = 0 -> not fullfil the rule
                    ruleMatchedTimes = getRuleMatchedTimes(ruleOrder.getQuantity(), orderBean.getQuantity(), ruleMatchedTimes);
                    System.out.println("Rule match time: ###########---------------------" + ruleMatchedTimes);
                    if (ruleMatchedTimes > 0) {validated = true;} 
                    break;
                }
            }
            System.out.println("------------------------" + validated);
            // ko tim thay dc thang nao trung
            if (!validated) {
                ruleFullfil = false;
                break;
            }
        }
        System.out.println("Final: #########################--------------------------" + ruleFullfil);
        if (ruleFullfil) {
            for (int i = 0; i < ruleMatchedTimes; ++i) {
                promotionPrices.add(promotionRule.getPromotionPrice());
            }
        }
//                        System.out.println("------------------ >>>>>>>>>>>>>>>>" + promotionPrices.get(0).getId());
        System.out.println("These are your price: ");
        for (PromotionPrice promotionPrice : promotionPrices) {
            System.out.println(promotionPrice.getId());
            for (DiscountOrder dor : promotionPrice.getDiscountOrders()) {
                System.out.println(dor.getId());
            }
        }
        return promotionPrices;
    }

    public List<PromotionPrice> a(OrdersList customerOrders, int totalPrice) {
        // do something to retrieve promotion (using ScheduleManagement)
        // for ( : promotions) { retrieve prices}
        
        return null;
    }

//    public boolean checkCondition(EventCondition eventCondition, int total, List<String> otherConditions) {
//        if (total >= eventCondition.getPriceBound()) {
//            for (CustomCondition c : eventCondition.getOtherConditions()) {
//                if (!otherConditions.contains(c.getCustomCondition())) { // khong bao gom custom cond
//                    return false;
//                }
//            }
//            return true;
//        }
//        return false;
//    }
    
    public boolean checkCondition(PromotionCondition promotionCondition, int total) {
        if (total >= promotionCondition.getPriceBound()) {
//            if (some more  custom conditions) {
            return true;
//            }
        }
        return false;
    }
        
}
