package ar.com.sg.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import ar.com.sg.hibernate.dao.IRoleDAO;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.generic.impl.GenericDaoImpl;
import ar.com.sg.hibernate.dao.util.HibernateUtils;
import ar.com.sg.hibernate.domain.Role;

public class RoleDAO extends GenericDaoImpl<Role, String> implements IRoleDAO {
	private SessionFactory factory;

	public RoleDAO() {
		
		factory = HibernateUtils.getSessionFactory();
	}

	@Override
	public List<Role> findRole() throws GenericExeption {
		Session session = factory.getCurrentSession();

		List<Role> Role = new ArrayList<Role>();
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + Role.class.getName() + " e ";

			// Create Query object.
			Query<Role> query = session.createQuery(sql);

			// Execute query.
			Role = query.getResultList();

			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
		return Role;
	}

	@Override
	public List<Role> findByRole(String Role) throws GenericExeption {
		Session session = factory.getCurrentSession();

		List<Role> Roles = new ArrayList<>();
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + Role.class.getName() + " e where UPPER(e.Role) like :Role";

			// Create Query object.
			Query<Role> query = session.createQuery(sql);

			query.setParameter("Role", "%"+Role.toUpperCase()+"%");
			
			// Execute query.
			Roles = query.getResultList();

			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
		}
		
		return Roles;
	}

	@Override
	public Role getRole(String codRole) throws GenericExeption {
		Session session = factory.getCurrentSession();

		Role Role = null;
		
		try {

			// All the action with DB via Hibernate
			// must be located in one transaction.
			// Start Transaction.
			session.getTransaction().begin();

			// Create an HQL statement, query the object.
			String sql = "Select e from " + Role.class.getName() + " e where e.codRole=:codRole ";

			// Create Query object.
			Query<Role> query = session.createQuery(sql);

			query.setParameter("codRole", codRole);

			// Execute query.
			Optional<Role> employees = query.uniqueResultOptional();

			if(employees.isPresent()) {
				Role = employees.get();
			}
			
			// Commit data.
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback in case of an error occurred.
			session.getTransaction().rollback();
			throw new GenericExeption(e.getMessage(), e);
		}
		return Role;
	}
	

}
