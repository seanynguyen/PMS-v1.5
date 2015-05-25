/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youngidea.pms.core.ultilities;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author sean
 */
@Stateless
public class PropertiesRetriever {

    private static final Properties props = new Properties();

    @PostConstruct
    private void init() {
        try {
            InputStream inputStream = MyProperties.class.getClassLoader().getResourceAsStream("default.properties");
            this.props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String getProp(String key) {
        return props.getProperty(key);
    }
    
}
