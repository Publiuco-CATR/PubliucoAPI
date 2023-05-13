package co.edu.uco.publiuco.api.validator.TipoEstado.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.utils.UtilText;
import co.edu.uco.publiuco.utils.UtilUUID;

public class descripcionValidation implements Validation<String>{

	private descripcionValidation() {
		super();
	}
	
	public static final Result validate(final String data) {
		return new descripcionValidation().excecute(data);
	}
	
	@Override
	public Result excecute(String data) {
		
		var result = Result.create();
	
		if (true) {
			//minimo 1 máximo 30
			//validar longitud de la cadena
			result.addMessage("El nombre del tipo estado no debe ser mayor a 250 caracteres...");
		}
		return result;
	}
	
}
