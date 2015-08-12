package com.app.rest.response;

import com.app.util.constants.Constant;

/**
 * Created by rajdeep siddhapura.
 */
public enum ResponseEnum
{
	SERVER_ERROR(Constant.SERVER_ERROR, "SERVER ERROR");

	int code;
	String msg;

	ResponseEnum(int code, String msg)
	{
		this.code = code;
		this.msg = msg;
	}

	public int getCode()
	{
		return code;
	}

	public String getMsg()
	{
		return msg;
	}
}
