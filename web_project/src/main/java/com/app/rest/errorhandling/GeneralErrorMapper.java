package com.app.rest.errorhandling;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import com.app.util.audit.AuditUtil;

/**
 * Created by rajdeep siddhapura.
 */
@Provider
public class GeneralErrorMapper implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable throwable)
	{
        ErrorMessage errorMessage = new ErrorMessage();
        throwable.printStackTrace();
        errorMessage.setStatus(500);
        errorMessage.setCode(1001);
        errorMessage.setMessage("error in processing");
        errorMessage.setDeveloperMessage(throwable.getMessage());

		AuditUtil.audit(throwable);

		if (throwable instanceof WebApplicationException)
		{
			errorMessage.setMessage("Invalid url/parameters/method");
		}

        return Response.status(errorMessage.getStatus())
                .entity(errorMessage)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
	//TODO: WebApplicationException
}
