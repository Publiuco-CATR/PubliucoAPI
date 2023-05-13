package co.edu.uco.publiuco.api.validator.TipoEstado.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilText;
import co.edu.uco.publiuco.utils.UtilUUID;

public class nombreValidation implements Validation<String>{

	private nombreValidation() {
		super();
	}
	
	public static final Result validate(final String data) {
		return new nombreValidation().excecute(data);
	}
	
	@Override
	public Result excecute(String data) {

		var result = Result.create();
		
		if (UtilText.getUtilText().isEmpty(data)) {
			result.addMessage("No es posible continuar con el identificador de tipo estado vacio");
		} else { 
			if (true) {
				//minimo 1 máximo 30
				//validar longitud de la cadena
				result.addMessage("El nombre del tipo estado no debe ser menor a 1 y mayor a 30 caracteres");
			}
			if (true) {
				//formato: solo letras y espacios
				result.addMessage("El nombre de un tipo de estado solo puede tener nombres y espacios.");
			}
		}
		
		return result;
	}
	
}
