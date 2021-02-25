package gob.edugem.pronii.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.edugem.pronii.model.Usuario;
import gob.edugem.pronii.repository.UsuarioRepository;
import gob.edugem.pronii.service.UsuarioService;
@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario obterUsuarioUsername(String username) {
		
		return usuarioRepository.findByusername(username);
	}

	@Override
	@Transactional
	public void guardaUsuario(Usuario user) {
		usuarioRepository.save(user);
		
	}

	@Override
	public Usuario obtenerUsuarioId(Long id) {
		
		return usuarioRepository.findById(id).get();
	}

	@Override
	@Transactional
	public void eliminaUsuarioPorUsername(String username) {
		usuarioRepository.deleteByusername(username);
		
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		
		return usuarioRepository.findAll();
	}

	@Override
	@Transactional
	public void actualizacionPassMasivo(List<Usuario> listaNueva) {
		System.out.println("tamano lista: "+listaNueva.size());
		
		usuarioRepository.saveAll(listaNueva);
		
	}
	
	

}
