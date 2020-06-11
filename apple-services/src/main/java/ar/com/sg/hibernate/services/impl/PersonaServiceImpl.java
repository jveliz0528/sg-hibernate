package ar.com.sg.hibernate.services.impl;

import java.util.List;

import ar.com.sg.hibernate.dao.exceptions.DuplicateException;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.impl.PersonaDAO;
import ar.com.sg.hibernate.domain.Persona;
import ar.com.sg.hibernate.services.IPersonaService;
import ar.com.sg.hibernate.services.exceptions.ServiceException;

public class PersonaServiceImpl implements IPersonaService {

	private PersonaDAO PersonaDAO;

	public PersonaServiceImpl() {
		PersonaDAO = new PersonaDAO();
	}

	@Override
	public void GuardarPersona(Persona miPersona) throws DuplicateException {
		PersonaDAO.Guardar(miPersona);
	}

	@Override
	public void ActualizarPersona(Persona miPersona) throws GenericExeption {
		PersonaDAO.Actualizar(miPersona);
		
	}

	@Override
	public void EliminarPersona(Persona miPersona) throws GenericExeption {
		PersonaDAO.Eliminar(miPersona);
	}

	@Override
	public List<Persona> findPersona() throws GenericExeption, ServiceException {
		return PersonaDAO.findPersona();
	}

	@Override
	public List<Persona> findByNombre(String nombre) throws GenericExeption {
		return PersonaDAO.findByNombre(nombre);
	}

	@Override
	public Persona getPersona(String documento) throws GenericExeption, ServiceException {
		return PersonaDAO.getPersona(documento);
	}


}
