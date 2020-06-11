package ar.com.sg.hibernate.services;

import java.util.List;

import ar.com.sg.hibernate.dao.exceptions.DuplicateException;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.domain.Persona;
import ar.com.sg.hibernate.services.exceptions.ServiceException;


public interface IPersonaService {
	public void GuardarPersona(Persona miPersona) throws DuplicateException, ServiceException;

	public void ActualizarPersona(Persona miPersona) throws GenericExeption, ServiceException;

	public void EliminarPersona(Persona miPersona) throws ServiceException, GenericExeption;
	
	public List<Persona> findPersona() throws ServiceException, GenericExeption;
	
	public List<Persona> findByNombre(String nombre) throws GenericExeption;
	
	public Persona getPersona(String documento) throws ServiceException, GenericExeption;

}
