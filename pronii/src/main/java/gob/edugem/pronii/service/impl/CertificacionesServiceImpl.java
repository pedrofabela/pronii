package gob.edugem.pronii.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.edugem.pronii.model.TwCenni;
import gob.edugem.pronii.model.TwMetodologia;
import gob.edugem.pronii.model.TwNivelIdioma;
import gob.edugem.pronii.repository.CertificacionCenniRepository;
import gob.edugem.pronii.repository.CertificacionMetodologiaRepository;
import gob.edugem.pronii.repository.CertificacionNivelRepository;
import gob.edugem.pronii.service.CertificacionesService;
@Service
public class CertificacionesServiceImpl implements CertificacionesService {
	
	@Autowired
	private CertificacionNivelRepository certificacionNivelRepository;
	
	@Autowired
	private CertificacionCenniRepository certificacionCenniRepository;
	
	@Autowired
	private CertificacionMetodologiaRepository certificacionMetodologiaRepository;
	

	@Override
	public void guardaCertificacionNivel(TwNivelIdioma twNivelIdioma) {
		certificacionNivelRepository.save(twNivelIdioma);

	}

	@Override
	public void guardaCertificacionCenni(TwCenni twCenni) {
		certificacionCenniRepository.save(twCenni);

	}

	@Override
	public void guardaCertificacionMetodologia(TwMetodologia twMetodologia) {
		certificacionMetodologiaRepository.save(twMetodologia);

	}

	@Override
	public TwNivelIdioma consultaCertificacionNivel(Long idDocente) {
		
		return certificacionNivelRepository.findBynIdDocente(idDocente);
	}

	@Override
	public TwCenni consultaCertificacionCenni(Long idDocente) {
		
		return certificacionCenniRepository.findBynIdDocente(idDocente);
	}

	@Override
	public TwMetodologia consultaCertificacionMetodologia(Long idDocente) {
		
		return certificacionMetodologiaRepository.findBynIdDocente(idDocente);
	}

}
