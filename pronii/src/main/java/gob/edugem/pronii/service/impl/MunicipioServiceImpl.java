package gob.edugem.pronii.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.edugem.pronii.model.TcMunicipio;
import gob.edugem.pronii.repository.MunicipioRepository;
import gob.edugem.pronii.service.MunicipioService;
@Service
public class MunicipioServiceImpl implements MunicipioService {
	
	@Autowired
	private MunicipioRepository municipioRepository;

	@Override
	public List<TcMunicipio> obtenerMunicipioEstatus() {
		
		return municipioRepository.findAll();
	}

}
