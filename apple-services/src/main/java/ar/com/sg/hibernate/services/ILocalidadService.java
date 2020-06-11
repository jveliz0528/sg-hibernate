package ar.com.sg.hibernate.services;

import java.util.List;

import ar.com.sg.hibernate.dao.exceptions.DuplicateException;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.domain.Localidad;


public interface ILocalidadService {
	
	public void GuardarLocalidad(Localidad miLocalidad) throws DuplicateException;

	public void ActualizarLocalidad(Localidad miLocalidad) throws GenericExeption;

	public void EliminarLocalidad(Localidad miLocalidad) throws GenericExeption;
	
	public List<Localidad> findLocalidad() throws GenericExeption;
	
	public List<Localidad> findByLocalidad(String localidad) throws GenericExeption;
	
	public Localidad getLocalidad(String codLocalidad) throws GenericExeption;
	

}
