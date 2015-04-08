package com.youngidea.pms.api.rest.model.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by sean on 4/4/15.
 */
public class NotFoundError {
    private static Logger LOGGER = LoggerFactory.getLogger(NotFoundError.class);

    private String message;
    private Object invalidValue;

    public NotFoundError(String modelName, Object invalidValue) {
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
