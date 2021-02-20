package gob.edugem.pronii.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.edugem.pronii.model.TcModalidad;
import gob.edugem.pronii.repository.ModalidadRepository;
import gob.edugem.pronii.service.ModalidadService;

@Service
public class ModalidadServiceImpl implements ModalidadService {
	@Autowired
	private ModalidadRepository modalidadRepository;

	@Override
	public List<TcModalidad> obtenerModalidadEstatus() {
		
		return modalidadRepository.findBynEstatus(1);
	}

}
