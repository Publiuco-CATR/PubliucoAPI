package co.edu.uco.publiuco.api.validator.TipoEstado;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.api.validator.TipoEstado.common.descripcionValidation;
import co.edu.uco.publiuco.api.validator.TipoEstado.common.nombreValidation;
import co.edu.uco.publiuco.dto.TipoEstadoDTO;
import co.edu.uco.publiuco.utils.UtilObject;

public final class RegistrarTipoEstadoValidation implements Validation<TipoEstadoDTO>{

	private RegistrarTipoEstadoValidation() {
		super();
	}
	
	public static final Result validate(final TipoEstadoDTO data) {
		return new RegistrarTipoEstadoValidation().excecute(data);
	}
	
	@Override
	public final Result excecute(final TipoEstadoDTO data) {
		var result = Result.create();
		
		if (UtilObject.isNull(data)) {
			result.addMessage("No es posible registrar un nuevo TipoEstado con los datos vacios"); //llevas a la clase uitl.message;
		}else {
			result.addMessages(nombreValidation.validate(data.getNombre()).getMessages());
			result.addMessages(descripcionValidation.validate(data.getDescripcion()).getMessages());
		}
		
		return result;
	}

}
