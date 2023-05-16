package co.edu.uco.publiuco.api.validator.tipoestado;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.api.validator.estado.common.DescripcionValidation;
import co.edu.uco.publiuco.api.validator.estado.common.NombreValidation;
import co.edu.uco.publiuco.api.validator.tipoestado.common.descripcionValidation;
import co.edu.uco.publiuco.api.validator.tipoestado.common.nombreValidation;
import co.edu.uco.publiuco.dto.TipoEstadoDTO;
import co.edu.uco.publiuco.utils.UtilObject;

public final class RegistrarTipoEstadoValidation implements Validation<TipoEstadoDTO>{

	private RegistrarTipoEstadoValidation() {
		super();
	}
	
	public static final Result validate(final TipoEstadoDTO data) {
		return new RegistrarTipoEstadoValidation().execute(data);
	}
	
	@Override
	public final Result execute(final TipoEstadoDTO data) {
		var result = Result.create();
		
		if (UtilObject.isNull(data)) {
			result.addMessage("No es posible registrar un nuevo TipoEstado con los datos vacios"); //llevas a la clase uitl.message;
		}else {
			result.addMessages(NombreValidation.validate(data.getNombre()).getMessages());
			result.addMessages(DescripcionValidation.validate(data.getDescripcion()).getMessages());
		}
		
		return result;
	}

}
