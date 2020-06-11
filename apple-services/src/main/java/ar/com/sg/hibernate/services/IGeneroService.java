package ar.com.sg.hibernate.services;

import java.util.List;

import ar.com.sg.hibernate.dao.exceptions.DuplicateException;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.domain.Genero;
import ar.com.sg.hibernate.services.exceptions.ServiceException;


public interface IGeneroService {
	
	public void GuardarGenero(Genero miGenero) throws DuplicateException;

	public void ActualizarGenero(Genero miGenero) throws GenericExeption;

	public void EliminarGenero(Genero miGenero) throws GenericExeption;
	
	public List<Genero> findGenero() throws ServiceException, GenericExeption;
	
	public List<Genero> findByGenero(String Genero) throws GenericExeption;
	
	public Genero getGenero(char codGenero) throws GenericExeption;
	

}
