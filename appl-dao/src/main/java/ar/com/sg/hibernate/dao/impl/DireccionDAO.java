package ar.com.sg.hibernate.dao.impl;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import ar.com.sg.hibernate.dao.IDireccionDAO;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.generic.impl.GenericDaoImpl;
import ar.com.sg.hibernate.dao.util.HibernateUtils;
import ar.com.sg.hibernate.domain.Direccion;;

public class DireccionDAO extends GenericDaoImpl<Direccion, String> implements IDireccionDAO{
	private SessionFactory factory;
	
	public DireccionDAO() {
		
		factory = HibernateUtils.getSessionFactory();
	}

	@Override
	public Direccion getDireccion(Long idDireccion) throws GenericExeption {
		Session session = factory.getCurrentSession();

		Direccion Direccion = null;
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + Direccion.class.getName() + " e where e.idDireccion=:idDireccion ";

			// Create Query object.
			Query<Direccion> query = session.createQuery(sql);

			query.setParameter("idDireccion", idDireccion);

			// Execute query.
			Optional<Direccion> employees = query.uniqueResultOptional();

			if(employees.isPresent()) {
				Direccion = employees.get();
			}
			
			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
			throw new GenericExeption(e.getMessage(), e);
		}
		return Direccion;
	}
	
	

}
