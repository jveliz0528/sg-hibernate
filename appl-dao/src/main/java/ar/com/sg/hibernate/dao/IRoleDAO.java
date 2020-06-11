package ar.com.sg.hibernate.dao;

import java.util.List;

import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.generic.IGenericDAO;
import ar.com.sg.hibernate.domain.Role;

public interface IRoleDAO extends IGenericDAO<Role, String>{	
	public List<Role> findRole() throws GenericExeption;
	
	public List<Role> findByRole(String Role) throws GenericExeption;
	
	public Role getRole(String codRole) throws GenericExeption;
}
