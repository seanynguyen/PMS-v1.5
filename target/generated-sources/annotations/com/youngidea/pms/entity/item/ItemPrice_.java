package com.youngidea.pms.entity.item;

import com.youngidea.pms.entity.PMSEntity_;
import com.youngidea.pms.entity.item.Item;
import com.youngidea.pms.entity.item.ItemStatus;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-28T22:25:41")
@StaticMetamodel(ItemPrice.class)
public class ItemPrice_ extends PMSEntity_ {

    public static volatile SingularAttribute<ItemPrice, Integer> price;
    public static volatile SingularAttribute<ItemPrice, Item> item;
    public static volatile SingularAttribute<ItemPrice, ItemStatus> itemStatus;

}