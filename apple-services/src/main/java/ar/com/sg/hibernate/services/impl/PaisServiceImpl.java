package ar.com.sg.hibernate.services.impl;

import java.util.List;

import ar.com.sg.hibernate.dao.exceptions.DuplicateException;
import ar.com.sg.hibernate.dao.exceptions.GenericExeption;
import ar.com.sg.hibernate.dao.impl.PaisDAO;
import ar.com.sg.hibernate.domain.Pais;
import ar.com.sg.hibernate.services.IPaisService;

public class PaisServiceImpl implements IPaisService {

	private PaisDAO PaisDAO;

	public PaisServiceImpl() {
		PaisDAO = new PaisDAO();
	}

	@Override
	public void GuardarPais(Pais miPais) throws DuplicateException {
	}

	@Override
	public void ActualizarPais(Pais miPais) throws GenericExeption {

	}

	@Override
	public void EliminarPais(Pais miPais) throws GenericExeption {

	}

	@Override
	public List<Pais> findPais() throws GenericExeption {
		
		return PaisDAO.findPais();
	}

	@Override
	public List<Pais> findByPais(String pais) throws GenericExeption {

		return PaisDAO.findByPais(pais);
	}

	@Override
	public Pais getPais(String codPais) throws GenericExeption {

		return PaisDAO.getPais(codPais);
	}

}
