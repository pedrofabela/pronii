package gob.edugem.pronii.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.edugem.pronii.model.TcTipoCertificacion;
import gob.edugem.pronii.repository.TipoCertificacionesRepository;
import gob.edugem.pronii.service.TipoCertificacionService;
@Service
public class TipoCertificacionServiceImpl implements TipoCertificacionService {
	
	@Autowired
	private TipoCertificacionesRepository tipoCertificacionesRepository;

	@Override
	public List<TcTipoCertificacion> obtenerTipoCertificaciones(Long tipoCertificacion) {
		
		return tipoCertificacionesRepository.findBynIdTipoCertificacion(tipoCertificacion, 1);
	}

}
