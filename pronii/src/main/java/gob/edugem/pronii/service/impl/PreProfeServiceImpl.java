package gob.edugem.pronii.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.edugem.pronii.model.TcPreProfe;
import gob.edugem.pronii.repository.PreProfeRepository;
import gob.edugem.pronii.service.PreProfService;
@Service
public class PreProfeServiceImpl implements PreProfService {
	
	@Autowired
	private PreProfeRepository preProfeRepository;

	@Override
	public List<TcPreProfe> obtenerPreProfe() {
		
		return preProfeRepository.findBynEstatus(1);
	}

}
