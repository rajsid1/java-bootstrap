package com.app.persistence;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import com.app.persistence.model.Model;
import com.app.rest.errorhandling.AppException;
import com.app.util.database.SessionManager;

/**
 * Created by rajdeep siddhapura.
 */
public class PersistenceImpl implements Persistence
{
	private static PersistenceImpl sInstance;

	private PersistenceImpl() {
	}

	public static PersistenceImpl getInstance() {
		if (sInstance == null) {
			synchronized (PersistenceImpl.class) {
				if (sInstance == null) {
					sInstance = new PersistenceImpl();
				}
			}
		}
		return sInstance;
	}

	@Override
	public Model get(Class modelClass, Serializable id) throws AppException {
		Session session = SessionManager.getSession(Thread.currentThread(), true);
		Model model = (Model) session.get(modelClass, id);
		return model;
	}

	@Override
	public Model get(Query query)
	{
		Model model = (Model) query.uniqueResult();
		return model;
	}

	@Override
	public List<Model> getList(Query query)
	{
		List<Model> models = query.list();
		return models;
	}

	@Override
	public List<Model> get(Criteria criteria)
	{
		List<Model> list = criteria.list();
		return list;
	}

	@Override
	public Model update(Model model) throws AppException
	{
		Session session = SessionManager.getSession(Thread.currentThread(), true);
		session.saveOrUpdate(model);
		return model;
	}

	@Override
	public void delete(Model model) throws AppException
	{
		Session session = SessionManager.getSession(Thread.currentThread(), true);
		session.delete(model);
	}
}
