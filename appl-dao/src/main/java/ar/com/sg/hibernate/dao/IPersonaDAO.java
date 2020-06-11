package ar.com.sg.hibernate.dao;

import java.util.List;

import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.generic.IGenericDAO;
import ar.com.sg.hibernate.domain.Persona;

public interface IPersonaDAO extends IGenericDAO<Persona, String>{	
	public List<Persona> findPersona() throws GenericExeption;
	
	public List<Persona> findByNombre(String nombre) throws GenericExeption;
	
	public Persona getPersona(String documento) throws GenericExeption;
	
	//Loging
	public Persona validar(String documento, String password) throws GenericExeption;
}
