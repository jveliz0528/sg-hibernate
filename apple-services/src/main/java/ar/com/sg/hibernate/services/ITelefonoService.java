package ar.com.sg.hibernate.services;

import ar.com.sg.hibernate.dao.exceptions.DuplicateException;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.domain.Telefono;


public interface ITelefonoService {
	
	public void GuardarTelefono(Telefono miTelefono) throws DuplicateException;

	public void ActualizarTelefono(Telefono miTelefono) throws GenericExeption;

	public void EliminarTelefono(Telefono miTelefono) throws GenericExeption;
	
	public Telefono getTelefono(Long idTelefono) throws GenericExeption;
	

}
