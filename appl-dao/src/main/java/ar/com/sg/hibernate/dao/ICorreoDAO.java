package ar.com.sg.hibernate.dao;

import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.generic.IGenericDAO;
import ar.com.sg.hibernate.domain.Correo;

public interface ICorreoDAO extends IGenericDAO<Correo, String>{	
	
	public Correo getCorreo(Long idCorreo) throws GenericExeption;
}
