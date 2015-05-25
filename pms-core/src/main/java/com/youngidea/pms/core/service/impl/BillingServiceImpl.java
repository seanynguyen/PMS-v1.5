package com.youngidea.pms.core.service.impl;

import com.google.common.collect.Lists;
import com.youngidea.pms.core.bean.OrderList;
import com.youngidea.pms.core.entity.order.BillingOrder;
import com.youngidea.pms.core.entity.order.DiscountOrder;
import com.youngidea.pms.core.entity.order.PriceOrder;
import com.youngidea.pms.core.facade.GenericFacade;
import com.youngidea.pms.core.service.BillingService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import java.util.List;

/**
 * Created by sean on 5/23/15.
 */
@Stateful
public class BillingServiceImpl implements BillingService {

    @EJB
    private GenericFacade genericFacade;

//    @EJB
//    private PromotionHandler promotionHandler;

//    private List<Promotion> promotions;

    private OrderList<BillingOrder> currentOrders;

    private List<DiscountOrder> discountOrders;

    private List<PriceOrder> extraOrders;

    private int total;

    private int calculatedTotal;

    @PostConstruct
    private void init() {
        currentOrders = new OrderList();
        discountOrders = Lists.newArrayList();
        extraOrders = Lists.newArrayList();
        total = 0;
        calculatedTotal = 0;
    }

    @Override
    public void addOrder(BillingOrder order) {
        // Converter
        currentOrders.add(order);
        total = total + order.getItemPrice().getPrice();
//        processCurrentOrders();
    }

    @Override
    public void removeOrder(BillingOrder order) {
        if (currentOrders.contains(order)) {
            currentOrders.remove(order);
            total = total - order.getItemPrice().getPrice();
        }
//        processCurrentOrders();
        // Should through some kind of exception to notice error
    }

    @Override
    public void resetOrders() {
        currentOrders.clear();
//        resetPricesOrders();
        total = 0;
        calculatedTotal = 0;
    }

//    private void processCurrentOrders() {
//        // This is hardcode promotion prices with the id of 1
//        List<PromotionPrice> promotionPrices = promotionHandler.retrievePromotionPrices(
//                genericFacade.find(PromotionRule.class, 1),
//                currentOrders); // for now, I will set the static data for promotion
//        calculatedTotal = new Integer(total);
//        // reset the old prices
//        resetPricesOrders();
//        for (PromotionPrice promotionPrice : promotionPrices) {
//            // re-add prices
//            addPricesOrders(promotionPrice);
//            for (DiscountOrder discountOrder : promotionPrice.getDiscountOrders()) {
//                OrderRequestModel discountOrderBean = OrdersConverter.convert(discountOrder);
//                discountOrderBean.setDiscount(discountOrder.getDiscountPercent());
//                calculatedTotal = calculatedTotal - calculateDiscount(discountOrderBean);
//            }
//        }
//    }

//    private void resetPricesOrders() {
//        discountOrders.clear();
//        extraOrders.clear();
//    }
//
//    private void addPricesOrders(PromotionPrice promotionPrice) {
//        discountOrders.addAll(promotionPrice.getDiscountOrders());
//        extraOrders.addAll(promotionPrice.getExtraOrders());
//    }

    @Override
    public int getTotal() {
        return total;
    }

//    @Override
//    public int getCalculatedTotal() {
//        return calculatedTotal;
//    }

//    @Override
//    public List<OrderResponseModel> getCurrentOrders() {
//        List<OrderResponseModel> orderResponseModels = Lists.newArrayList();
//        for (OrderRequestModel orq : this.currentOrders) {
//            orderResponseModels.add(ordersConverter.convert(orq, null));
//        }
//        return orderResponseModels;
//    }

//    @Override
//    public List<OrderResponseModel> getExtraOrder() {
//        // Need to Convert first
//        List<OrderResponseModel> orderResponseList = Lists.newArrayList();
//        for (PriceOrder priceOrder : extraOrders) {
//            if(!(priceOrder instanceof DiscountOrder)) {
////                extraOrders.remove(priceOrder);
//                orderResponseList.add(ordersConverter.convert(priceOrder, null));
//            }
//        }
//        return orderResponseList;
//    }

//    @Override
//    public List<OrderResponseModel> getDiscountOrders() {
//        List<OrderResponseModel> orderResponseList = Lists.newArrayList();
//        for (DiscountOrder discountOrder : discountOrders) {
//            orderResponseList.add(ordersConverter.convert(discountOrder, null));
//        }
//        return orderResponseList;
//    }
//
//    // calculate to be substract discount
//    private int calculateDiscount(OrderRequestModel order) {
//        return order.getDiscount() * calculateOrderPrice(order) / (100 - order.getDiscount());
//    }

}
