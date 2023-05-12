package co.edu.uco.publiuco.api.validator.TipoEstado.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;

public class descripcionValidation implements Validation<String>{

	private descripcionValidation() {
		super();
	}
	
	public static final Result validate(final String data) {
		return new descripcionValidation().excecute(data);
	}
	
	@Override
	public Result excecute(String data) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
