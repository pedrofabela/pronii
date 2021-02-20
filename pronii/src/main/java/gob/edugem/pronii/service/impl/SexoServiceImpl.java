package gob.edugem.pronii.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.edugem.pronii.model.TcGenero;
import gob.edugem.pronii.repository.SexoRepository;
import gob.edugem.pronii.service.SexoService;

@Service
public class SexoServiceImpl implements SexoService {
	
	@Autowired
	private SexoRepository sexoRepository;

	@Override
	public List<TcGenero> obtenerGenero() {
		
		return sexoRepository.findBynEstatus(1);
	}

}
