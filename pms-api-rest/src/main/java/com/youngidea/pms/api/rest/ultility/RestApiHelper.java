package com.youngidea.pms.api.rest.ultility;

import javax.ws.rs.core.Response;

/**
 * Created by sean on 4/4/15.
 */
public class RestApiHelper {

    public static Response buildResponse(Response.Status status, Object model) {
        return Response.status(status).entity(model).build();
    }

}
