package gob.edugem.pronii.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gob.edugem.pronii.model.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByusername(String username);
	
	public void deleteByusername(String username);
	

}
