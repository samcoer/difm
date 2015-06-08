package com.cerebsoft.fw.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cerebsoft.fw.dao.BaseDao;
import com.cerebsoft.fw.logger.LogLevel;
import com.cerebsoft.fw.spring.annotation.Loggable;




/**
 * 
 * 
 *         Hibernate based ORM implementation of BaseDao interface. A
 *         sessionFactory is injected to this class using spring. Methods
 *         implemented in this class are all GENERICS and can execute CRUD
 *         operations for any entity that is configured using Hibernate.
 * 
 * @param <T>
 *            - Entity upon which CRUD operations have to be applied.
 * @param <PK>
 *            - PrimaryKey of the entity upon which CRUD operations have to be
 *            applied.
 */
@Repository
public class HibernateDaoImpl<T, PK extends Serializable> implements BaseDao<T, PK> {

	@Autowired
	SessionFactory sessionFactory;

	public HibernateDaoImpl() {

	}

	public HibernateDaoImpl(SessionFactory sf) {

		this.sessionFactory = sf;
	}

	@Loggable(LogLevel.INFO)
	public Session getSession() {

		Session session = sessionFactory.getCurrentSession();

		if (session == null || !session.isOpen())
		{
			session = sessionFactory.openSession();
		}

		// Session session = sessionFactory.getCurrentSession();

		/*
		 * if(null==session || !session.isOpen()){ session =
		 * sessionFactory.openSession(); }
		 */
		session.setCacheMode(CacheMode.NORMAL);
		return session;

	}

	/**
	 * Generic method for creating an Entity in DB.
	 */
	@Loggable(LogLevel.INFO)
	@Transactional(propagation = Propagation.REQUIRED)
	@SuppressWarnings(value = "unchecked")
	public PK create(T o) {

		Session session = getSession();
		return (PK) session.save(o);

	}

	/**
	 * Generic method for searching for an entity in the DB based on primaryKey
	 * provided as an argument.
	 */
	@Loggable(LogLevel.INFO)
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	@SuppressWarnings(value = "unchecked")
	public T find(Class<T> type, PK id) {

		Session session = getSession();
		return (T) session.get(type, id);

	}

	/**
	 * Generic method for searching all the instances of an entity in the DB.
	 * The entity to be searched is given by Class<T> argument.
	 */
	@Loggable(LogLevel.INFO)
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	@SuppressWarnings(value = "unchecked")
	public List<T> findAll(Class<T> type) {

		Session session = getSession();
		return session.createQuery("from " + type.getName()).setCacheable(true).list();

	}

	/**
	 * Generic method for updating an entity in the DB.
	 */
	@Loggable(LogLevel.INFO)
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(T o) {

		Session session = getSession();
		session.saveOrUpdate(o);
	}

	/**
	 * Generic method for deleting an entity in the DB.
	 */
	@Loggable(LogLevel.INFO)
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(T o) {

		Session session = getSession();
		session.delete(o);

	}
	
	/**
	 * Generic method for deleting an entity by primary key in the DB.
	 */
	@Loggable(LogLevel.INFO)
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Class<T> type, PK id) {

		Session session = getSession();
		T o = find(type, id);
		if(null != o){
			session.delete(o);
		}
	}

	@Loggable(LogLevel.INFO)
	public void lock(T o) throws Exception {

		getSession().lock(o, LockMode.NONE);
	}

}
