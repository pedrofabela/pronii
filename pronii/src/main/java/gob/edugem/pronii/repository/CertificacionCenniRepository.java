package gob.edugem.pronii.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gob.edugem.pronii.model.TwCenni;

@Repository
public interface CertificacionCenniRepository extends JpaRepository<TwCenni, Long> {
	
	public TwCenni findBynIdDocente(Long nIdDocente);
	

}
