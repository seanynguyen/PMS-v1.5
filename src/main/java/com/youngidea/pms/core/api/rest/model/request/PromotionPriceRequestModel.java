package com.youngidea.pms.core.api.rest.model.request;

import com.google.common.collect.Lists;
import com.youngidea.pms.core.api.rest.model.OrderRequestModel;

import java.util.List;

/**
 * Created by sean on 2/10/15.
 */
public class PromotionPriceRequestModel {

    private List<OrderRequestModel> priceOrders = Lists.newArrayList();
    private List<OrderRequestModel> discountOrders = Lists.newArrayList();

    public List<OrderRequestModel> getPriceOrders() {
        return priceOrders;
    }

    public void setPriceOrders(List<OrderRequestModel> priceOrders) {
        this.priceOrders = priceOrders;
    }

    public List<OrderRequestModel> getDiscountOrders() {
        return discountOrders;
    }

    public void setDiscountOrders(List<OrderRequestModel> discountOrders) {
        this.discountOrders = discountOrders;
    }
}
