package gob.edugem.pronii.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.edugem.pronii.model.TcDirectores;
import gob.edugem.pronii.repository.DirectoresRepository;
import gob.edugem.pronii.service.DirectoresService;

@Service
public class DirectoresServiceImpl implements DirectoresService {
	
	@Autowired
    private DirectoresRepository directoresRepositorio;


	@Override
	public List<TcDirectores> consultaDirectorPorNombre(String term) {
		
		return directoresRepositorio.findBysNombre(term);
	}


	@Override
	public TcDirectores consultaDirectorPorId(Long id) {
		
		return directoresRepositorio.findById(id).get();
	}
	
	
	
	
	

	
}
