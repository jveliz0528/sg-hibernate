package ar.com.sg.hibernate.services.impl;

import java.util.List;

import ar.com.sg.hibernate.dao.exceptions.DuplicateException;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.impl.EstadoDAO;
import ar.com.sg.hibernate.domain.Estado;
import ar.com.sg.hibernate.services.IEstadoService;

public class EstadoServiceImpl implements IEstadoService {

	private EstadoDAO EstadoDAO;

	public EstadoServiceImpl() {
		EstadoDAO = new EstadoDAO();
	}

	@Override
	public void GuardarEstado(Estado miEstado) throws DuplicateException {
	}

	@Override
	public void ActualizarEstado(Estado miEstado) throws GenericExeption {

	}

	@Override
	public void EliminarEstado(Estado miEstado) throws GenericExeption {

	}

	@Override
	public List<Estado> findEstado() throws GenericExeption {
		
		return EstadoDAO.findEstado();
	}

	@Override
	public List<Estado> findByEstado(String estado) throws GenericExeption {

		return EstadoDAO.findByEstado(estado);
	}

	@Override
	public Estado getEstado(String codEstado) throws GenericExeption {

		return EstadoDAO.getEstado(codEstado);
	}

}
