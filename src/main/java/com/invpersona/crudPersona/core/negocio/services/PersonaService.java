package com.invpersona.crudPersona.core.negocio.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invpersona.crudPersona.core.accesodato.interfaces.PersonaDaoInterface;
import com.invpersona.crudPersona.integration.dto.*;
import com.invpersona.crudPersona.core.negocio.bean.Persona;
import com.invpersona.crudPersona.core.negocio.bean.PersonaCollection;
import com.invpersona.crudPersona.core.negocio.interfaces.PersonaServiceInterface;
import com.invpersona.crudPersona.core.util.AppException;
import com.invpersona.crudPersona.integration.dto.PersonaCollectionDTO;
import com.invpersona.crudPersona.integration.dto.PersonaDTO;
import com.invpersona.crudPersona.integration.util.Constantes;
import com.invpersona.crudPersona.integration.util.Util;

@Service
public class PersonaService implements PersonaServiceInterface {

	private Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	public PersonaDaoInterface personaDao;

	@Override
	public List<PersonaDTO> getAllPersona() throws AppException {

		List<Persona> listapersona = personaDao.getAllPersona();

		List<PersonaDTO> listapersonadto = null;

		if (listapersona != null) {
			return Util.mapAtoBB(listapersona);
		} else {
			return listapersonadto;
		}
	}

	@Override
	public PersonaCollectionDTO findByParametros(Integer pagina, Integer paginado) throws AppException {

		Integer totalRegistros = personaDao.listaTablaByParametrosTotalCount(pagina, paginado);

		PaginacionModel paginacion = new PaginacionModel();
		paginacion.setPagina(pagina);
		paginacion.setCantidadRegistros(paginado);
		paginacion.setTotalRegistros(totalRegistros);
		paginacion.setIndicadorPaginacion(true);
		Double cantidadPaginas = Math
				.ceil(paginacion.getTotalRegistros() / new Double(paginacion.getCantidadRegistros()));
		paginacion.setCantidadPaginas(cantidadPaginas.intValue());

		List<Persona> listaTabla = personaDao.listaTablaByParametros(pagina, paginado);

		PersonaCollection personaCollection = new PersonaCollection();
		personaCollection.setListaPersona(listaTabla);

		PersonaCollectionDTO personaCollectiondto = Util.mapAtoB(personaCollection);

		personaCollectiondto.setPaginacion(paginacion);

		return personaCollectiondto;

	}

	@Override
	public PersonaDTO getPersona(String idPersona) throws AppException {

		Persona persona = null;
		PersonaDTO personadto = null;
		String mensajeError = null;

		try {

			persona = personaDao.getPersona(idPersona);

			if (persona != null) {
				return Util.mapAtoB(persona);
			} else {
				return personadto;
			}

		} catch (Exception e) {

			mensajeError = e.getMessage();

			logger.info(mensajeError);

			if (e instanceof AppException) {
				Constantes.CodigoError codigoError = Constantes.CodigoError
						.getCodigoError(((AppException) e).getCodigo());
				if (codigoError != null)
					mensajeError = codigoError.getCodigo() + ": " + codigoError.getMensage();
			}
			throw e;

		}
	}

	@Override
	public PersonaDTO createPersona(PersonaDTO personadto) throws AppException {

		Persona persona = null;

		String mensajeError = null;

		try {
			persona = Util.mapAtoB(personadto);

			persona = personaDao.createPersona(persona);

		} catch (Exception e) {

			mensajeError = e.getMessage();

			logger.info(mensajeError);

			if (e instanceof AppException) {
				Constantes.CodigoError codigoError = Constantes.CodigoError
						.getCodigoError(((AppException) e).getCodigo());
				if (codigoError != null)
					mensajeError = codigoError.getCodigo() + ": " + codigoError.getMensage();
			}
			throw e;

		}
		return Util.mapAtoB(persona);
	}

	@Override
	public PersonaDTO updatePersona(PersonaDTO personadto) throws AppException {

		Persona persona = null;

		String mensajeError = null;

		try {
			persona = Util.mapAtoB(personadto);

			persona = personaDao.updatePersona(persona);

		} catch (Exception e) {

			mensajeError = e.getMessage();

			logger.info(mensajeError);

			if (e instanceof AppException) {
				Constantes.CodigoError codigoError = Constantes.CodigoError
						.getCodigoError(((AppException) e).getCodigo());
				if (codigoError != null)
					mensajeError = codigoError.getCodigo() + ": " + codigoError.getMensage();
			}
			throw e;

		}
		return Util.mapAtoB(persona);
	}

	@Override
	public String deletePersona(String idPersona) throws AppException {

		String personamsj = null;

		String mensajeError = null;

		try {
		
			personamsj = personaDao.deletePersna(idPersona);

		} catch (Exception e) {

			mensajeError = e.getMessage();

			logger.info(mensajeError);

			if (e instanceof AppException) {
				Constantes.CodigoError codigoError = Constantes.CodigoError
						.getCodigoError(((AppException) e).getCodigo());
				if (codigoError != null)
					mensajeError = codigoError.getCodigo() + ": " + codigoError.getMensage();
			}
			throw e;

		}
		return personamsj;
	}
}
