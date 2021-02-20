package gob.edugem.pronii.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gob.edugem.pronii.model.TcGenero;

@Repository
public interface SexoRepository extends JpaRepository<TcGenero, Long> {
	
	List<TcGenero> findBynEstatus(Integer estatus);

}
