package com.app.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.persistence.PersistenceUtil;
import com.app.rest.errorhandling.AppException;
import com.app.util.constants.Constant;
import com.app.util.database.SessionManager;

/**
 * Created by rajdeep siddhapura.
 */
public class AppInvocationHandler implements InvocationHandler
{
	private static final Logger LOGGER = LoggerFactory.getLogger(AppInvocationHandler.class);

	private Object obj;

	public AppInvocationHandler(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		Object result;
		Session session = SessionManager.getSession(Thread.currentThread(), true);
		Transaction transaction = session.beginTransaction();
		try
		{
			result = method.invoke(obj, args);
			transaction.commit();
		}
		catch (InvocationTargetException e)
		{
			transaction.rollback();
			Throwable cause = e.getCause();
			if (cause instanceof AppException) {
				throw cause;
			}
			if (cause instanceof javax.validation.ConstraintViolationException)
			{
				throw new AppException(Constant.Json.INVALID_NODE_VALUE, cause.getMessage());
			}
			throw e;
		}
		catch (ConstraintViolationException e)
		{
			PersistenceUtil.handleViolatedConstraints(e);
			transaction.rollback();
			throw e;
		}
		catch (javax.validation.ConstraintViolationException e)
		{
			transaction.rollback();
			String message = e.getConstraintViolations().iterator().next().getMessage();
			throw new AppException(Constant.Json.INVALID_NODE_VALUE, message);
		}
		catch (Exception e)
		{
			transaction.rollback();
			throw e;
		}
		finally
		{
			SessionManager.closeSession(Thread.currentThread());
		}
		return result;
	}
}
