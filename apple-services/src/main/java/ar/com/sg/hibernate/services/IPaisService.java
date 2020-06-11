package ar.com.sg.hibernate.services;

import java.util.List;

import ar.com.sg.hibernate.dao.exceptions.DuplicateException;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.domain.Pais;


public interface IPaisService {
	public void GuardarPais(Pais miPais) throws DuplicateException;

	public void ActualizarPais(Pais miPais) throws GenericExeption;

	public void EliminarPais(Pais miPais) throws GenericExeption;
	
	public List<Pais> findPais() throws GenericExeption;
	
	public List<Pais> findByPais(String pais) throws GenericExeption;
	
	public Pais getPais(String codPais) throws GenericExeption;
	

}
