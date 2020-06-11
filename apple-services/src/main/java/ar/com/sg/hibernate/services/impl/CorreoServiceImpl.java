package ar.com.sg.hibernate.services.impl;

import ar.com.sg.hibernate.dao.exceptions.DuplicateException;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.impl.CorreoDAO;
import ar.com.sg.hibernate.domain.Correo;
import ar.com.sg.hibernate.services.ICorreoService;

public class CorreoServiceImpl implements ICorreoService {

	private CorreoDAO CorreoDAO;

	public CorreoServiceImpl() {
		CorreoDAO = new CorreoDAO();
	}

	@Override
	public void GuardarCorreo(Correo miCorreo) throws DuplicateException {
		CorreoDAO.Guardar(miCorreo);
	}

	@Override
	public void ActualizarCorreo(Correo miCorreo) throws GenericExeption {
		CorreoDAO.Actualizar(miCorreo);
		
	}

	@Override
	public void EliminarCorreo(Correo miCorreo) throws GenericExeption {
		CorreoDAO.Eliminar(miCorreo);
	}


	@Override
	public Correo getCorreo(Long idCorreo) throws GenericExeption {
		return CorreoDAO.getCorreo(idCorreo);
	}


}
