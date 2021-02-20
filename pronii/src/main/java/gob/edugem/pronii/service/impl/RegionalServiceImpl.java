package gob.edugem.pronii.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.edugem.pronii.model.TcRegional;
import gob.edugem.pronii.repository.RegionalRepository;
import gob.edugem.pronii.service.RegionalService;

@Service
public class RegionalServiceImpl implements RegionalService {
	@Autowired
	private RegionalRepository regionalRepository;

	@Override
	public List<TcRegional> obtenerRegiones() {

		return regionalRepository.consultaRegiones(1);
	}

}
