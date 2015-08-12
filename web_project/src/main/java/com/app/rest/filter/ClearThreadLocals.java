package com.app.rest.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import com.app.threadlocal.UserThreadLocal;

/**
 * Created by rajdeep siddhapura.
 */
@Provider
public class ClearThreadLocals implements ContainerResponseFilter
{

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		UserThreadLocal.unsetUser();
		System.out.println("Filter: " + getClass().toString());
	}
}
