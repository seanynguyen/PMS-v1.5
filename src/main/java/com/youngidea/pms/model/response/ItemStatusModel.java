/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.model.response;

import com.youngidea.pms.model.AbstractBean;

/**
 *
 * @author sean
 */
public class ItemStatusModel extends AbstractBean {
    final static private String DEFAULT_IMG_URL = "blahblah";
       
    
    private String statusName;
    private String imageURL = DEFAULT_IMG_URL;
    private String description;
    
        
    public ItemStatusModel() {
        
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
