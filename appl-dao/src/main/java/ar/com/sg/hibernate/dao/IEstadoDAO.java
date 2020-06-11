package ar.com.sg.hibernate.dao;

import java.util.List;

import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.generic.IGenericDAO;
import ar.com.sg.hibernate.domain.Estado;

public interface IEstadoDAO extends IGenericDAO<Estado, String>{	
	public List<Estado> findEstado() throws GenericExeption;
	
	public List<Estado> findByEstado(String estado) throws GenericExeption;
	
	public Estado getEstado(String codEstado) throws GenericExeption;
}
