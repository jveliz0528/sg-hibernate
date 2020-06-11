package ar.com.sg.hibernate.dao;

import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.generic.IGenericDAO;
import ar.com.sg.hibernate.domain.Direccion;

public interface IDireccionDAO extends IGenericDAO<Direccion, String>{	
	
	public Direccion getDireccion(Long idDireccion) throws GenericExeption;
}
