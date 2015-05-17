package com.youngidea.pms.exception;

/**
 * Created by sean on 5/9/15.
 */
public class EntityNameDuplicationException extends Exception {
    private static final String DUPLICATION_MESSAGE = " 's name is duplicated";

    public EntityNameDuplicationException() {
        super(DUPLICATION_MESSAGE);
    }

    public EntityNameDuplicationException(Throwable cause) {
        super(DUPLICATION_MESSAGE, cause);
    }
}
