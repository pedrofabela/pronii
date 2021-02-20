package gob.edugem.pronii.service;

import java.util.List;

import gob.edugem.pronii.model.TcNivelCertificacion;

public interface NivelCertificacionService {
	
	public List<TcNivelCertificacion> obtenerNiveles(Long nIdTipoCertificacion);

}
