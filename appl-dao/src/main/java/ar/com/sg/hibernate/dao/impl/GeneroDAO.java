package ar.com.sg.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import ar.com.sg.hibernate.dao.IGeneroDAO;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.generic.impl.GenericDaoImpl;
import ar.com.sg.hibernate.dao.util.HibernateUtils;
import ar.com.sg.hibernate.domain.Genero;;

public class GeneroDAO extends GenericDaoImpl<Genero, String> implements IGeneroDAO{
	private SessionFactory factory;
	
	public GeneroDAO() {
		
		factory = HibernateUtils.getSessionFactory();
	}
	
	@Override
	public List<Genero> findGenero() throws GenericExeption {
		Session session = factory.getCurrentSession();

		List<Genero> Genero = new ArrayList<Genero>();
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + Genero.class.getName() + " e ";

			// Create Query object.
			Query<Genero> query = session.createQuery(sql);

			// Execute query.
			Genero = query.getResultList();

			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
		return Genero;
	}

	@Override
	public Genero getGenero(char codGenero) throws GenericExeption {
		Session session = factory.getCurrentSession();

		Genero Genero = null;
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + Genero.class.getName() + " e where e.codGenero=:codGenero ";

			// Create Query object.
			Query<Genero> query = session.createQuery(sql);

			query.setParameter("codGenero", codGenero);

			// Execute query.
			Optional<Genero> employees = query.uniqueResultOptional();

			if(employees.isPresent()) {
				Genero = employees.get();
			}
			
			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
			throw new GenericExeption(e.getMessage(), e);
		}
		return Genero;
	}

	@Override
	public List<Genero> findByGenero(String Genero) throws GenericExeption {
		Session session = factory.getCurrentSession();

		List<Genero> Generos = new ArrayList<>();
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + Genero.class.getName() + " e where UPPER(e.Genero) like :Genero";

			// Create Query object.
			Query<Genero> query = session.createQuery(sql);

			query.setParameter("Genero", "%"+Genero.toUpperCase()+"%");
			
			// Execute query.
			Generos = query.getResultList();

			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
		return Generos;
	}

}
