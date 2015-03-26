package com.youngidea.pms.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by sean on 3/26/15.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dto1")
public class dto1 {
    @XmlAttribute
    private String myName;
    @XmlAttribute
    private int myAge;
    @XmlAttribute
    private String company;
    @XmlAttribute
    private String shit;

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public int getMyAge() {
        return myAge;
    }

    public void setMyAge(int myAge) {
        this.myAge = myAge;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getShit() {
        return shit;
    }

    public void setShit(String shit) {
        this.shit = shit;
    }
}
