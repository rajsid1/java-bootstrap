package com.app.threadlocal;

import com.app.rest.errorhandling.AppException;
import com.app.util.constants.Constant;
import com.app.util.string.AppStringUtil;

/**
 * Created by rajdeep siddhapura.
 */
public class UserThreadLocal
{
	private static final ThreadLocal<String> user = new ThreadLocal<>();

	public static void setUser(String authtoken) throws AppException
	{
		unsetUser();
		if (AppStringUtil.isEmptyOrNull(authtoken))
		{
			throw new AppException(200, Constant.AuthToken.AUTHTOKEN_NOT_FOUND, "Authtoken not found", "Authtoken not found");

		}
		user.set(authtoken);
	}

	public static String getUser()
	{
		return user.get();
	}

	public static void unsetUser()
	{
		user.remove();
	}
}