package gob.edugem.pronii.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gob.edugem.pronii.model.TwEscuelaDocentes;
@Repository
public interface DocenteEscuelaRepository extends JpaRepository<TwEscuelaDocentes, Long> {
	
	public List<TwEscuelaDocentes> findBynIdEscuela(Long nIdEscuela);
	
	@Query("select t from TwEscuelaDocentes t where t.nIdEscuela=:IdEscuela and t.nIdDocente=:IdDocente")
	public List<TwEscuelaDocentes> findBynIdEscuelaAndnIdDocente(Long IdEscuela, Long IdDocente);
	
	
	public List<TwEscuelaDocentes> findBynIdDocente(Long IdDocente);
	
	public void deleteBynIdEscuela(Long idEscuela);
	

}
