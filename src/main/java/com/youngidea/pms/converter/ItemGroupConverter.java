/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.converter;

import com.youngidea.pms.entity.item.ItemGroup;
import com.youngidea.pms.entity.order.GroupedOrder;
import com.youngidea.pms.facade.GenericFacade;
import com.youngidea.pms.api.rest.model.OrderRequestModel;
import com.youngidea.pms.api.rest.model.request.ItemGroupRequestModel;
import com.youngidea.pms.api.rest.model.response.ItemGroupResponseModel;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author sean
 */
@Stateless
public class ItemGroupConverter extends AbstractConverter<ItemGroup, ItemGroupRequestModel, ItemGroupResponseModel>{
    
    @EJB
    private OrdersConverter orderConverter;
    
    @EJB
    private GenericFacade genericFacade;
    
    @Override
    public ItemGroupResponseModel convert(ItemGroup input, ItemGroupResponseModel output) {
        ItemGroupResponseModel itemGroupResponseModel = output == null ? new ItemGroupResponseModel() : output;
        super.convert(input, itemGroupResponseModel);
        itemGroupResponseModel.setName(input.getName());
        itemGroupResponseModel.setDescription(input.getDescription());
        itemGroupResponseModel.setPrice(input.getPrice());
        for (GroupedOrder groupedOrder : input.getGroupedOrders()) {
            itemGroupResponseModel.getOrderResponseModels()
                    .add(orderConverter.convert(groupedOrder, null));
        }
        return itemGroupResponseModel;
    }
    
    @Override
    public ItemGroup convertBack(ItemGroupRequestModel input, ItemGroup output) {
        ItemGroup itemGroup = output == null ? new ItemGroup() : output;
        itemGroup.setName(input.getName());
        itemGroup.setDescription(input.getDescription());
        itemGroup.setPrice(input.getPrice());
        for (OrderRequestModel orderRequestModel : input.getOrderRequestModels()) {
            itemGroup.addGroupedOrder((GroupedOrder) orderConverter.convertBack(orderRequestModel, new GroupedOrder()));
        }
        return itemGroup;
    }
    
}
