package gob.edugem.pronii.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gob.edugem.pronii.model.TcRegional;

@Repository
public interface RegionalRepository extends JpaRepository<TcRegional, Long> {

	@Query("select t from TcRegional t where t.nEstatus=:estatus order by t.nId Asc")
	public List<TcRegional> consultaRegiones(Integer estatus);
	
}
