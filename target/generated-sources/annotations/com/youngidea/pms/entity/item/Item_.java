package com.youngidea.pms.entity.item;

import com.youngidea.pms.entity.PMSEntity_;
import com.youngidea.pms.entity.item.Category;
import com.youngidea.pms.entity.item.ItemPrice;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-28T22:25:41")
@StaticMetamodel(Item.class)
public class Item_ extends PMSEntity_ {

    public static volatile ListAttribute<Item, ItemPrice> itemPrices;
    public static volatile SingularAttribute<Item, Category> category;
    public static volatile SingularAttribute<Item, String> description;
    public static volatile SingularAttribute<Item, String> name;
    public static volatile SingularAttribute<Item, String> imageURL;

}