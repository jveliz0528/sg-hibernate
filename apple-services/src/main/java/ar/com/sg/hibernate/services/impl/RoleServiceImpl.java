package ar.com.sg.hibernate.services.impl;

import java.util.List;

import ar.com.sg.hibernate.dao.exceptions.DuplicateException;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.impl.RoleDAO;
import ar.com.sg.hibernate.domain.Role;
import ar.com.sg.hibernate.services.IRoleService;

public class RoleServiceImpl implements IRoleService {

	private RoleDAO RoleDAO;

	public RoleServiceImpl() {
		RoleDAO = new RoleDAO();
	}

	@Override
	public void GuardarRole(Role miRole) throws DuplicateException {
		RoleDAO.Guardar(miRole);
	}

	@Override
	public void ActualizarRole(Role miRole) throws GenericExeption {

	}

	@Override
	public void EliminarRole(Role miRole) throws GenericExeption {

	}

	@Override
	public List<Role> findRole() throws GenericExeption {
		
		return RoleDAO.findRole();
	}

	@Override
	public List<Role> findByRole(String Role) throws GenericExeption {

		return RoleDAO.findByRole(Role);
	}

	@Override
	public Role getRole(String codRole) throws GenericExeption {

		return RoleDAO.getRole(codRole);
	}

}
