package com.youngidea.pms.entity.order;

import com.youngidea.pms.entity.PMSEntity_;
import com.youngidea.pms.entity.item.ItemPrice;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-28T18:47:59")
@StaticMetamodel(GeneralOrder.class)
public abstract class GeneralOrder_ extends PMSEntity_ {

    public static volatile SingularAttribute<GeneralOrder, Integer> quantity;
    public static volatile SingularAttribute<GeneralOrder, ItemPrice> itemPrice;

}