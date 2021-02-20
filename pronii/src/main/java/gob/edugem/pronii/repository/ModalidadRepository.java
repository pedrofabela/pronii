package gob.edugem.pronii.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gob.edugem.pronii.model.TcModalidad;
@Repository
public interface ModalidadRepository extends JpaRepository<TcModalidad, Long> {
	
	public List<TcModalidad> findBynEstatus(Integer estatus);
}
