/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.service.impl;

import com.google.common.collect.Lists;
import com.youngidea.pms.converter.OrdersConverter;
import com.youngidea.pms.entity.item.ItemPrice;
import com.youngidea.pms.entity.order.DiscountOrder;
import com.youngidea.pms.entity.order.PriceOrder;
import com.youngidea.pms.entity.promotion.Promotion;
import com.youngidea.pms.entity.promotion.PromotionPrice;
import com.youngidea.pms.entity.promotion.PromotionRule;
import com.youngidea.pms.facade.GenericFacade;
import com.youngidea.pms.model.OrderRequestModel;
import com.youngidea.pms.model.response.OrderResponseModel;
import com.youngidea.pms.service.BillingService;
import com.youngidea.pms.service.PromotionHandler;
import com.youngidea.pms.ultilities.OrdersList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author sean
 */
@Stateful
public class BillingServiceImpl implements BillingService {

    @EJB
    private GenericFacade genericFacade;

    @EJB
    private PromotionHandler promotionHandler;
    
    @EJB
    private OrdersConverter ordersConverter;
    
    private List<Promotion> promotions;

    private OrdersList currentOrders;

    private List<DiscountOrder> discountOrders;

    private List<PriceOrder> extraOrders;

    private int total;

    private int calculatedTotal;

    @PostConstruct
    private void init() {
        currentOrders = new OrdersList();
        discountOrders = Lists.newArrayList();
        extraOrders = Lists.newArrayList();
        total = 0;
        calculatedTotal = 0;
    }

    @Override
    public void addOrder(OrderRequestModel order) {
        // Converter
        currentOrders.addOrder(order);
        total = total + calculateOrderPrice(order);
        processCurrentOrders();
    }

    @Override
    public void resetOrders() {
        currentOrders.clear();
        resetPricesOrders();
        total = 0;
        calculatedTotal = 0;
    }

    @Override
    public void removeOrder(OrderRequestModel order) {
        if (currentOrders.containOrder(order)) {
            currentOrders.removeOrder(order);
            total = total - calculateOrderPrice(order);
        }
        processCurrentOrders();
        // Should through some kind of exception to notice error
    }

    private void processCurrentOrders() {
        List<PromotionPrice> promotionPrices = promotionHandler.retrievePromotionPrices(
                genericFacade.find(PromotionRule.class, 1),
                currentOrders); // for now, I will set the static data for promotion
        calculatedTotal = new Integer(total);
        // reset the old prices
        resetPricesOrders();
        for (PromotionPrice promotionPrice : promotionPrices) {
            // re-add prices
            addPricesOrders(promotionPrice);
            for (DiscountOrder discountOrder : promotionPrice.getDiscountOrders()) {
                OrderRequestModel discountOrderBean = OrdersConverter.convert(discountOrder);
                discountOrderBean.setDiscount(discountOrder.getDiscountPercent());
                calculatedTotal = calculatedTotal - calculateDiscount(discountOrderBean); 
            }
        }
    }

    private void resetPricesOrders() {
        discountOrders.clear();
        extraOrders.clear();
    }
    
    private void addPricesOrders(PromotionPrice promotionPrice) {
        discountOrders.addAll(promotionPrice.getDiscountOrders());
        extraOrders.addAll(promotionPrice.getExtraOrders());
    }
    
    @Override
    public int getTotal() {
        return total;
    }

    @Override
    public int getCalculatedTotal() {
        return calculatedTotal;
    }

    @Override
    public List<OrderResponseModel> getCurrentOrders() {
        List<OrderResponseModel> orderResponseModels = Lists.newArrayList();
        for (OrderRequestModel orq : this.currentOrders) {
            orderResponseModels.add(ordersConverter.convert(orq, null));
        }
        return orderResponseModels;
    }

    @Override
    public List<OrderResponseModel> getExtraOrder() {
        // Need to Convert first
        List<OrderResponseModel> orderResponseList = Lists.newArrayList();
        for (PriceOrder priceOrder : extraOrders) {
            if(!(priceOrder instanceof DiscountOrder)) {
//                extraOrders.remove(priceOrder);
                orderResponseList.add(ordersConverter.convert(priceOrder, null));
            }
        }
        return orderResponseList;
    }

    @Override
    public List<OrderResponseModel> getDiscountOrders() {
        List<OrderResponseModel> orderResponseList = Lists.newArrayList();
        for (DiscountOrder discountOrder : discountOrders) {
            orderResponseList.add(ordersConverter.convert(discountOrder, null));
        }
        return orderResponseList;
    }
    
    @Override
    public String testQuartz() {
        return "Added !";
    }
    
    public String testQuartz2() {
        return "Removed !";
    }

    private int calculateOrderPrice(OrderRequestModel order) {
        ItemPrice price = genericFacade.find(ItemPrice.class, order.getPriceId());
        return (int) (price.getPrice() * order.getQuantity() * (100 - order.getDiscount()) / 100.0f);
    }

    // calculate to be substract discount
    private int calculateDiscount(OrderRequestModel order) {
        return order.getDiscount() * calculateOrderPrice(order) / (100 - order.getDiscount());
    }
}
