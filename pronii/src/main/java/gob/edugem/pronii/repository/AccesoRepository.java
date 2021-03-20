package gob.edugem.pronii.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gob.edugem.pronii.model.TwAcceso;

@Repository
public interface AccesoRepository extends JpaRepository<TwAcceso, Long> {

}
