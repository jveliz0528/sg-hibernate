package ar.com.sg.hibernate.services;

import ar.com.sg.hibernate.dao.exceptions.DuplicateException;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.domain.Correo;


public interface ICorreoService {
	
	public void GuardarCorreo(Correo miCorreo) throws DuplicateException;

	public void ActualizarCorreo(Correo miCorreo) throws GenericExeption;

	public void EliminarCorreo(Correo miCorreo) throws GenericExeption;
	
	public Correo getCorreo(Long idCorreo) throws GenericExeption;
	

}
