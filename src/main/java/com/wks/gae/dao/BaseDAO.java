package com.wks.gae.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

public class BaseDAO<T> {
	
	private Class<T> t;

	public BaseDAO(Class<T> t){
		this.t = t;
	}

	public Long save(T e){
		return ofy().save().entity(e).now().getId();
	}
	
	public void delete(Long id)
	{
		ofy().delete().type(t).id(id);
	}

	public List<T> list()
	{
		return ofy().load().type(t).list();
	}
	
	public T retrieve(Long id)
	{
		return ofy().load().type(t).id(id).now();
	}

}
