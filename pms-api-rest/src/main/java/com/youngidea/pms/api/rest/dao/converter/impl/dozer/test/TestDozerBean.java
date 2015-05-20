package com.youngidea.pms.api.rest.dao.converter.impl.dozer.test;

import com.youngidea.pms.api.rest.dao.converter.impl.dozer.ItemPriceDestDozerTest;
import com.youngidea.pms.api.rest.dao.converter.impl.dozer.ItemPriceSrcDozerTest;
import org.dozer.DozerBeanMapper;

import java.util.ArrayList;

/**
 * Created by sean on 5/2/15.
 */
public class TestDozerBean {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("RestModelsMapping.xml");
        DozerBeanMapper mapper = new DozerBeanMapper(list);
        ItemPriceSrcDozerTest pSrc = new ItemPriceSrcDozerTest();
        pSrc.setStatusId(new Long("7"));
        pSrc.setId(new Long("1"));
        pSrc.setPrice(70);

        ItemPriceDestDozerTest pDest = new ItemPriceDestDozerTest();

//        MyPerson p = new MyPerson();
//        p.setAge(333);
//        p.setName("XX");
//        p.setDoorNo(13);
//        p.setStName("street11");
//        p.setCname("India");
//        p.setCcode("111");
//        p.setFd(23.45F);
//        Person1 p1 = new Person1();
//        mapper.map(p, p1, "a");
//        System.out.println(p1.getAge1());
//        System.out.println(p1.getName1());
//        System.out.println(p1.getAdrs1().getDoorNo1());
        mapper.map(pSrc, pDest);
        System.out.println(pDest.getId());
//        System.out.println(pDest.getItemStatus().getId());
        System.out.println(pDest.getPrice());
    }
}
