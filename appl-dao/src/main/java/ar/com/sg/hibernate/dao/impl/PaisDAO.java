package ar.com.sg.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import ar.com.sg.hibernate.dao.IPaisDAO;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.generic.impl.GenericDaoImpl;
import ar.com.sg.hibernate.dao.util.HibernateUtils;
import ar.com.sg.hibernate.domain.Pais;;

public class PaisDAO extends GenericDaoImpl<Pais, String> implements IPaisDAO{
	private SessionFactory factory;
	
	public PaisDAO() {
		
		factory = HibernateUtils.getSessionFactory();
	}
	
	@Override
	public List<Pais> findPais() throws GenericExeption {
		Session session = factory.getCurrentSession();

		List<Pais> Pais = new ArrayList<Pais>();
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + Pais.class.getName() + " e ";

			// Create Query object.
			Query<Pais> query = session.createQuery(sql);

			// Execute query.
			Pais = query.getResultList();

			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
		return Pais;
	}

	@Override
	public Pais getPais(String codPais) throws GenericExeption {
		Session session = factory.getCurrentSession();

		Pais Pais = null;
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + Pais.class.getName() + " e where e.codPais=:codPais ";

			// Create Query object.
			Query<Pais> query = session.createQuery(sql);

			query.setParameter("codPais", codPais);

			// Execute query.
			Optional<Pais> employees = query.uniqueResultOptional();

			if(employees.isPresent()) {
				Pais = employees.get();
			}
			
			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
			throw new GenericExeption(e.getMessage(), e);
		}
		return Pais;
	}

	@Override
	public List<Pais> findByPais(String pais) throws GenericExeption {
		Session session = factory.getCurrentSession();

		List<Pais> Paiss = new ArrayList<>();
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + Pais.class.getName() + " e where UPPER(e.pais) like :pais";

			// Create Query object.
			Query<Pais> query = session.createQuery(sql);

			query.setParameter("pais", "%"+pais.toUpperCase()+"%");
			
			// Execute query.
			Paiss = query.getResultList();

			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
		return Paiss;
	}

}
