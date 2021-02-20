package gob.edugem.pronii.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import gob.edugem.pronii.model.TcDocentes;

@Repository
public interface DocenteRepository extends JpaRepository<TcDocentes, Long> {
	
	public TcDocentes findBysCurp(String sCurp);
	

}
