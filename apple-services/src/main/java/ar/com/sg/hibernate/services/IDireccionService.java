package ar.com.sg.hibernate.services;

import ar.com.sg.hibernate.dao.exceptions.DuplicateException;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.domain.Direccion;


public interface IDireccionService {
	
	public void GuardarDireccion(Direccion miDireccion) throws DuplicateException;

	public void ActualizarDireccion(Direccion miDireccion) throws GenericExeption;

	public void EliminarDireccion(Direccion miDireccion) throws GenericExeption;
	
	public Direccion getDireccion(Long codDireccion) throws GenericExeption;
	

}
