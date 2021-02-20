package gob.edugem.pronii.service.impl;

import gob.edugem.pronii.dto.DtoDatosCurp;
import gob.edugem.pronii.service.WsConsultaCurpService;
import mx.gob.edomex.dgsei.ws.ConsultaDatosRenapo;
import mx.gob.edomex.dgsei.ws.ConsultaRenapoPorCurp;
import mx.gob.edomex.dgsei.ws.PersonasDTO;

public class WsConsultaCurpServiceImpl implements WsConsultaCurpService {

	ConsultaDatosRenapo service = null;
	ConsultaRenapoPorCurp port;
	PersonasDTO personas;

	public DtoDatosCurp consultaCurp(String curp) {
		
		DtoDatosCurp data= new DtoDatosCurp();

		try {

			System.out.println("MICURP ES: " + curp);
			service = new ConsultaDatosRenapo();
			port = service.getConsultaRenapoPorCurpPort();
			personas = port.consultaPorCurp(curp);
			// port.consultaPorCurp(micurp)

			System.err.println("resultado de renapo" + personas.getResultado());

			if (personas.getResultado().equals("EXITO")) {

				data.setsNombre(personas.getNombre());
				data.setsApellidoPaterno(personas.getApellidoPaterno());
				data.setsApellidoMaterno(personas.getApellidoMaterno());
				data.setsFechaNacimiento(personas.getFechaNacimientoAxu());
				data.setsCurp(personas.getCurp());

				if (personas.getSexo().equals("H")) {
					data.setsSexo(1L);
				} else {
					data.setsSexo(2L);
				}
			} 
			
			data.setResultado(personas.getResultado());

		} catch (Exception e) {

		}
		
		return data;

	}

}
