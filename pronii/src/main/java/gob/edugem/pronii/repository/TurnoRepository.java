package gob.edugem.pronii.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gob.edugem.pronii.model.TcTurno;
@Repository
public interface TurnoRepository extends JpaRepository<TcTurno, Long> {
	
	public List<TcTurno> findBynEstatus(Integer estatus);

}
