package com.app.service.sample;

import com.app.proxy.ProxyFactory;
import com.app.rest.errorhandling.AppException;

/**
 * Created by rajdeep siddhapura.
 */
public class SampleAPI
{
	private static SampleService getSampleServiceInstance()
	{
		return ProxyFactory.newInstance(SampleServiceJPAImpl.getInstance());
	}

	public static void call(String foo, String bar) throws AppException
	{
		getSampleServiceInstance().call(foo, bar);
	}
}