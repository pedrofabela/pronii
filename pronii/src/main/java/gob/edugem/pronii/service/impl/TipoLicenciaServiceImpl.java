package gob.edugem.pronii.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.edugem.pronii.model.TcTipoLicencia;
import gob.edugem.pronii.repository.TipoLicenciaRepository;
import gob.edugem.pronii.service.TipoLicenciaService;
@Service
public class TipoLicenciaServiceImpl implements TipoLicenciaService {
	
	@Autowired
	private TipoLicenciaRepository tipoLicenciaRepository;

	@Override
	public List<TcTipoLicencia> obtenerTipoLicencias() {
		
		return tipoLicenciaRepository.findBynEstatus(1);
	}

}
