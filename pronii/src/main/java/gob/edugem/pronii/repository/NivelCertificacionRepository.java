package gob.edugem.pronii.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gob.edugem.pronii.model.TcNivelCertificacion;

@Repository
public interface NivelCertificacionRepository extends JpaRepository<TcNivelCertificacion, Long> {
	
	@Query("select t from TcNivelCertificacion t where t.nIdTipoCertificacion=:nIdTipoCertificacion and t.nEstatus=:nEstatus")
	public List<TcNivelCertificacion> findBynIdTipoCertificacionAndnEstatus(Long nIdTipoCertificacion, Integer nEstatus);
	

}
