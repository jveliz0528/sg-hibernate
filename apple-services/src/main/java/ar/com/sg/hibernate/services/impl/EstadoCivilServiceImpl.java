package ar.com.sg.hibernate.services.impl;

import java.util.List;

import ar.com.sg.hibernate.dao.exceptions.DuplicateException;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.impl.EstadoCivilDAO;
import ar.com.sg.hibernate.domain.EstadoCivil;
import ar.com.sg.hibernate.services.IEstadoCivilService;

public class EstadoCivilServiceImpl implements IEstadoCivilService {

	private EstadoCivilDAO EstadoCivilDAO;

	public EstadoCivilServiceImpl() {
		EstadoCivilDAO = new EstadoCivilDAO();
	}

	@Override
	public void GuardarEstadoCivil(EstadoCivil EstadoCivilacargar) throws DuplicateException {
	}

	@Override
	public void ActualizarEstadoCivil(EstadoCivil EstadoCivilacargar) throws GenericExeption {
		
	}

	@Override
	public void EliminarEstadoCivil(EstadoCivil miEstadoCivil) throws GenericExeption {

	}

	@Override
	public List<EstadoCivil> findEstadoCivil() throws GenericExeption {
		return EstadoCivilDAO.findEstadoCivil();
	}

	@Override
	public List<EstadoCivil> findByEstadoCivil(String estadoCivil) throws GenericExeption {
		
		return EstadoCivilDAO.findByEstadoCivil(estadoCivil);
	}

	@Override
	public EstadoCivil getEstadoCivil(char codEstadoCivil) throws GenericExeption {
		
		return EstadoCivilDAO.getEstadoCivil(codEstadoCivil);
	}
}
