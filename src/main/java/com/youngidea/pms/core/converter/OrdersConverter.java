/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.core.converter;

import com.youngidea.pms.core.api.rest.model.OrderRequestModel;
import com.youngidea.pms.core.api.rest.model.response.OrderResponseModel;
import com.youngidea.pms.core.entity.item.ItemPrice;
import com.youngidea.pms.core.entity.order.DiscountOrder;
import com.youngidea.pms.core.entity.order.GeneralOrder;
import com.youngidea.pms.core.facade.GenericFacade;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author sean
 */
// fix equal function of orderbean
@Stateless
public class OrdersConverter<T extends GeneralOrder> extends AbstractConverter<T, OrderRequestModel, OrderResponseModel>{
    
    @EJB
    private GenericFacade genericFacade;
    
    @EJB
    private ItemConverter itemConverter;
    
    public static <T extends GeneralOrder> OrderRequestModel convert(T input) {
        OrderRequestModel output = new OrderRequestModel();
        output.setId(input.getId());
        //output.setItemBean(ItemConverter.itemBeanConvert(input.getItem()));
        output.setPriceId(input.getItemPrice().getId());
        output.setQuantity(input.getQuantity());
        return output;
    }
    
    @Override
    public OrderResponseModel convert(T input, OrderResponseModel output) {
        OrderResponseModel orderResponseModel = output == null ? new OrderResponseModel() : output;
        if (input.getId() != null) {
            super.convert(input, orderResponseModel);
        }
//        orderResponseModel.setItemName(input.getItemPrice().getItem().getName());
//        orderResponseModel.setItemStatus(input.getItemPrice().getItemStatus().getName());
        orderResponseModel.setItemUnit(itemConverter.convertToItemUnit(input.getItemPrice(), null));
        orderResponseModel.setQuantity(input.getQuantity());
        if (input instanceof DiscountOrder) {
            orderResponseModel.setDiscount(DiscountOrder.class.cast(input).getDiscountPercent());
        } 
        return orderResponseModel;
    }
    
    @Override
    public T convertBack(OrderRequestModel input, T output) {
        if (output == null) {return null;} // not allow null output
        output.setItemPrice(genericFacade.find(ItemPrice.class, input.getPriceId()));
        output.setQuantity(input.getQuantity());
        if (output instanceof DiscountOrder) {
            DiscountOrder.class.cast(output).setDiscountPercent(input.getDiscount());
        }
        return output;
    }

    public OrderResponseModel convert(OrderRequestModel input, OrderResponseModel output) {
        OrderResponseModel orderResponseModel = output == null ? new OrderResponseModel() : output;
        if (input.getId() != null) {
            orderResponseModel.setId(input.getId());
        }
        orderResponseModel.setQuantity(input.getQuantity());
        orderResponseModel.setDiscount(input.getDiscount());
        orderResponseModel.setItemUnit(itemConverter.convertToItemUnit(genericFacade.find(ItemPrice.class, 
                input.getPriceId()), null));
        return orderResponseModel;
    }
    
}
