package ar.com.sg.hibernate.dao;

import java.util.List;

import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.generic.IGenericDAO;
import ar.com.sg.hibernate.domain.Localidad;

public interface ILocalidadDAO extends IGenericDAO<Localidad, String>{	
	public List<Localidad> findLocalidad() throws GenericExeption;
	
	public List<Localidad> findByLocalidad(String localidad) throws GenericExeption;
	
	public Localidad getLocalidad(String codLocalidad) throws GenericExeption;
}
