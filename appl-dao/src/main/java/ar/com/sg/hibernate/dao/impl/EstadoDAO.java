package ar.com.sg.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import ar.com.sg.hibernate.dao.IEstadoDAO;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.generic.impl.GenericDaoImpl;
import ar.com.sg.hibernate.dao.util.HibernateUtils;
import ar.com.sg.hibernate.domain.Estado;

public class EstadoDAO extends GenericDaoImpl<Estado, String> implements IEstadoDAO {
	private SessionFactory factory;

	public EstadoDAO() {
		
		factory = HibernateUtils.getSessionFactory();
	}

	@Override
	public List<Estado> findEstado() throws GenericExeption {
		Session session = factory.getCurrentSession();

		List<Estado> Estado = new ArrayList<Estado>();
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + Estado.class.getName() + " e ";

			// Create Query object.
			Query<Estado> query = session.createQuery(sql);

			// Execute query.
			Estado = query.getResultList();

			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
		return Estado;
	}

	@Override
	public List<Estado> findByEstado(String estado) throws GenericExeption {
		Session session = factory.getCurrentSession();

		List<Estado> Estado = new ArrayList<>();
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + Estado.class.getName() + " e where UPPER(e.estado) like :estado";

			// Create Query object.
			Query<Estado> query = session.createQuery(sql);

			query.setParameter("estado", "%"+estado.toUpperCase()+"%");
			
			// Execute query.
			Estado = query.getResultList();

			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
		
		return Estado;
	}

	@Override
	public Estado getEstado(String codEstado) throws GenericExeption {
		Session session = factory.getCurrentSession();

		Estado Estado = null;
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + Estado.class.getName() + " e where e.codEstado=:codEstado ";

			// Create Query object.
			Query<Estado> query = session.createQuery(sql);

			query.setParameter("codEstado", codEstado);

			// Execute query.
			Optional<Estado> employees = query.uniqueResultOptional();

			if(employees.isPresent()) {
				Estado = employees.get();
			}
			
			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
			throw new GenericExeption(e.getMessage(), e);
		}
		return Estado;
	}
	

}
