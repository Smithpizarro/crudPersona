package com.invpersona.crudPersona.integration.dto;


import java.io.Serializable;
import java.util.List;



public class PersonaCollectionDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<PersonaDTO> listaPersona;
	private PaginacionModel paginacion;
	
	public List<PersonaDTO> getListaPersona() {
		return listaPersona;
	}
	public void setListaPersona(List<PersonaDTO> listaPersona) {
		this.listaPersona = listaPersona;
	}
	public PaginacionModel getPaginacion() {
		return paginacion;
	}
	public void setPaginacion(PaginacionModel paginacion) {
		this.paginacion = paginacion;
	}


}
