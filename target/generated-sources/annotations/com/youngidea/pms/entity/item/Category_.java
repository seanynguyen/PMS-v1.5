package com.youngidea.pms.entity.item;

import com.youngidea.pms.entity.PMSEntity_;
import com.youngidea.pms.entity.item.Category;
import com.youngidea.pms.entity.item.Item;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-28T22:25:41")
@StaticMetamodel(Category.class)
public class Category_ extends PMSEntity_ {

    public static volatile ListAttribute<Category, Category> childrenCategory;
    public static volatile ListAttribute<Category, Item> items;
    public static volatile SingularAttribute<Category, String> description;
    public static volatile SingularAttribute<Category, Category> parentCategory;
    public static volatile SingularAttribute<Category, String> name;

}