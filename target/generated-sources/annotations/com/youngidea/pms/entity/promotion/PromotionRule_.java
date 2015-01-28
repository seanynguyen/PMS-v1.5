package com.youngidea.pms.entity.promotion;

import com.youngidea.pms.entity.order.RuleOrder;
import com.youngidea.pms.entity.promotion.Promotion;
import com.youngidea.pms.entity.promotion.PromotionPrice;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-28T22:25:41")
@StaticMetamodel(PromotionRule.class)
public class PromotionRule_ { 

    public static volatile SingularAttribute<PromotionRule, Integer> id;
    public static volatile ListAttribute<PromotionRule, Promotion> promotions;
    public static volatile ListAttribute<PromotionRule, RuleOrder> ruleOrders;
    public static volatile SingularAttribute<PromotionRule, PromotionPrice> promotionPrice;

}