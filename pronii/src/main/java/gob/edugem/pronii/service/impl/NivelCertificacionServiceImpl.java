package gob.edugem.pronii.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.edugem.pronii.model.TcNivelCertificacion;
import gob.edugem.pronii.repository.NivelCertificacionRepository;
import gob.edugem.pronii.service.NivelCertificacionService;
@Service
public class NivelCertificacionServiceImpl implements NivelCertificacionService {
	
	@Autowired
	private NivelCertificacionRepository nivelCertificacionRepository;

	@Override
	public List<TcNivelCertificacion> obtenerNiveles(Long nIdTipoCertificacion) {
		
		return nivelCertificacionRepository.findBynIdTipoCertificacionAndnEstatus(nIdTipoCertificacion, 1);
	}

}
