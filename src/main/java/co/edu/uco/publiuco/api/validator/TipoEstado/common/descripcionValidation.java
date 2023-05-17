package co.edu.uco.publiuco.api.validator.tipoestado.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.utils.UtilText;

public class descripcionValidation implements Validation<String>{

	private static final int MINIMUN_LENGHT = 1;
	private static final int MAXIMUN_LENGHT = 150;
	
	private descripcionValidation() {
		super();
	}
	
	public static final Result validate(final String data) {
		return new descripcionValidation().execute(data);
	}
	
	@Override
	public Result execute(String data) {
		
		final var result = Result.create();
		if (UtilText.isEmpty(data)) {
			result.addMessage("No es posible continuar con la descripcion de tipo estado vacio");
		} 
		else {
			if (!UtilText.getUtilText().textHasLenghtAllowed(data, MINIMUN_LENGHT, MAXIMUN_LENGHT)) {			
				result.addMessage("El nombre del tipo estado no debe ser mayor a 200 caracteres...");
			}
		}
		return result;
	}
	
}
