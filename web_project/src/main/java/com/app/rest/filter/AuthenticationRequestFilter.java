package com.app.rest.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.app.rest.errorhandling.AppException;
import com.app.threadlocal.UserThreadLocal;
import com.app.util.constants.Constant;

/**
 * Created by rajdeep siddhapura.
 */
@Provider
@PreMatching
public class AuthenticationRequestFilter implements ContainerRequestFilter
{
	private static String[] SKIP_AUTH_FOR = {
		"users/login",
		"users/signup"
	};

	private static boolean isSkipAuth(String uri)
	{
		for (String urlPath : SKIP_AUTH_FOR)
		{
			if (uri.contains(urlPath))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException
	{
		String uri = requestContext.getUriInfo().getAbsolutePath().getPath();
		if (isSkipAuth(uri))
		{
			return;
		}
		String authtoken = requestContext.getUriInfo().getQueryParameters().getFirst("authtoken");
		try
		{
			UserThreadLocal.setUser(authtoken);
		}
		catch (AppException e)
		{
			if (e.getCode() == Constant.AuthToken.AUTHTOKEN_NOT_FOUND || e.getCode() == Constant.AuthToken.INVALID_AUTHTOKEN)
			{
				requestContext.abortWith(Response
						.status(Response.Status.UNAUTHORIZED)
						.entity("User cannot access the resource.")
						.build());
			}
			else
			{
				throw new IOException(e.getMessage(), e);
			}
		}
	}
}
