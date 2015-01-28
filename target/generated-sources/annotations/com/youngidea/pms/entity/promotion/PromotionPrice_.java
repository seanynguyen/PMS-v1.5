package com.youngidea.pms.entity.promotion;

import com.youngidea.pms.entity.order.DiscountOrder;
import com.youngidea.pms.entity.order.PriceOrder;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-28T18:47:59")
@StaticMetamodel(PromotionPrice.class)
public class PromotionPrice_ { 

    public static volatile SingularAttribute<PromotionPrice, Integer> id;
    public static volatile ListAttribute<PromotionPrice, PriceOrder> priceOrders;
    public static volatile SingularAttribute<PromotionPrice, String> description;
    public static volatile ListAttribute<PromotionPrice, DiscountOrder> discountOrders;

}