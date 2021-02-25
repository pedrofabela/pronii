package gob.edugem.pronii.service;

import java.util.List;

import gob.edugem.pronii.model.Usuario;

public interface UsuarioService {
	public Usuario obterUsuarioUsername(String username);
	
	public void guardaUsuario(Usuario user);
	
	public Usuario obtenerUsuarioId(Long id);
	
	public void eliminaUsuarioPorUsername(String username);
	
	public List<Usuario> obtenerUsuarios();
	
	public void actualizacionPassMasivo(List<Usuario> listaNueva);
}
