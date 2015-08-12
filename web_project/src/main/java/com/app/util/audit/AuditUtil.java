package com.app.util.audit;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by rajdeep siddhapura.
 */
public class AuditUtil
{
	private static final Logger LOGGER = LoggerFactory.getLogger(AuditUtil.class);

	public static void audit(String msg)
	{
		LOGGER.warn("Msg : " + msg);
	}

	public static void audit(Throwable t)
	{
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		t.printStackTrace(pw);
		String stackTrace = sw.toString();
		LOGGER.error("Exception : " + stackTrace, t);
	}

	public static void audit(Exception e)
	{
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		String stackTrace = sw.toString();
		LOGGER.error("Exception : " + stackTrace, e);
	}
}
