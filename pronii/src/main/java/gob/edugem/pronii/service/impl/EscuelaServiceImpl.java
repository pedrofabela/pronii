package gob.edugem.pronii.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import gob.edugem.pronii.model.Perfil;
import gob.edugem.pronii.model.TcEscuela;
import gob.edugem.pronii.model.Usuario;
import gob.edugem.pronii.repository.EscuelaRepository;
import gob.edugem.pronii.repository.UsuarioRepository;
import gob.edugem.pronii.service.EscuelaService;
import gob.edugem.pronii.utils.Constantes;

@Service
public class EscuelaServiceImpl implements EscuelaService {
	
	@Autowired
	private EscuelaRepository escuelaRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	
	
	@Override
	public TcEscuela obtenerEscuelaId(Long id) {
		
		return escuelaRepository.findById(id).get();
	}
	
	@Override	
	public TcEscuela obtenerEscuelaCct(String cct) {
	
		return escuelaRepository.findBysCct(cct).get(0);
	}

	@Override
	public List<TcEscuela> ListaEscuelaRegion(Long nIdRegional) {
		
		
		
		return escuelaRepository.consultaPorRegion(nIdRegional);
	}

	@Override
	@Transactional
	public String guardaEscuela(TcEscuela tcEscuela) {
		
		if (tcEscuela.getnId() != null ) { // si tiene id actualiza los datos. 
			TcEscuela tcEscuelaConsultada= escuelaRepository.findById(tcEscuela.getnId()).get();
			tcEscuelaConsultada.setnGrupoPrimero(tcEscuela.getnGrupoPrimero());
			tcEscuelaConsultada.setnGrupoSegundo(tcEscuela.getnGrupoSegundo());
			tcEscuelaConsultada.setnGrupoTercero(tcEscuela.getnGrupoTercero());
			tcEscuelaConsultada.setnAlumnosPrimeroH(tcEscuela.getnAlumnosPrimeroH());
			tcEscuelaConsultada.setnAlumnosPrimeroM(tcEscuela.getnAlumnosPrimeroM());
			tcEscuelaConsultada.setnAlumnosSegundoH(tcEscuela.getnAlumnosSegundoH());
			tcEscuelaConsultada.setnAlumnosSegundoM(tcEscuela.getnAlumnosSegundoM());
			tcEscuelaConsultada.setnAlumnosTerceroH(tcEscuela.getnAlumnosTerceroH());
			tcEscuelaConsultada.setnAlumnosTerceroM(tcEscuela.getnAlumnosTerceroM());
			escuelaRepository.save(tcEscuelaConsultada);
			return Constantes.actualizar;
		}else {// si no verifica que la cct que intenta registrar no exista.
			if (escuelaRepository.findBysCct(tcEscuela.getsCct()).size() > 0) {
				return Constantes.errorYaExiste;
			}else {
				tcEscuela.setnEstatus(1);
				escuelaRepository.save(tcEscuela);

				
				//crea credenciales de acceso para escuela nueva
				
				Usuario user = new Usuario();
				user.setNombre(tcEscuela.getsNombre());
				user.setEmail("");
				user.setUsername(tcEscuela.getsCct());
				user.setPassword(passwordEncoder.encode(tcEscuela.getsCct()));
				user.setEstatus(1);	
				user.setFechaRegistro(new Date());
				
				Perfil perfil = new Perfil();			
				perfil.setnId(2L);			
				user.agregar(perfil);	
				
				usuarioRepository.save(user);		
				
				return Constantes.guardar;
			}	
		}
			
	}

	@Override
	@Transactional
	public void eliminarEscuelaId(Long id) {
		escuelaRepository.deleteById(id);		
	}

	@Override
	public List<TcEscuela> obtenerEscuelaDirector(Long nIdDirector) {
		
		return escuelaRepository.findBynIdDirector(nIdDirector);
	}

	

}
