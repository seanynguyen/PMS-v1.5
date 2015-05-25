package com.youngidea.pms.api.rest.exception.mapper;

import com.youngidea.pms.api.rest.exception.ModelNameDuplicationException;
import com.youngidea.pms.api.rest.model.error.ErrorModel;
import com.youngidea.pms.api.rest.ultility.RestApiHelper;

import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.core.Response;

/**
 * Created by sean on 5/18/15.
 */
@javax.ws.rs.ext.Provider
public class ModelNameDuplicationExceptionMapper implements ExceptionMapper<ModelNameDuplicationException> {

    public ModelNameDuplicationExceptionMapper() {

    }

    @Override
    public Response toResponse(ModelNameDuplicationException modelNameDuplicationException) {
        ErrorModel errorModel = new ErrorModel(modelNameDuplicationException.getMessage(), modelNameDuplicationException.getInvalidValue(),
                modelNameDuplicationException.getInvalidModel());
        return RestApiHelper.buildResponse(Response.Status.BAD_REQUEST, errorModel);
    }
}
