package gob.edugem.pronii.service;

import gob.edugem.pronii.model.TwCenni;
import gob.edugem.pronii.model.TwMetodologia;
import gob.edugem.pronii.model.TwNivelIdioma;

public interface CertificacionesService {
	
	public void guardaCertificacionNivel(TwNivelIdioma twNivelIdioma);
	
	public void guardaCertificacionCenni(TwCenni twCenni);
	
	public void guardaCertificacionMetodologia(TwMetodologia twMetodologia);
	
	public TwNivelIdioma consultaCertificacionNivel(Long idDocente);
	
	public TwCenni consultaCertificacionCenni(Long idDocente);
	
	public TwMetodologia consultaCertificacionMetodologia(Long idDocente);
	
public TwNivelIdioma consultaCertificacionNivelId(Long id);
	
	public TwCenni consultaCertificacionCenniId(Long id);
	
	public TwMetodologia consultaCertificacionMetodologiaId(Long id);

}
