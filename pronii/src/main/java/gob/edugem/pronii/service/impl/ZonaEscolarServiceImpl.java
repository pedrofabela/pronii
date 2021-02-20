package gob.edugem.pronii.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.edugem.pronii.model.TcZonaEscolar;
import gob.edugem.pronii.repository.ZonaEscolarRepository;
import gob.edugem.pronii.service.ZonaEscolarService;
@Service
public class ZonaEscolarServiceImpl implements ZonaEscolarService {
	
	@Autowired
	private ZonaEscolarRepository zonaEscolarRepository;

	@Override
	public List<TcZonaEscolar> obtenerZonaEscolarEstatus() {
		
		return zonaEscolarRepository.consultaPorEstatus(1);
	}

}
