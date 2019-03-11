package com.invpersona.crudPersona.core.accesodato.interfaces;

import java.util.List;

import com.invpersona.crudPersona.core.negocio.bean.Persona;
import com.invpersona.crudPersona.core.util.AppException;


public interface PersonaDaoInterface {

	
	public Integer listaTablaByParametrosTotalCount(Integer pagina, Integer paginado) throws AppException;
	public List<Persona> listaTablaByParametros( Integer pagina, Integer paginado) throws AppException;
   
	public  List<Persona>  getAllPersona() throws AppException;
	
	public  Persona getPersona(String idPersona) throws AppException;

	public  Persona createPersona(Persona persona) throws AppException;
    public  Persona updatePersona(Persona persona) throws AppException;
  
    public  String deletePersna(String idPersona) throws AppException;
}
