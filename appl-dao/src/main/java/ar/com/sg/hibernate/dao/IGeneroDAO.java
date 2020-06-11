package ar.com.sg.hibernate.dao;

import java.util.List;

import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.generic.IGenericDAO;
import ar.com.sg.hibernate.domain.Genero;

public interface IGeneroDAO extends IGenericDAO<Genero, String>{	
	public List<Genero> findGenero() throws GenericExeption;
	
	public List<Genero> findByGenero(String genero) throws GenericExeption;
	
	public Genero getGenero(char codGenero) throws GenericExeption;
}
