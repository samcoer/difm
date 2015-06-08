package com.cerebsoft.fw.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * 
 *         Generic interface that has to be implemented by specific
 *         implementation of a persistence technology.
 * 
 * @param <T>
 *            - If, say, we are working with an Entity called "User", then a
 *            concrete implementation of BaseDAo, say, UserDao is going to pass
 *            along User object in the class declaration.
 * @param <PK>
 *            - This is the primary key for an entity that we need to search.
 */
public interface BaseDao<T, PK extends Serializable> {

	public List<T> findAll(Class<T> type) throws Exception;

	public T find(Class<T> type, PK primaryKey) throws Exception;

	public PK create(T type) throws Exception;

	public void update(T type) throws Exception;

	public void delete(T type) throws Exception;
	
	public void delete(Class<T> type, PK id) throws Exception;

	public void lock(T type) throws Exception;
}
