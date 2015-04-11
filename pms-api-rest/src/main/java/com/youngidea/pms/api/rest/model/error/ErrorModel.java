package com.youngidea.pms.api.rest.model.error;

/**
 * Created by sean on 4/11/15.
 */
public class ErrorModel {
    private static final StringBuilder SB = new StringBuilder();

    // Model Name + with Attribute name + inValidValue + what's up
    private String message;
    private Object model;
    private Object invalidValue;

    public ErrorModel(String message, Object invalidValue, Object model) {
        this.message = message;
        this.invalidValue = invalidValue;
        this.model = model;
    }

    public ErrorModel(Object model, String attributeName, Object invalidValue, String error) {
        this.message = createMessage(model, attributeName, invalidValue, error);
        this.model = model;
        this.invalidValue = invalidValue;
    }

    public String createMessage(Object model, String attributeName, Object invalidValue, String error) {
        return SB.append(model.getClass().getSimpleName()).append(" with ").append(attributeName)
                .append(invalidValue.toString()).append(error).toString();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getModel() {
        return model;
    }

    public void setModel(Object model) {
        this.model = model;
    }

    public Object getInvalidValue() {
        return invalidValue;
    }

    public void setInvalidValue(Object invalidValue) {
        this.invalidValue = invalidValue;
    }
}
