package gob.edugem.pronii.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import gob.edugem.pronii.model.TcTipoCertificacion;

public interface TipoCertificacionesRepository extends JpaRepository<TcTipoCertificacion, Long> {
	
	@Query("select t from TcTipoCertificacion t where t.nIdTipoCertificacion=:nIdTipoCertificacion and t.nEstatus=:nEstatus")
	public List<TcTipoCertificacion> findBynIdTipoCertificacion(Long nIdTipoCertificacion, Integer nEstatus);
	

}
