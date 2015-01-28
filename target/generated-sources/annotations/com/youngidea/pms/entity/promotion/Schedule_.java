package com.youngidea.pms.entity.promotion;

import com.youngidea.pms.entity.PMSEntity_;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-28T22:25:41")
@StaticMetamodel(Schedule.class)
public class Schedule_ extends PMSEntity_ {

    public static volatile SingularAttribute<Schedule, Date> startTime;
    public static volatile SingularAttribute<Schedule, Boolean> isActive;
    public static volatile SingularAttribute<Schedule, Date> endTime;

}