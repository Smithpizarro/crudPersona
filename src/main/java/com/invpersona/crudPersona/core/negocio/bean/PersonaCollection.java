package com.invpersona.crudPersona.core.negocio.bean;


import java.io.Serializable;
import java.util.List;



public class PersonaCollection implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Persona> listaPersona;
	private PaginacionModel paginacion;
	
	public List<Persona> getListaPersona() {
		return listaPersona;
	}
	public void setListaPersona(List<Persona> listaPersona) {
		this.listaPersona = listaPersona;
	}
	public PaginacionModel getPaginacion() {
		return paginacion;
	}
	public void setPaginacion(PaginacionModel paginacion) {
		this.paginacion = paginacion;
	}


}
