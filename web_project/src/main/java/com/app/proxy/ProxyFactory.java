package com.app.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by rajdeep siddhapura.
 */
public class ProxyFactory
{
	public static <T> T newInstance(T obj)
	{
		return (T) Proxy.newProxyInstance(
			obj.getClass().getClassLoader(),
			obj.getClass().getInterfaces(),
			new AppInvocationHandler(obj));
	}
}
