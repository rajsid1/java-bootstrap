package com.app.util.database;

/**
 * Created by rajdeep siddhapura.
 */
public enum DBConstraints
{

	default_exception(1001, "Contact App support");

	int code;
	String msg;

	DBConstraints(int code, String msg)
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
