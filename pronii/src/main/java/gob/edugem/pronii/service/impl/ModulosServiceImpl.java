package gob.edugem.pronii.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.edugem.pronii.model.TcModulos;
import gob.edugem.pronii.repository.ModulosRepository;
import gob.edugem.pronii.service.ModulosService;
@Service
public class ModulosServiceImpl implements ModulosService {
	
	@Autowired
	private ModulosRepository modulosRepository;

	@Override
	public List<TcModulos> obtenerModulos() {
		
		return modulosRepository.findBynEstatus(1);
	}

}
