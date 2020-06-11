package ar.com.sg.hibernate.services;

import java.util.List;

import ar.com.sg.hibernate.dao.exceptions.DuplicateException;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.domain.EstadoCivil;


public interface IEstadoCivilService {
	public void GuardarEstadoCivil(EstadoCivil miEstadoCivil) throws DuplicateException;

	public void ActualizarEstadoCivil(EstadoCivil miEstadoCivil) throws GenericExeption;

	public void EliminarEstadoCivil(EstadoCivil miEstadoCivil) throws GenericExeption;
	
	public List<EstadoCivil> findEstadoCivil() throws GenericExeption;
	
	public List<EstadoCivil> findByEstadoCivil(String estadoCivil) throws GenericExeption;
	
	public EstadoCivil getEstadoCivil(char codEstadoCivil) throws GenericExeption;
	

}
