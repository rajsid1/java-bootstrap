package com.app.rest.errorhandling;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by rajdeep siddhapura.
 */

@Provider
public class AppExceptionMapper implements ExceptionMapper<AppException> {

    public AppExceptionMapper() {
        System.out.println("AppExceptionMapper is created");
    }

    @Override
    public Response toResponse(AppException exception) {
        return Response.status(exception.getStatus())
                .entity(new ErrorMessage(exception))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
