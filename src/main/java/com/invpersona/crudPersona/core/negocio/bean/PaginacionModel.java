package com.invpersona.crudPersona.core.negocio.bean;

import java.io.Serializable;

public class PaginacionModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int pagina;
	private int cantidadRegistros;
	private int totalRegistros;
	private int cantidadPaginas;
	private boolean indicadorPaginacion;
	
	public int getPagina() {
		return pagina;
	}
	public void setPagina(int pagina) {
		this.pagina = pagina;
	}
	public int getCantidadRegistros() {
		return cantidadRegistros;
	}
	public void setCantidadRegistros(int cantidadRegistros) {
		this.cantidadRegistros = cantidadRegistros;
	}
	public int getTotalRegistros() {
		return totalRegistros;
	}
	public void setTotalRegistros(int totalRegistros) {
		this.totalRegistros = totalRegistros;
	}
	public int getCantidadPaginas() {
		return cantidadPaginas;
	}
	public void setCantidadPaginas(int cantidadPaginas) {
		this.cantidadPaginas = cantidadPaginas;
	}

	public boolean isIndicadorPaginacion() {
		return indicadorPaginacion;
	}
	public void setIndicadorPaginacion(boolean indicadorPaginacion) {
		this.indicadorPaginacion = indicadorPaginacion;
	}
}