package gob.edugem.pronii.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gob.edugem.pronii.model.TcModulos;
@Repository
public interface ModulosRepository extends JpaRepository<TcModulos, Long> {
	
	List<TcModulos> findBynEstatus(Integer nEstatus);
	

}
