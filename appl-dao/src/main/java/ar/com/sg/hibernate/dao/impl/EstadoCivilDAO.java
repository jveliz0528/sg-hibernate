package ar.com.sg.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import ar.com.sg.hibernate.dao.IEstadoCivilDAO;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.generic.impl.GenericDaoImpl;
import ar.com.sg.hibernate.dao.util.HibernateUtils;
import ar.com.sg.hibernate.domain.EstadoCivil;

public class EstadoCivilDAO extends GenericDaoImpl<EstadoCivil, String> implements IEstadoCivilDAO{

private SessionFactory factory;
	
	public EstadoCivilDAO() {
		
		factory = HibernateUtils.getSessionFactory();
	}

	@Override
	public List<EstadoCivil> findEstadoCivil() throws GenericExeption {
		Session session = factory.getCurrentSession();

		List<EstadoCivil> EstadoCivil = new ArrayList<EstadoCivil>();
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + EstadoCivil.class.getName() + " e ";

			// Create Query object.
			Query<EstadoCivil> query = session.createQuery(sql);

			// Execute query.
			EstadoCivil = query.getResultList();

			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
		return EstadoCivil;
	}

	@Override
	public List<EstadoCivil> findByEstadoCivil(String estadoCivil) throws GenericExeption {
		Session session = factory.getCurrentSession();

		List<EstadoCivil> EstadoCivil = new ArrayList<>();
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + EstadoCivil.class.getName() + " e where UPPER(e.estadoCivil) like :estadoCivil";

			// Create Query object.
			Query<EstadoCivil> query = session.createQuery(sql);

			query.setParameter("estadoCivil", "%"+estadoCivil.toUpperCase()+"%");
			
			// Execute query.
			EstadoCivil = query.getResultList();

			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
		return EstadoCivil;
	}

	@Override
	public EstadoCivil getEstadoCivil(char codEstadoCivil) throws GenericExeption {
		Session session = factory.getCurrentSession();

		EstadoCivil EstadoCivil = null;
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + EstadoCivil.class.getName() + " e where e.codEstadoCivil=:codEstadoCivil ";

			// Create Query object.
			Query<EstadoCivil> query = session.createQuery(sql);

			query.setParameter("codEstadoCivil", codEstadoCivil);

			// Execute query.
			Optional<EstadoCivil> employees = query.uniqueResultOptional();

			if(employees.isPresent()) {
				EstadoCivil = employees.get();
			}
			
			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
			throw new GenericExeption(e.getMessage(), e);
		}
		return EstadoCivil;
	}
	


}
