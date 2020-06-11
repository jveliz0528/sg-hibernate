/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.sg.hibernate.dao.generic.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import ar.com.sg.hibernate.dao.exceptions.DuplicateException;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.generic.IGenericDAO;

public class GenericDaoImpl<Entity, K extends Serializable> implements IGenericDAO<Entity, K>{

	public Class<Entity> domainClass = getDomainClass();
	private Session session;

	protected Class getDomainClass() {
		if (domainClass == null) {
			ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
			domainClass = (Class) thisType.getActualTypeArguments()[0];
		}
		return domainClass;
	}

	private Session getHibernateTemplate() {
		session = ar.com.sg.hibernate.dao.util.HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		return session;
	}

	@Override
	public void Guardar(Entity t) throws DuplicateException {
		   try {
			    getHibernateTemplate().save(t);
			    session.getTransaction().commit();
			   } catch (HibernateException e) {
			    throw new DuplicateException("Registro Duplicado: "+ e);
			   }
	}

	@Override
	public void Actualizar(Entity t) throws GenericExeption {
		  try {
			   getHibernateTemplate().update(t);
			    session.getTransaction().commit();
			   } catch (HibernateException e) {
			    throw new GenericExeption("No se puede actualizar"+ e);
			  }
	}

	@Override
	public Entity Buscar(K id) throws GenericExeption {
		  Entity returnValue = (Entity) getHibernateTemplate().load(domainClass, id);
		  session.getTransaction().commit();
		  
		  return returnValue;
	}

	@Override
	public void Eliminar(Entity t) throws GenericExeption {
		   getHibernateTemplate().delete(t);
		   session.getTransaction().commit();		
	}


}
