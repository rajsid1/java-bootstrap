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
public interface Persistence
{
	Model get(Class modelClass, Serializable id) throws AppException;

	Model get(Query query);

	List<Model> getList(Query query);

	List<Model> get(Criteria criteria);

	Model update(Model model) throws AppException;

	void delete(Model model) throws AppException;
}
