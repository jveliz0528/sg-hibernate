package ar.com.sg.hibernate.dao.impl;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import ar.com.sg.hibernate.dao.ITelefonoDAO;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.generic.impl.GenericDaoImpl;
import ar.com.sg.hibernate.dao.util.HibernateUtils;
import ar.com.sg.hibernate.domain.Telefono;;

public class TelefonoDAO extends GenericDaoImpl<Telefono, String> implements ITelefonoDAO{
	private SessionFactory factory;
	
	public TelefonoDAO() {
		
		factory = HibernateUtils.getSessionFactory();
	}

	@Override
	public Telefono getTelefono(Long idTelefono) throws GenericExeption {
		Session session = factory.getCurrentSession();

		Telefono Telefono = null;
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + Telefono.class.getName() + " e where e.idTelefono=:idTelefono ";

			// Create Query object.
			Query<Telefono> query = session.createQuery(sql);

			query.setParameter("idTelefono", idTelefono);

			// Execute query.
			Optional<Telefono> employees = query.uniqueResultOptional();

			if(employees.isPresent()) {
				Telefono = employees.get();
			}
			
			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
			throw new GenericExeption(e.getMessage(), e);
		}
		return Telefono;
	}
	
	

}
