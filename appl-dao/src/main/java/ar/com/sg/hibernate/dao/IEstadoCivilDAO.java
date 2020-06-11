package ar.com.sg.hibernate.dao;

import java.util.List;

import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.generic.IGenericDAO;
import ar.com.sg.hibernate.domain.EstadoCivil;

public interface IEstadoCivilDAO extends IGenericDAO<EstadoCivil, String>{	
	public List<EstadoCivil> findEstadoCivil() throws GenericExeption;
	
	public List<EstadoCivil> findByEstadoCivil(String estadoCivil) throws GenericExeption;
	
	public EstadoCivil getEstadoCivil(char codEstadoCivil) throws GenericExeption;
}
