package com.app.persistence;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;

import com.app.persistence.model.Model;
import com.app.rest.errorhandling.AppException;

/**
 * Created by rajdeep siddhapura.
 */
public class PersistenceAPI
{

	private static Persistence getPersistenceInstance()
	{
		return PersistenceImpl.getInstance();
	}

	public static Model get(Class modelClass, Serializable id) throws AppException
	{
		return getPersistenceInstance().get(modelClass, id);
	}

	public static Model get(Query query) throws AppException
	{
		return getPersistenceInstance().get(query);
	}

	public static List<Model> getList(Query query) throws AppException
	{
		return getPersistenceInstance().getList(query);
	}

	public static List<Model> get(Criteria criteria) throws AppException
	{
		return getPersistenceInstance().get(criteria);
	}

	public static Model saveOrUpdate(Model model) throws AppException
	{
		PersistenceUtil.prePersistenceHandler(model);
		model = getPersistenceInstance().update(model);
		PersistenceUtil.postPersistenceHandler(model);
		return model;
	}

	public static void delete(Model model) throws AppException
	{
		getPersistenceInstance().delete(model);
	}
}
