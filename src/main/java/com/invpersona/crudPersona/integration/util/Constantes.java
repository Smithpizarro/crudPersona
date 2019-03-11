package com.invpersona.crudPersona.integration.util;

public class Constantes {
	

	public enum CodigoError{
		ERROR_GENERICO("EAE0000","Estimado Cliente, en este momento no lo podemos atender. Intente en unos instantes."),
		ERROR_TECNICO("EAE0000",""),
		DATOS_ENTRADAS_ERRONEOS("EAE0001","DATOS ENTRADA ERRONEOS"),
		DATOS_SE_ENCUENTRAN_REGISTRADOS("EAE0002","DATOS SE ENCUENTRAN REGISTRADOS"),
		DATOS_NO_SE_ENCUENTRAN_REGISTRADOS("EAE0003","DATOS NO SE ENCUENTRAN REGISTRADOS"),
		PLANETA_NO_EXISTE("EAE500","El nombre de planeta ingresado no existe");
		private CodigoError(String codigo, String mensage) {
			this.setCodigo(codigo);
			this.setMensage(mensage);
		}
		
		String codigo;
		String mensage;
		
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
		
		public static CodigoError getCodigoError(String codigo) {
			for(CodigoError codigoError: CodigoError.values()) {
				if(codigoError.getCodigo().equals(codigo)) {
					return codigoError;
				}
			}
			return null;
		}
		
	}
}
