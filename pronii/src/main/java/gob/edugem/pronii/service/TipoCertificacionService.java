package gob.edugem.pronii.service;

import java.util.List;

import gob.edugem.pronii.model.TcTipoCertificacion;

public interface TipoCertificacionService {
	
	public List<TcTipoCertificacion> obtenerTipoCertificaciones(Long tipoCertificacion);

}
