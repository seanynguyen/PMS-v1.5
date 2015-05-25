package com.youngidea.pms.core.api.rest.model.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    // Model Name + with Attribute name + inValidValue + what's up
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
