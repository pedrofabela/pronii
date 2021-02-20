package gob.edugem.pronii.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gob.edugem.pronii.model.TcMunicipio;

@Repository
public interface MunicipioRepository extends JpaRepository<TcMunicipio, Long> {
	
	
	
}
