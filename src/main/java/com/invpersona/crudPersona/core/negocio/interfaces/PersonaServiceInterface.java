package com.invpersona.crudPersona.core.negocio.interfaces;

import java.util.List;

import com.invpersona.crudPersona.core.util.AppException;
import com.invpersona.crudPersona.integration.dto.PersonaCollectionDTO;
import com.invpersona.crudPersona.integration.dto.PersonaDTO;


public interface PersonaServiceInterface {

	
	public  List<PersonaDTO>  getAllPersona() throws AppException;
	
	public  PersonaCollectionDTO findByParametros (Integer pagina , Integer paginado)  throws AppException;
	
	public  PersonaDTO getPersona(String idPersona) throws AppException;

	public  PersonaDTO createPersona(PersonaDTO personadto) throws AppException;
    public  PersonaDTO updatePersona(PersonaDTO personadto) throws AppException;
  
    public  String deletePersona(String idPersona) throws AppException;
}
