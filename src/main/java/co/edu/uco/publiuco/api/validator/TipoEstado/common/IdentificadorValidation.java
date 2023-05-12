package co.edu.uco.publiuco.api.validator.TipoEstado.common;

import java.util.UUID;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;

public final class IdentificadorValidation implements Validation<UUID> {
	
	private IdentificadorValidation() {
		super();
	}
	
	public static final Result validate(final UUID data) {
		return new IdentificadorValidation().excecute(data);
	}

	@Override
	public final Result excecute(final UUID data) {
		// TODO Auto-generated method stub
		return null;
	}

}
