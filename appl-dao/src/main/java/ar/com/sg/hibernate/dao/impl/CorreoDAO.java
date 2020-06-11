package ar.com.sg.hibernate.dao.impl;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import ar.com.sg.hibernate.dao.ICorreoDAO;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.generic.impl.GenericDaoImpl;
import ar.com.sg.hibernate.dao.util.HibernateUtils;
import ar.com.sg.hibernate.domain.Correo;;

public class CorreoDAO extends GenericDaoImpl<Correo, String> implements ICorreoDAO{
	private SessionFactory factory;
	
	public CorreoDAO() {
		
		factory = HibernateUtils.getSessionFactory();
	}

	@Override
	public Correo getCorreo(Long idCorreo) throws GenericExeption {
		Session session = factory.getCurrentSession();

		Correo Correo = null;
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + Correo.class.getName() + " e where e.idCorreo=:idCorreo ";

			// Create Query object.
			Query<Correo> query = session.createQuery(sql);

			query.setParameter("idCorreo", idCorreo);

			// Execute query.
			Optional<Correo> employees = query.uniqueResultOptional();

			if(employees.isPresent()) {
				Correo = employees.get();
			}
			
			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
			throw new GenericExeption(e.getMessage(), e);
		}
		return Correo;
	}
	
	

}
