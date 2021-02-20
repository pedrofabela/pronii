package gob.edugem.pronii.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gob.edugem.pronii.model.TwNivelIdioma;

@Repository
public interface CertificacionNivelRepository extends JpaRepository<TwNivelIdioma, Long> {
	
	
	public TwNivelIdioma findBynIdDocente(Long nIdDocente);
	

}
