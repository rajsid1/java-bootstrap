package com.app.util.collections;

import jersey.repackaged.com.google.common.base.Function;
import jersey.repackaged.com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by rajdeep siddhapura.
 */
public class AppCollectionUtil
{
	public static <F,T> List<T> transformListToSubClass(List<F> list, Class<T> clazz)
	{
		List<T> toList= Lists.transform(list, new Function<F, T>()
		{
			@Override
			public T apply(F obj)
			{
				if (obj != null)
					return (T) obj;
				else
					return null;
			}
		});
		return toList;
	}
}
