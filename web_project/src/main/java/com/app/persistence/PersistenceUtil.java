package com.app.persistence;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.exception.ConstraintViolationException;

import com.app.persistence.model.Model;
import com.app.rest.errorhandling.AppException;
import com.app.util.constants.Constant;
import com.app.util.database.DBConstraints;
import com.app.util.database.SessionManager;
import com.app.util.audit.AuditUtil;
import org.hibernate.proxy.HibernateProxy;

/**
 * Created by rajdeep siddhapura.
 */
public class PersistenceUtil
{
	protected static Model prePersistenceHandler(Model model)
	{
		return model;
	}

	protected static Model postPersistenceHandler(Model model)
	{
		return model;
	}

	public static AppException handleViolatedConstraints(ConstraintViolationException ex) throws AppException
	{
		String constraintName = ex.getConstraintName();

		if (constraintName != null)
		{
			DBConstraints dbConstraints = null;
			try
			{
				dbConstraints = DBConstraints.valueOf(constraintName);
				return new AppException(Constant.STATUS_CODE,
					dbConstraints.getCode(),
					dbConstraints.getMsg());
			}
			catch (IllegalArgumentException e)
			{
				AuditUtil.audit("Add '" + constraintName + "' db constraint to com.app.util.database.DBConstraints enum.");
			}
		}

		DBConstraints dbConstraints = DBConstraints.default_exception;
		return new AppException(Constant.STATUS_CODE,
			dbConstraints.getCode(),
			dbConstraints.getMsg());
	}

	public static Query createQuery(String queryString)
	{
		Session session = SessionManager.getSession(Thread.currentThread(), true);
		Query query = session.createQuery(queryString);
		return query;
	}

	public static Query setQueryParameter(Query query, String key, Object value)
	{
		query.setParameter(key, value);
		return query;
	}

	public static Criteria createCriteria(Class clazz)
	{
		Session session = SessionManager.getSession(Thread.currentThread(), true);
		Criteria criteria = session.createCriteria(clazz);
		return criteria;
	}

	public static Criteria addToCriteria(Criteria criteria, Criterion criterion)
	{
		criteria.add(criterion);
		return criteria;
	}

	public static <T> T unproxy(T entity) {
		if (entity == null) {
			return null;
		}

		Hibernate.initialize(entity);
		if (entity instanceof HibernateProxy) {
			entity = (T) ((HibernateProxy) entity).getHibernateLazyInitializer()
					.getImplementation();
		}
		return entity;
	}
}
