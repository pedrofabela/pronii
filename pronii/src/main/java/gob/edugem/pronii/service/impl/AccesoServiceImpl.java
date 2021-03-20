package gob.edugem.pronii.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.edugem.pronii.model.TwAcceso;
import gob.edugem.pronii.repository.AccesoRepository;
import gob.edugem.pronii.service.AccesoService;
@Service
public class AccesoServiceImpl implements AccesoService {
	
	@Autowired
	private AccesoRepository accesoRepository;

	@Override
	public void guardaAcceso(TwAcceso twAcceso) {
		accesoRepository.save(twAcceso);
	}

}
