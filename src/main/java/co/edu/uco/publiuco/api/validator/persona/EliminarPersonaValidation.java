package co.edu.uco.publiuco.api.validator.persona;

import java.util.UUID;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.api.validator.estado.common.IdentificadorValidation;
import co.edu.uco.publiuco.utils.UtilObject;

public final class EliminarPersonaValidation implements Validation<UUID>{

	public static final Result validate(final UUID data) {
		return new EliminarPersonaValidation().execute(data);
	}
	private EliminarPersonaValidation() {
		super();
	}
	
	@Override
	public Result execute(final UUID data) {
		var result = Result.create();
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible eliminar la persona");
		}else {
			result.addMessages(IdentificadorValidation.validate(data).getMessages());
		}
		return result;
		
	}

}
