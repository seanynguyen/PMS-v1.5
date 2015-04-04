/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.api.rest.model;

import com.youngidea.pms.api.rest.model.AbstractModel;
import com.youngidea.pms.api.rest.model.validator.ValidStatus;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;

/**
 *
 * @author sean
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "ItemStatus")
@ValidStatus
public class ItemStatusModel extends AbstractModel {
    final static private String DEFAULT_IMG_URL = "blahblah";

    @NotNull
    @Size(min = 2, max = 10, message = "{person.name.size}") // dua ra property file min, max
//    @XmlAttribute(name = "statusName")
    private String statusName;

//    @XmlAttribute(name = "imageURL")
    private String imageURL = DEFAULT_IMG_URL;

//    @XmlAttribute(name = "description")
    private String description;
    
        
    public ItemStatusModel() {
        
    }

    public ItemStatusModel(Long id) {
        super(id);
    }
    
    public ItemStatusModel(String statusName, String decription, String imageURL) {
        this.statusName = statusName;
        this.description = decription;
        this.imageURL = imageURL;
    }
    
    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
