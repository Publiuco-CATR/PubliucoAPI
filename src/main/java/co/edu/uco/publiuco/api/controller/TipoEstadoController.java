package co.edu.uco.publiuco.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.publiuco.api.controller.response.Response;
import co.edu.uco.publiuco.api.validator.tipoestado.RegistrarTipoEstadoValidation;
import co.edu.uco.publiuco.busisness.facade.impl.TipoEstadoFacadeImpl;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.dto.TipoEstadoDTO;

@RestController
@RequestMapping("publiuco/api/v1/tipoEstado")
public final class TipoEstadoController {
	
	private TipoEstadoFacadeImpl facade;
	
	public TipoEstadoController() {
		facade = new TipoEstadoFacadeImpl();
	}

	@GetMapping("/dummy")
	public TipoEstadoDTO dummy() {
		return TipoEstadoDTO.create();
	}
	
	@PostMapping
	public ResponseEntity<Response<TipoEstadoDTO>> create(@RequestParam TipoEstadoDTO dto) {
		var statusCode = HttpStatus.OK;
		var response = new Response<TipoEstadoDTO>();
		
		try {
			var result = RegistrarTipoEstadoValidation.validate(dto);
			if (result.toString().isEmpty()) {
				facade.register(dto);
				response.getMessages().add("El nuevo tipo estado ha sido registrado de forma satisfactoria");
			} else {
				statusCode =  HttpStatus.BAD_REQUEST;
				response.setMessages(result.getMessages());
			}
		} catch (PubliucoException exception) {
			statusCode =  HttpStatus.BAD_REQUEST;
			response.getMessages().add(exception.getUserMessage());
		} catch (Exception exception) {
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			response.getMessages().add("Se ha presentado un problema inesperado. Por favor intentar de nuevo y si el problema persiste contactar al soporte...");
		}
		
		return new ResponseEntity<>(response, statusCode);
	}
	
	@GetMapping
	public ResponseEntity<Response<TipoEstadoDTO>> list(@RequestParam TipoEstadoDTO dto) {
		List<TipoEstadoDTO> list = new ArrayList<>();
		list.add(TipoEstadoDTO.create());
		list.add(TipoEstadoDTO.create());
		list.add(TipoEstadoDTO.create());
		list.add(TipoEstadoDTO.create());
		list.add(TipoEstadoDTO.create());
		// validador consulta SQL 
		//Retornar respuesta(Lista de datos que retorno la fachada) y status code y messages del validator
		List<String> messages = new ArrayList<>();
		messages.add("Tipo Estados consultados existosamente");
		
		Response<TipoEstadoDTO> response = new Response<>(list, messages);
		
		return new ResponseEntity<Response<TipoEstadoDTO>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public TipoEstadoDTO listById(@PathVariable UUID id) {
		return TipoEstadoDTO.create().setIdentificador(id);
	}
	
	@PutMapping("/{id}")
	public TipoEstadoDTO update(@PathVariable UUID id, @RequestParam TipoEstadoDTO dto) {
		return dto.setIdentificador(id);
	}
	
	@DeleteMapping("/{id}")
	public TipoEstadoDTO delete(@PathVariable UUID id) {
		return TipoEstadoDTO.create().setIdentificador(id);
	}
}
