package com.app.util.bean;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * Created by rajdeep siddhapura.
 */
public class Dozer
{
	private static final Mapper INSTANCE = new DozerBeanMapper();

	public static Mapper getInstance()
	{
		return INSTANCE;
	}

	public static <T> T convert(Object srcObject, Class<T> destClass)
	{
		return INSTANCE.map(srcObject, destClass);
	}

	public static <T> T convert(Object srcObject, T destObject)
	{
		return (T) INSTANCE.map(srcObject, destObject.getClass());
	}
}
