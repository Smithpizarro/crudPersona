
package com.invpersona.crudPersona.core.util;

public class AppException extends Exception {
	
	private static final String ERROR="ERROR: ";
	
	private String codigo;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AppException(Throwable cause){
		super(cause);
		this.codigo = null;
		
		if(cause.getCause() != null) {			
			String message = cause.getCause().getMessage();
			if(message.contains(ERROR))
				if(message.contains("\n"))
					this.codigo = cause.getCause().getMessage().substring(ERROR.length(), cause.getCause().getMessage().indexOf("\n"));
				else
					this.codigo = cause.getCause().getMessage().substring(ERROR.length());
		}
		
		
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
