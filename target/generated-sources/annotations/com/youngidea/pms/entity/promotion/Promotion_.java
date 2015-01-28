package com.youngidea.pms.entity.promotion;

import com.youngidea.pms.entity.PMSEntity_;
import com.youngidea.pms.entity.promotion.PeriodicSchedule;
import com.youngidea.pms.entity.promotion.PromotionRule;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-28T18:47:59")
@StaticMetamodel(Promotion.class)
public class Promotion_ extends PMSEntity_ {

    public static volatile SingularAttribute<Promotion, PeriodicSchedule> periodicSchedule;
    public static volatile SingularAttribute<Promotion, PromotionRule> promotionRule;
    public static volatile SingularAttribute<Promotion, String> description;
    public static volatile SingularAttribute<Promotion, String> name;
    public static volatile SingularAttribute<Promotion, Long> period;

}