package ar.com.sg.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import ar.com.sg.hibernate.dao.IPersonaDAO;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.generic.impl.GenericDaoImpl;
import ar.com.sg.hibernate.dao.util.HibernateUtils;
import ar.com.sg.hibernate.domain.Persona;

public class PersonaDAO extends GenericDaoImpl<Persona, String> implements IPersonaDAO {
	private SessionFactory factory;

	public PersonaDAO() {

		factory = HibernateUtils.getSessionFactory();
	}

	@Override
	public List<Persona> findPersona() throws GenericExeption {
		Session session = factory.getCurrentSession();

		List<Persona> Persona = new ArrayList<Persona>();

		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + Persona.class.getName() + " e ";

			// Create Query object.
			Query<Persona> query = session.createQuery(sql);

			// Execute query.
			Persona = query.getResultList();

			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
		return Persona;
	}

	@Override
	public List<Persona> findByNombre(String primerNombre) throws GenericExeption {
		Session session = factory.getCurrentSession();

		List<Persona> Persona = new ArrayList<>();

		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + Persona.class.getName() + " e where UPPER(e.primerNombre) like :primerNombre";

			// Create Query object.
			Query<Persona> query = session.createQuery(sql);

			query.setParameter("primerNombre", "%" + primerNombre.toUpperCase() + "%");

			// Execute query.
			Persona = query.getResultList();

			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
		return Persona;
	}

	@Override
	public Persona getPersona(String documento) throws GenericExeption {
		Session session = factory.getCurrentSession();

		Persona Persona = null;

		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + Persona.class.getName() + " e where e.documento=:documento ";

			// Create Query object.
			Query<Persona> query = session.createQuery(sql);

			query.setParameter("documento", documento);

			// Execute query.
			Optional<Persona> employees = query.uniqueResultOptional();

			if (employees.isPresent()) {
				Persona = employees.get();
			}

			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
			throw new GenericExeption(e.getMessage(), e);
		}
		return Persona;
	}

	@Override
	public Persona validar(String documento, String password) throws GenericExeption {
		Session session = factory.getCurrentSession();

		Persona Persona = null;

		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + Persona.class.getName()
					+ " e where e.documento=:documento and e.password=:password";

			// Create Query object.
			Query<Persona> query = session.createQuery(sql);

			query.setParameter("documento", documento);
			query.setParameter("password", password);

			// Execute query.
			Optional<Persona> employees = query.uniqueResultOptional();

			if (employees.isPresent()) {
				Persona = employees.get();
			}

			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {

		}
		return Persona;
	}

}