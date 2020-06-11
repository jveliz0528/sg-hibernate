package ar.com.sg.hibernate.services.impl;

import ar.com.sg.hibernate.dao.exceptions.DuplicateException;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.impl.TelefonoDAO;
import ar.com.sg.hibernate.domain.Telefono;
import ar.com.sg.hibernate.services.ITelefonoService;

public class TelefonoServiceImpl implements ITelefonoService {

	private TelefonoDAO TelefonoDAO;

	public TelefonoServiceImpl() {
		TelefonoDAO = new TelefonoDAO();
	}

	@Override
	public void GuardarTelefono(Telefono miTelefono) throws DuplicateException {
		TelefonoDAO.Guardar(miTelefono);
	}

	@Override
	public void ActualizarTelefono(Telefono miTelefono) throws GenericExeption {
		TelefonoDAO.Actualizar(miTelefono);
		
	}

	@Override
	public void EliminarTelefono(Telefono miTelefono) throws GenericExeption {
		TelefonoDAO.Eliminar(miTelefono);
	}


	@Override
	public Telefono getTelefono(Long idTelefono) throws GenericExeption {
		return TelefonoDAO.getTelefono(idTelefono);
	}


}
