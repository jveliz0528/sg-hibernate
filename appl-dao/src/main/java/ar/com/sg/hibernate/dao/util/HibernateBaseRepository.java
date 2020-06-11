package ar.com.sg.hibernate.dao.util;

import org.hibernate.SessionFactory;

public abstract class HibernateBaseRepository {

	protected SessionFactory factory;
	
	public HibernateBaseRepository() {
		factory = HibernateUtils.getSessionFactory();
	}		
	
}
