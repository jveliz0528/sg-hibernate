package ar.com.sg.hibernate.dao;

import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.generic.IGenericDAO;
import ar.com.sg.hibernate.domain.Telefono;

public interface ITelefonoDAO extends IGenericDAO<Telefono, String>{	
	
	public Telefono getTelefono(Long idTelefono) throws GenericExeption;
}
