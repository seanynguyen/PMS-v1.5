package com.youngidea.pms.entity.item;

import com.youngidea.pms.entity.PMSEntity_;
import com.youngidea.pms.entity.order.GroupedOrder;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-28T18:47:59")
@StaticMetamodel(ItemGroup.class)
public class ItemGroup_ extends PMSEntity_ {

    public static volatile SingularAttribute<ItemGroup, Integer> price;
    public static volatile SingularAttribute<ItemGroup, String> description;
    public static volatile SingularAttribute<ItemGroup, String> name;
    public static volatile ListAttribute<ItemGroup, GroupedOrder> groupedOrders;

}