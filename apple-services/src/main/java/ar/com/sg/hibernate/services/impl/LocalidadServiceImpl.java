package ar.com.sg.hibernate.services.impl;

import java.util.List;

import ar.com.sg.hibernate.dao.exceptions.DuplicateException;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.impl.LocalidadDAO;
import ar.com.sg.hibernate.domain.Localidad;
import ar.com.sg.hibernate.services.ILocalidadService;

public class LocalidadServiceImpl implements ILocalidadService {

	private LocalidadDAO LocalidadDAO;

	public LocalidadServiceImpl() {
		LocalidadDAO = new LocalidadDAO();
	}

	@Override
	public void GuardarLocalidad(Localidad miLocalidad) throws DuplicateException {
		LocalidadDAO.Guardar(miLocalidad);
	}

	@Override
	public void ActualizarLocalidad(Localidad miLocalidad) throws GenericExeption {
		LocalidadDAO.Actualizar(miLocalidad);
		
	}

	@Override
	public void EliminarLocalidad(Localidad miLocalidad) throws GenericExeption {
		LocalidadDAO.Eliminar(miLocalidad);
	}

	@Override
	public List<Localidad> findLocalidad() throws GenericExeption {
		return LocalidadDAO.findLocalidad();
	}

	@Override
	public List<Localidad> findByLocalidad(String localidad) throws GenericExeption {
		return LocalidadDAO.findByLocalidad(localidad);
	}

	@Override
	public Localidad getLocalidad(String codLocalidad) throws GenericExeption {
		return LocalidadDAO.getLocalidad(codLocalidad);
	}


}
