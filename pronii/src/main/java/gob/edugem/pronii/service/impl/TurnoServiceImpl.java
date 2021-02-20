package gob.edugem.pronii.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.edugem.pronii.model.TcTurno;
import gob.edugem.pronii.repository.TurnoRepository;
import gob.edugem.pronii.service.TurnoService;
@Service
public class TurnoServiceImpl implements TurnoService {
	
	@Autowired
	private TurnoRepository turnoRepository;

	@Override
	public List<TcTurno> obtenerTurnoEstatus() {
		
		return turnoRepository.findBynEstatus(1);
	}

}
