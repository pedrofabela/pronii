package gob.edugem.pronii.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gob.edugem.pronii.model.TcEscuela;

@Repository
public interface EscuelaRepository extends JpaRepository<TcEscuela, Long> {
	
	@Query("select e from TcEscuela e where e.nIdRegional=:nIdRegional Order By e.tcZonaEscolar.sNombre Asc")
	public List<TcEscuela> consultaPorRegion(Long nIdRegional);
	
	public List<TcEscuela> findBysCct(String cct);
	
	List<TcEscuela> findBynIdDirector(Long nIdDirector);
	
	
	
}
