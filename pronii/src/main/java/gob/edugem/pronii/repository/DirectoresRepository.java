package gob.edugem.pronii.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gob.edugem.pronii.model.TcDirectores;

@Repository
public interface DirectoresRepository extends JpaRepository<TcDirectores, Long> {
	
	@Query(value = "SELECT * FROM TC_DIRECTORES WHERE S_NOMBRE LIKE %:term% and N_ESTATUS = 1",  nativeQuery = true)
	public List<TcDirectores> findBysNombre(String term);

}
