package gob.edugem.pronii.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gob.edugem.pronii.model.TwMetodologia;
@Repository
public interface CertificacionMetodologiaRepository extends JpaRepository<TwMetodologia, Long> {
	
	public TwMetodologia findBynIdDocente(Long nIdDocente);
	

}
