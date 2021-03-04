package gob.edugem.pronii.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gob.edugem.pronii.model.TcTipoLicencia;
@Repository
public interface TipoLicenciaRepository extends JpaRepository<TcTipoLicencia, Long> {
	
	public List<TcTipoLicencia> findBynEstatus(Integer nEstatus);

}
