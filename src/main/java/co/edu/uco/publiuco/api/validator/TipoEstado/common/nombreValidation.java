package co.edu.uco.publiuco.api.validator.tipoestado.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilText;
import co.edu.uco.publiuco.utils.UtilUUID;

public class nombreValidation implements Validation<String>{

	private static final int MINIMUN_LENGHT = 1;
	private static final int MAXIMUN_LENGHT = 150;
	
	private nombreValidation() {
		super();
	}
	
	public static final Result validate(final String data) {
		return new nombreValidation().execute(data);
	}
	
	@Override
	public Result execute(String data) {

		var result = Result.create();
		
		if (UtilText.isEmpty(data)) {
			result.addMessage("No es posible continuar con el nombre de tipo estado vacio");
		} 
		else { 
			if (!UtilText.getUtilText().textHasLenghtAllowed(data, MINIMUN_LENGHT, MAXIMUN_LENGHT)) {
				result.addMessage("El nombre del tipo estado no debe ser menor a 1 y mayor a 30 caracteres");
			}
			if (!UtilText.getUtilText().textHasOnlyLetters(data)) {
				result.addMessage("El nombre de un tipo de estado solo puede tener nombres y espacios.");
			}
		}
		
		return result;
	}
	
}
