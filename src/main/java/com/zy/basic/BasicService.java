package com.zy.basic;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@Transactional
public abstract class BasicService implements BasicServiceInter {
	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Object findById(Class clazz, Serializable id) {

		return this.sessionFactory.getCurrentSession().get(clazz, id);
	}

	@Override
	public List execuyteQuery(String hql, Object[] parameters) {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if (parameters != null && parameters.length > 0)
			for (int i = 0; i < parameters.length; i++) {
				query.setParameter(i, parameters[i]);
			}
		return query.list();
	}

	@Override
	public List executeQueryByPage(String hql, Object[] parameters,
			int pageNow, int pageSize) {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if (parameters != null && parameters.length > 0)
			for (int i = 0; i < parameters.length; i++) {
				query.setParameter(i, parameters[i]);
			}
		query.setFirstResult((pageNow - 1) * pageSize);
		query.setMaxResults(pageSize);

		return query.list();
	}

	@Override
	public void add(Object obj) {
		this.sessionFactory.getCurrentSession().save(obj);
	}

	@Override
	public int executeUpdate(String hql, Object[] parameters) {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if (parameters != null && parameters.length > 0)
			for (int i = 0; i < parameters.length; i++) {
				query.setParameter(i, parameters[i]);
			}
		return query.executeUpdate();
	}

	public Object uniqueQuery(String hql, Object[] parameters) {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if (parameters != null && parameters.length > 0)
			for (int i = 0; i < parameters.length; i++) {
				query.setParameter(i, parameters[i]);
			}
		return query.uniqueResult();
	}

	@Override
	public int queryPageCount(String hql, Object[] parameters, int pageSize) {
		Object obj = this.uniqueQuery(hql, parameters);
		int rowCount = Integer.parseInt(obj.toString());
		return (rowCount - 1) / pageSize + 1;
	}

	public void delById(Class clazz, Serializable id) {

		Session session = this.sessionFactory.getCurrentSession();
		session.delete(this.findById(clazz, id));
	}

	@Override
	public void update(Object obj) {
		this.sessionFactory.getCurrentSession().update(obj);
	}

	@Override
	public List queryLimit(String hql, Object[] parameters, int firstResult,
			int maxResults) {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		if (parameters != null && parameters.length > 0)
			for (int i = 0; i < parameters.length; i++) {
				query.setParameter(i, parameters[i]);
			}
		query.setFirstResult(firstResult).setMaxResults(maxResults);
		return query.list();
	}

	public Object backClazz(Class clazz, Serializable id) {
		return this.sessionFactory.getCurrentSession().load(clazz, id);
	}
}
