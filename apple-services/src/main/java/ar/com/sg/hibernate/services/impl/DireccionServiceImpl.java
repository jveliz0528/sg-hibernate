package ar.com.sg.hibernate.services.impl;

import ar.com.sg.hibernate.dao.exceptions.DuplicateException;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.impl.DireccionDAO;
import ar.com.sg.hibernate.domain.Direccion;
import ar.com.sg.hibernate.services.IDireccionService;

public class DireccionServiceImpl implements IDireccionService {

	private DireccionDAO DireccionDAO;

	public DireccionServiceImpl() {
		DireccionDAO = new DireccionDAO();
	}

	@Override
	public void GuardarDireccion(Direccion miDireccion) throws DuplicateException {
		DireccionDAO.Guardar(miDireccion);
	}

	@Override
	public void ActualizarDireccion(Direccion miDireccion) throws GenericExeption {
		DireccionDAO.Actualizar(miDireccion);
		
	}

	@Override
	public void EliminarDireccion(Direccion miDireccion) throws GenericExeption {
		DireccionDAO.Eliminar(miDireccion);
	}


	@Override
	public Direccion getDireccion(Long idDireccion) throws GenericExeption {
		return DireccionDAO.getDireccion(idDireccion);
	}


}
