package com.youngidea.pms.api.rest.model.request;

import com.google.common.collect.Lists;
import com.youngidea.pms.api.rest.model.OrderRequestModel;

import java.util.List;

/**
 * Created by sean on 2/10/15.
 */
public class PromotionRuleRequestModel {
    private PromotionPriceRequestModel promotionPrices;
//    private Condition
    private List<OrderRequestModel> ruleOrders = Lists.newArrayList();
    private String description;


    public PromotionPriceRequestModel getPromotionPrices() {
        return promotionPrices;
    }

    public void setPromotionPrices(PromotionPriceRequestModel promotionPrices) {
        this.promotionPrices = promotionPrices;
    }

    public List<OrderRequestModel> getRuleOrders() {
        return ruleOrders;
    }

    public void setRuleOrders(List<OrderRequestModel> ruleOrders) {
        this.ruleOrders = ruleOrders;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
