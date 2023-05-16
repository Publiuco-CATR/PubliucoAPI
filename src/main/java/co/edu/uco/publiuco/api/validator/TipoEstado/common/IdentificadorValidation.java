package co.edu.uco.publiuco.api.validator.tipoestado.common;

import java.util.UUID;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilUUID;

public final class IdentificadorValidation implements Validation<UUID> {
	
	private IdentificadorValidation() {
		super();
	}
	
	public static final Result validate(final UUID data) {
		return new IdentificadorValidation().execute(data);
	}

	@Override
	public final Result execute(final UUID data) {
		var result = Result.create();
		
		if (UtilObject.isNull(data)) {
			result.addMessage("No es posible continuar con el identificador de tipo estado vacio");
		}
		
		if (UtilUUID.isDefault(data)) {
			result.addMessage("No es posible tener el identificador por defecto del tipo estado.");
		}
		
		return result;
	}

}
