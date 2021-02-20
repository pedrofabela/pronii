package gob.edugem.pronii.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gob.edugem.pronii.model.TcZonaEscolar;

@Repository
public interface ZonaEscolarRepository extends JpaRepository<TcZonaEscolar, Long> {
	
	@Query("select z from TcZonaEscolar z where z.nEstatus=:estatus order by z.sNombre")
	public List<TcZonaEscolar> consultaPorEstatus(Integer estatus);

}
