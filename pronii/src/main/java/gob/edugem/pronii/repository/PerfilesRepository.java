package gob.edugem.pronii.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gob.edugem.pronii.model.Perfil;
@Repository
public interface PerfilesRepository extends JpaRepository<Perfil, Long> {

}
