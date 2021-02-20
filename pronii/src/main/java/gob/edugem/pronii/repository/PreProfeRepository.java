package gob.edugem.pronii.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gob.edugem.pronii.model.TcPreProfe;

@Repository
public interface PreProfeRepository extends JpaRepository<TcPreProfe, Long> {
	
	public List<TcPreProfe>  findBynEstatus(Integer nEstatus);
	

}
