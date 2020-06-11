package ar.com.sg.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import ar.com.sg.hibernate.dao.ILocalidadDAO;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.generic.impl.GenericDaoImpl;
import ar.com.sg.hibernate.dao.util.HibernateUtils;
import ar.com.sg.hibernate.domain.Localidad;;

public class LocalidadDAO extends GenericDaoImpl<Localidad, String> implements ILocalidadDAO{
	private SessionFactory factory;
	
	public LocalidadDAO() {
		
		factory = HibernateUtils.getSessionFactory();
	}
	
	@Override
	public List<Localidad> findLocalidad() throws GenericExeption {
		Session session = factory.getCurrentSession();

		List<Localidad> Localidad = new ArrayList<Localidad>();
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + Localidad.class.getName() + " e ";

			// Create Query object.
			Query<Localidad> query = session.createQuery(sql);

			// Execute query.
			Localidad = query.getResultList();

			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
		return Localidad;
	}

	@Override
	public Localidad getLocalidad(String codLocalidad) throws GenericExeption {
		Session session = factory.getCurrentSession();

		Localidad Localidad = null;
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + Localidad.class.getName() + " e where e.codLocalidad=:codLocalidad ";

			// Create Query object.
			Query<Localidad> query = session.createQuery(sql);

			query.setParameter("codLocalidad", codLocalidad);

			// Execute query.
			Optional<Localidad> employees = query.uniqueResultOptional();

			if(employees.isPresent()) {
				Localidad = employees.get();
			}
			
			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
			throw new GenericExeption(e.getMessage(), e);
		}
		return Localidad;
	}

	@Override
	public List<Localidad> findByLocalidad(String localidad) throws GenericExeption {
		Session session = factory.getCurrentSession();

		List<Localidad> Localidads = new ArrayList<>();
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + Localidad.class.getName() + " e where UPPER(e.localidad) like :localidad";

			// Create Query object.
			Query<Localidad> query = session.createQuery(sql);

			query.setParameter("Localidad", "%"+localidad.toUpperCase()+"%");
			
			// Execute query.
			Localidads = query.getResultList();

			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
		return Localidads;
	}

}
