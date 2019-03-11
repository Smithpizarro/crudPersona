package com.invpersona.crudPersona.integration.dto;


import java.io.Serializable;


public class ErrorModelDTO implements Serializable {

	
	private static final long serialVersionUID = 2280401299648354981L;
	
	String codigo;
	String mensage;
	
	
	public ErrorModelDTO(String codigo, String mensage) {
		super();
		this.codigo = codigo;
		this.mensage = mensage;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getMensage() {
		return mensage;
	}
	public void setMensage(String mensage) {
		this.mensage = mensage;
	}
	
}
