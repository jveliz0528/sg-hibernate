package ar.com.sg.hibernate.services;

import java.util.List;

import ar.com.sg.hibernate.dao.exceptions.DuplicateException;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.domain.Estado;


public interface IEstadoService {
	public void GuardarEstado(Estado miEstado) throws DuplicateException;

	public void ActualizarEstado(Estado miEstado) throws GenericExeption;

	public void EliminarEstado(Estado miEstado) throws GenericExeption;
	
	public List<Estado> findEstado() throws GenericExeption;
	
	public List<Estado> findByEstado(String estado) throws GenericExeption;
	
	public Estado getEstado(String codEstado) throws GenericExeption;
	

}
