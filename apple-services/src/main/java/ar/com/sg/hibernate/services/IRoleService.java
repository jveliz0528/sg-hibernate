package ar.com.sg.hibernate.services;

import java.util.List;

import ar.com.sg.hibernate.dao.exceptions.DuplicateException;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.domain.Role;


public interface IRoleService {
	public void GuardarRole(Role miRole) throws DuplicateException;

	public void ActualizarRole(Role miRole) throws GenericExeption;

	public void EliminarRole(Role miRole) throws GenericExeption;
	
	public List<Role> findRole() throws GenericExeption;
	
	public List<Role> findByRole(String Role) throws GenericExeption;
	
	public Role getRole(String codRole) throws GenericExeption;
	

}
