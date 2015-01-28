package com.youngidea.pms.test;

import com.youngidea.pms.entity.PMSEntity_;
import java.sql.Time;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-28T18:47:59")
@StaticMetamodel(DateTimeTest.class)
public class DateTimeTest_ extends PMSEntity_ {

    public static volatile SingularAttribute<DateTimeTest, Date> created;
    public static volatile SingularAttribute<DateTimeTest, Time> timeField;
    public static volatile SingularAttribute<DateTimeTest, Date> modified;

}