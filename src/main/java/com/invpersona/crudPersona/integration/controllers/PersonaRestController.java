package com.invpersona.crudPersona.integration.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invpersona.crudPersona.core.negocio.interfaces.PersonaServiceInterface;
import com.invpersona.crudPersona.core.util.AppException;
import com.invpersona.crudPersona.integration.dto.ErrorModelDTO;
import com.invpersona.crudPersona.integration.dto.PersonaCollectionDTO;
import com.invpersona.crudPersona.integration.dto.PersonaDTO;
import com.invpersona.crudPersona.integration.util.Constantes;
import com.invpersona.crudPersona.integration.util.Util;

@RestController
@RequestMapping("/persona")
public class PersonaRestController {
	
	protected final Logger logger = LogManager.getLogger(getClass());
	
	@Autowired
	public PersonaServiceInterface personaservice;
	
	public PersonaRestController() {
		
	}
	

	
	
	@GetMapping(path = "/listarPersona/{pagina}")
	public ResponseEntity<Object> getAllPersonaPagina(@PathVariable("pagina") String pagina) {
		PersonaCollectionDTO personacollectionDTO = null;
		ErrorModelDTO errorModelDTO = null;

		try {
			personacollectionDTO = getListaPersona(pagina);

			if (personacollectionDTO != null && personacollectionDTO.getListaPersona().size() != 0) {

				return new ResponseEntity<Object>(personacollectionDTO, HttpStatus.OK);
			} else {

				errorModelDTO = new ErrorModelDTO(Constantes.CodigoError.DATOS_NO_SE_ENCUENTRAN_REGISTRADOS.getCodigo(),
						Constantes.CodigoError.DATOS_NO_SE_ENCUENTRAN_REGISTRADOS.getMensage());
				return new ResponseEntity<Object>(personacollectionDTO, HttpStatus.OK);
			}
		}

		catch (AppException e) {
			logger.error(e);
			Constantes.CodigoError codigoError = Constantes.CodigoError.getCodigoError(e.getCodigo());
			if (codigoError != null)
				errorModelDTO = new ErrorModelDTO(codigoError.getCodigo(), codigoError.getMensage());
			else
				errorModelDTO = new ErrorModelDTO(Constantes.CodigoError.ERROR_TECNICO.getCodigo(), e.getMessage());
			return new ResponseEntity<Object>(errorModelDTO, HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (UncategorizedSQLException e) {
			logger.error(e);
			errorModelDTO = new ErrorModelDTO(Constantes.CodigoError.ERROR_TECNICO.getCodigo(), e.getMessage());
			return new ResponseEntity<Object>(errorModelDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			logger.error(e);
			errorModelDTO = new ErrorModelDTO(Constantes.CodigoError.ERROR_GENERICO.getCodigo(),
					Constantes.CodigoError.ERROR_GENERICO.getMensage());
			return new ResponseEntity<Object>(errorModelDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	} 
	

	@GetMapping(path = "/allPersona")
	public ResponseEntity<Object> getAllPersona() {
		List<PersonaDTO> listapersonaDTO = null;
		ErrorModelDTO errorModelDTO = null;

		try {
			listapersonaDTO = personaservice.getAllPersona();

			if (listapersonaDTO != null ) {

				return new ResponseEntity<Object>(listapersonaDTO, HttpStatus.OK);
			} else {

				errorModelDTO = new ErrorModelDTO(Constantes.CodigoError.DATOS_NO_SE_ENCUENTRAN_REGISTRADOS.getCodigo(),
						Constantes.CodigoError.DATOS_NO_SE_ENCUENTRAN_REGISTRADOS.getMensage());
				return new ResponseEntity<Object>(errorModelDTO, HttpStatus.NOT_FOUND);
			}
		}

		catch (AppException e) {
			logger.error(e);
			Constantes.CodigoError codigoError = Constantes.CodigoError.getCodigoError(e.getCodigo());
			if (codigoError != null)
				errorModelDTO = new ErrorModelDTO(codigoError.getCodigo(), codigoError.getMensage());
			else
				errorModelDTO = new ErrorModelDTO(Constantes.CodigoError.ERROR_TECNICO.getCodigo(), e.getMessage());
			return new ResponseEntity<Object>(errorModelDTO, HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (UncategorizedSQLException e) {
			logger.error(e);
			errorModelDTO = new ErrorModelDTO(Constantes.CodigoError.ERROR_TECNICO.getCodigo(), e.getMessage());
			return new ResponseEntity<Object>(errorModelDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			logger.error(e);
			errorModelDTO = new ErrorModelDTO(Constantes.CodigoError.ERROR_GENERICO.getCodigo(),
					Constantes.CodigoError.ERROR_GENERICO.getMensage());
			return new ResponseEntity<Object>(errorModelDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	@GetMapping(path = "/getPersona/{id}")
	public  ResponseEntity<Object> getConfiguracion(@PathVariable("id") String idpersona) throws AppException {
		PersonaDTO personaDTO = null;
		ErrorModelDTO errorModelDTO = null;

		try {
			
			
			personaDTO = personaservice.getPersona(idpersona);

			if (personaDTO != null) {

				return new ResponseEntity<Object>(personaDTO, HttpStatus.OK);
			} else {

				errorModelDTO = new ErrorModelDTO(Constantes.CodigoError.DATOS_NO_SE_ENCUENTRAN_REGISTRADOS.getCodigo(),
						Constantes.CodigoError.DATOS_NO_SE_ENCUENTRAN_REGISTRADOS.getMensage());
				return new ResponseEntity<Object>(errorModelDTO, HttpStatus.NOT_FOUND);
			}
		}

		catch (AppException e) {
			logger.error(e);
			Constantes.CodigoError codigoError = Constantes.CodigoError.getCodigoError(e.getCodigo());
			if (codigoError != null)
				errorModelDTO = new ErrorModelDTO(codigoError.getCodigo(), codigoError.getMensage());
			else
				errorModelDTO = new ErrorModelDTO(Constantes.CodigoError.ERROR_TECNICO.getCodigo(), e.getMessage());
			return new ResponseEntity<Object>(errorModelDTO, HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (UncategorizedSQLException e) {
			logger.error(e);
			errorModelDTO = new ErrorModelDTO(Constantes.CodigoError.ERROR_TECNICO.getCodigo(), e.getMessage());
			return new ResponseEntity<Object>(errorModelDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			logger.error(e);
			errorModelDTO = new ErrorModelDTO(Constantes.CodigoError.ERROR_GENERICO.getCodigo(),
					Constantes.CodigoError.ERROR_GENERICO.getMensage());
			return new ResponseEntity<Object>(errorModelDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping(path = "/createPersona")
	public ResponseEntity<Object> addConfiguracion(@RequestBody PersonaDTO personadto){
		PersonaDTO personadtotmp;
		ErrorModelDTO errorModelDTO = null;
		try {
			if (personadto != null) {
				  
				if (   personadto.getHeight()!=null &&  personadto.getHeight().getClass().getName().equals("java.lang.Long") &&
				   
						personadto.getMass()!=null &&  personadto.getMass().getClass().getName().equals("java.lang.Double") &&
						 
						personadto.getName()!=null && personadto.getName().length() <=200 	   
				     ) {

					 if(Util.validacionPlaneta(personadto.getPlanet())==0) {
						 errorModelDTO = new ErrorModelDTO(Constantes.CodigoError.PLANETA_NO_EXISTE.getCodigo(),
									Constantes.CodigoError.PLANETA_NO_EXISTE.getMensage());
							return new ResponseEntity<Object>(errorModelDTO, HttpStatus.INTERNAL_SERVER_ERROR); 
						 
					 }else {
						 personadtotmp = personaservice.createPersona(personadto);
							return new ResponseEntity<Object>(personadtotmp, HttpStatus.CREATED);
					 }
					

				} else {
					errorModelDTO = new ErrorModelDTO(Constantes.CodigoError.DATOS_ENTRADAS_ERRONEOS.getCodigo(),
							Constantes.CodigoError.DATOS_ENTRADAS_ERRONEOS.getMensage());
					return new ResponseEntity<Object>(errorModelDTO, HttpStatus.BAD_REQUEST);
				}

			} else {

				errorModelDTO = new ErrorModelDTO(Constantes.CodigoError.DATOS_ENTRADAS_ERRONEOS.getCodigo(),
						Constantes.CodigoError.DATOS_ENTRADAS_ERRONEOS.getMensage());
				return new ResponseEntity<Object>(errorModelDTO, HttpStatus.BAD_REQUEST);

			}

		} catch (AppException e) {
			logger.error(e);
			Constantes.CodigoError codigoError = Constantes.CodigoError.getCodigoError(e.getCodigo());
			if (codigoError != null)
				errorModelDTO = new ErrorModelDTO(codigoError.getCodigo(), codigoError.getMensage());
			else
				errorModelDTO = new ErrorModelDTO(Constantes.CodigoError.ERROR_TECNICO.getCodigo(), e.getMessage());
			return new ResponseEntity<Object>(errorModelDTO, HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (UncategorizedSQLException e) {
			logger.error(e);
			errorModelDTO = new ErrorModelDTO(Constantes.CodigoError.ERROR_TECNICO.getCodigo(), e.getMessage());
			return new ResponseEntity<Object>(errorModelDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			logger.error(e);
			errorModelDTO = new ErrorModelDTO(Constantes.CodigoError.ERROR_GENERICO.getCodigo(),
					Constantes.CodigoError.ERROR_GENERICO.getMensage());
			return new ResponseEntity<Object>(errorModelDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@PutMapping(path = "/updatePersona")
	public ResponseEntity<Object> updconfiguracion(@RequestBody PersonaDTO personadto) {

		PersonaDTO personadtotmp;
		ErrorModelDTO errorModelDTO = null;
		
		try {
			if (personadto != null) {
				if (personadto.getPersonaId()!= null
						&& personadto.getPersonaId().getClass().getName().equals("java.lang.Long")

				) {
                  
					 if(Util.validacionPlaneta(personadto.getPlanet())==0) {
						
						 errorModelDTO = new ErrorModelDTO(Constantes.CodigoError.PLANETA_NO_EXISTE.getCodigo(),
									Constantes.CodigoError.PLANETA_NO_EXISTE.getMensage());
							return new ResponseEntity<Object>(errorModelDTO, HttpStatus.INTERNAL_SERVER_ERROR); 
						 
					 }else {
						 
						 personadtotmp = personaservice.updatePersona(personadto);
							return new ResponseEntity<Object>(personadtotmp, HttpStatus.OK);
					 }
					

				} else {
					errorModelDTO = new ErrorModelDTO(Constantes.CodigoError.DATOS_ENTRADAS_ERRONEOS.getCodigo(),
							Constantes.CodigoError.DATOS_ENTRADAS_ERRONEOS.getMensage());
					return new ResponseEntity<Object>(errorModelDTO, HttpStatus.BAD_REQUEST);
				}

			} else {

				errorModelDTO = new ErrorModelDTO(Constantes.CodigoError.DATOS_ENTRADAS_ERRONEOS.getCodigo(),
						Constantes.CodigoError.DATOS_ENTRADAS_ERRONEOS.getMensage());
				return new ResponseEntity<Object>(errorModelDTO, HttpStatus.BAD_REQUEST);

			}

		} catch (AppException e) {
			logger.error(e);
			Constantes.CodigoError codigoError = Constantes.CodigoError.getCodigoError(e.getCodigo());
			if (codigoError != null)
				errorModelDTO = new ErrorModelDTO(codigoError.getCodigo(), codigoError.getMensage());
			else
				errorModelDTO = new ErrorModelDTO(Constantes.CodigoError.ERROR_TECNICO.getCodigo(), e.getMessage());
			return new ResponseEntity<Object>(errorModelDTO, HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (UncategorizedSQLException e) {
			logger.error(e);
			errorModelDTO = new ErrorModelDTO(Constantes.CodigoError.ERROR_TECNICO.getCodigo(), e.getMessage());
			return new ResponseEntity<Object>(errorModelDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			logger.error(e);
			errorModelDTO = new ErrorModelDTO(Constantes.CodigoError.ERROR_GENERICO.getCodigo(),
					Constantes.CodigoError.ERROR_GENERICO.getMensage());
			return new ResponseEntity<Object>(errorModelDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping(path = "/deletePersona/{id}")
	public ResponseEntity<Object> deletePersona(@PathVariable("id") String idPersona) {

		String configuracioncampoDTOtmp ="";
		ErrorModelDTO errorModelDTO = null;
		try { 
			
				if ( idPersona != null
					) {

					configuracioncampoDTOtmp = personaservice.deletePersona(idPersona);
					return new ResponseEntity<Object>(configuracioncampoDTOtmp, HttpStatus.CREATED);	
					
				} else {
					errorModelDTO = new ErrorModelDTO(Constantes.CodigoError.DATOS_ENTRADAS_ERRONEOS.getCodigo(),
							Constantes.CodigoError.DATOS_ENTRADAS_ERRONEOS.getMensage());
					return new ResponseEntity<Object>(errorModelDTO, HttpStatus.BAD_REQUEST);
				}

		    
		} catch (AppException e) {
			logger.error(e);
			Constantes.CodigoError codigoError = Constantes.CodigoError.getCodigoError(e.getCodigo());
			if (codigoError != null)
				errorModelDTO = new ErrorModelDTO(codigoError.getCodigo(), codigoError.getMensage());
			else
				errorModelDTO = new ErrorModelDTO(Constantes.CodigoError.ERROR_TECNICO.getCodigo(), e.getMessage());
			return new ResponseEntity<Object>(errorModelDTO, HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (UncategorizedSQLException e) {
			logger.error(e);
			errorModelDTO = new ErrorModelDTO(Constantes.CodigoError.ERROR_TECNICO.getCodigo(), e.getMessage());
			return new ResponseEntity<Object>(errorModelDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			logger.error(e);
			errorModelDTO = new ErrorModelDTO(Constantes.CodigoError.ERROR_GENERICO.getCodigo(),
					Constantes.CodigoError.ERROR_GENERICO.getMensage());
			return new ResponseEntity<Object>(errorModelDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private PersonaCollectionDTO getListaPersona(String pagina) throws Exception{
		
		
		PersonaCollectionDTO personaollectiondto = personaservice.findByParametros(Integer.parseInt(pagina) ,8);
				
		return personaollectiondto;
	}
	
	
}
