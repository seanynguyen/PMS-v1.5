package com.youngidea.pms.entity.promotion;

import com.youngidea.pms.ultilities.PeriodicType;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-28T22:25:41")
@StaticMetamodel(PeriodicSchedule.class)
public class PeriodicSchedule_ extends Schedule_ {

    public static volatile SingularAttribute<PeriodicSchedule, Date> periodicStartTime;
    public static volatile SingularAttribute<PeriodicSchedule, PeriodicType> type;

}