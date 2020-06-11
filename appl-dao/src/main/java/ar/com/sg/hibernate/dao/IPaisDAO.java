package ar.com.sg.hibernate.dao;

import java.util.List;

import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.generic.IGenericDAO;
import ar.com.sg.hibernate.domain.Pais;

public interface IPaisDAO extends IGenericDAO<Pais, String>{	
	public List<Pais> findPais() throws GenericExeption;
	
	public List<Pais> findByPais(String pais) throws GenericExeption;
	
	public Pais getPais(String codPais) throws GenericExeption;
}
