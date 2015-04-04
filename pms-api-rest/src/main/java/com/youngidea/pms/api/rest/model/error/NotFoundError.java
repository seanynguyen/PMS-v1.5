package com.youngidea.pms.api.rest.model.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by sean on 4/4/15.
 */
public class NotFoundError {
//    private static final String PROP_FILE_NAME = "config.properties";
    private static Logger LOGGER = LoggerFactory.getLogger(NotFoundError.class);
//    private Properties prop;

    private String message;
    private Object invalidValue;

    public NotFoundError(String modelName, Object invalidValue) {
//        prop = new Properties();
//        try {
//            prop.load(getClass().getClassLoader().getResourceAsStream(PROP_FILE_NAME));
//        } catch (IOException e) {
//            LOGGER.error(e.getMessage());
//        }
        this.message = getMessage(modelName, invalidValue);
        this.invalidValue = invalidValue;
    }

    private NotFoundError() {
    }

    private String getMessage(String modelName, Object invalidValue) {
        return modelName + " with id " + invalidValue.toString() + " is not found";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getInvalidValue() {
        return invalidValue;
    }

    public void setInvalidValue(Object invalidValue) {
        this.invalidValue = invalidValue;
    }
}
