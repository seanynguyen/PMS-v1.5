package com.youngidea.pms.core.api.rest.exception;

/**
 * Created by sean on 5/9/15.
 */
public class ModelNameDuplicationException extends Exception {

    private static final String DUPLICATION_MESSAGE_PHRASE = " 's name is duplicated";
    private static final StringBuilder exceptionStringBuilder = new StringBuilder();

    private Object invalidModel;
    private Object invalidValue;
    private String message;

    // some default exception constructors
    public ModelNameDuplicationException() {
    }

    public ModelNameDuplicationException(String msg) {
        super(msg);
    }

    public ModelNameDuplicationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ModelNameDuplicationException(Object invalidModel, Object invalidValue) {
        super(exceptionStringBuilder.append(invalidModel.getClass().getSimpleName())
                .append(DUPLICATION_MESSAGE_PHRASE).toString());
        this.invalidModel = invalidModel;
        this.invalidValue = invalidValue;
        this.message = exceptionStringBuilder.append(invalidModel.getClass().getSimpleName())
                .append(DUPLICATION_MESSAGE_PHRASE).toString();
    }

    public ModelNameDuplicationException(Object invalidModel, Object invalidValue, Throwable cause) {
        super(exceptionStringBuilder.append(invalidModel.getClass().getSimpleName())
                .append(DUPLICATION_MESSAGE_PHRASE).toString(), cause);
        this.invalidModel = invalidModel;
        this.invalidValue = invalidValue;
        this.message = exceptionStringBuilder.append(invalidModel.getClass().getSimpleName())
                .append(DUPLICATION_MESSAGE_PHRASE).toString();
    }

    public Object getInvalidModel() {
        return invalidModel;
    }

    public void setInvalidModel(Object invalidModel) {
        this.invalidModel = invalidModel;
    }

    public Object getInvalidValue() {
        return invalidValue;
    }

    public void setInvalidValue(Object invalidValue) {
        this.invalidValue = invalidValue;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
