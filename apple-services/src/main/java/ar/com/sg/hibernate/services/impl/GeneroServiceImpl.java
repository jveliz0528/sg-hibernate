package ar.com.sg.hibernate.services.impl;

import java.util.List;

import ar.com.sg.hibernate.dao.exceptions.DuplicateException;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.impl.GeneroDAO;
import ar.com.sg.hibernate.domain.Genero;
import ar.com.sg.hibernate.services.IGeneroService;
import ar.com.sg.hibernate.services.exceptions.ServiceException;

public class GeneroServiceImpl implements IGeneroService {

	private GeneroDAO GeneroDAO;

	public GeneroServiceImpl() {
		GeneroDAO = new GeneroDAO();
	}

	@Override
	public void GuardarGenero(Genero miGenero) throws DuplicateException {
		GeneroDAO.Guardar(miGenero);
	}

	@Override
	public void ActualizarGenero(Genero miGenero) throws GenericExeption {
		GeneroDAO.Actualizar(miGenero);
		
	}

	@Override
	public void EliminarGenero(Genero miGenero) throws GenericExeption {
		GeneroDAO.Eliminar(miGenero);
	}

	@Override
	public List<Genero> findByGenero(String Genero) throws GenericExeption {
		return GeneroDAO.findByGenero(Genero);
	}

	@Override
	public Genero getGenero(char codGenero) throws GenericExeption {
		return GeneroDAO.getGenero(codGenero);
	}

	@Override
	public List<Genero> findGenero() throws ServiceException, GenericExeption {
		return GeneroDAO.findGenero();
	}


}
