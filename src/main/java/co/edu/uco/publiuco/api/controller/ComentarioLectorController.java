package co.edu.uco.publiuco.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.uco.publiuco.api.controller.response.Response;
import co.edu.uco.publiuco.api.validator.comentariolector.EliminarComentarioLectorValidation;
import co.edu.uco.publiuco.api.validator.comentariolector.ModificarComentarioLectorValidation;
import co.edu.uco.publiuco.api.validator.comentariolector.RegistrarComentarioLectorValidation;
import co.edu.uco.publiuco.busisness.facade.ComentarioLectorFacade;
import co.edu.uco.publiuco.busisness.facade.impl.ComentarioLectorFacadeImpl;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.dto.ComentarioLectorDTO;

public class ComentarioLectorController {
	private ComentarioLectorFacade facade;
	
	public ComentarioLectorController() {
		facade = new ComentarioLectorFacadeImpl();
	}
	
	@GetMapping("/dummy")
	public ComentarioLectorDTO dummy() {
		return ComentarioLectorDTO.create();
	}
	
	@GetMapping
	public ResponseEntity<Response<ComentarioLectorDTO>> list(@RequestParam ComentarioLectorDTO dto) {
		List<ComentarioLectorDTO> list = new ArrayList<>();
		
		List<String> messages = new ArrayList<>();
		messages.add("los comentarios han sido consultados exitosamente");
		
		Response<ComentarioLectorDTO> response = new Response<>(list,messages);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ComentarioLectorDTO listById(@PathVariable UUID id) {
		return ComentarioLectorDTO.create().setIdentificador(id);
	}
	
	@PostMapping
	public ResponseEntity<Response<ComentarioLectorDTO>> create(@RequestParam ComentarioLectorDTO dto) {
		var statusCode = HttpStatus.OK;
		Response<ComentarioLectorDTO> response = new Response<>();
		
		try {
			var result = RegistrarComentarioLectorValidation.validate(dto);
			if(result.getMessages().isEmpty()) {
				facade.register(dto);
				response.getMessages().add("El nuevo comentario fue registrado de forma satisfactoria");
			}else {
				statusCode = HttpStatus.BAD_REQUEST;
				response.setMessages(result.getMessages());
			}
		}catch (PubliucoException exception) {
			statusCode = HttpStatus.BAD_REQUEST;
			response.getMessages().add(exception.getUserMessage());
			System.err.println(exception.getTechnicalMessage());
			System.err.println(exception.getType());
			exception.printStackTrace();
			
		}catch (Exception exception) {
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			response.getMessages().add("Se ha presentado un problema inesperado. Por favor contacte con el administrador del sistema");
			System.err.println(exception.getMessage());
			exception.printStackTrace();
		}
		
		return new ResponseEntity<>(response,statusCode);
	}
	@PutMapping
	public ResponseEntity<Response<ComentarioLectorDTO>> update(@PathVariable UUID id, @RequestParam ComentarioLectorDTO dto) {
		var statusCode = HttpStatus.OK;
		var response = new Response<ComentarioLectorDTO>();
		
		try {
			var result = ModificarComentarioLectorValidation.validate(dto);
			if(result.getMessages().isEmpty()) {
				facade.modify(dto);
				response.getMessages().add("El comentario fue modificado de forma satisfactoria");
			}else {
				statusCode = HttpStatus.BAD_REQUEST;
				response.setMessages(result.getMessages());
			}
		}catch (PubliucoException exception) {
			statusCode = HttpStatus.BAD_REQUEST;
			response.getMessages().add(exception.getUserMessage());
			System.err.println(exception.getTechnicalMessage());
			System.err.println(exception.getType());
			exception.printStackTrace();
			
		}catch (Exception exception) {
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			response.getMessages().add("Se ha presentado un problema inesperado. Por favor contacte con el administrador del sistema");
			System.err.println(exception.getMessage());
			exception.printStackTrace();
		}
		
		return new ResponseEntity<>(response,statusCode);
	}
	@DeleteMapping
	public ResponseEntity<Response<ComentarioLectorDTO>> drop(@PathVariable UUID id) {
		var statusCode = HttpStatus.OK;
		var response = new Response<ComentarioLectorDTO>();
		
		try {
			var result = EliminarComentarioLectorValidation.validate(id);
			if(result.getMessages().isEmpty()) {
				facade.drop(id);
				response.getMessages().add("El comentario fue eliminado de forma satisfactoria");
			}else {
				statusCode = HttpStatus.BAD_REQUEST;
				response.setMessages(result.getMessages());
			}
		}catch (PubliucoException exception) {
			statusCode = HttpStatus.BAD_REQUEST;
			response.getMessages().add(exception.getUserMessage());
			System.err.println(exception.getTechnicalMessage());
			System.err.println(exception.getType());
			exception.printStackTrace();
			
		}catch (Exception exception) {
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			response.getMessages().add("Se ha presentado un problema inesperado. Por favor contacte con el administrador del sistema");
			System.err.println(exception.getMessage());
			exception.printStackTrace();
		}
		
		return new ResponseEntity<>(response,statusCode);
	}
}
