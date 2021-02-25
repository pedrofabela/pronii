package gob.edugem.pronii.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import gob.edugem.pronii.model.Usuario;
import gob.edugem.pronii.service.UsuarioService;

@Controller
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired 
	PasswordEncoder passwordEncoder;
	
	@GetMapping("/")
	public String home(Model model, Authentication auth, HttpSession session) {
		String username= auth.getName();
		System.out.println("Nombre del usuario: "+username);
		for (GrantedAuthority rol : auth.getAuthorities()) {
			System.out.println("Rol: "+ rol.getAuthority());
		}
		
		if (session.getAttribute("usuario") == null ) {
			Usuario usuario=usuarioService.obterUsuarioUsername(username);
			usuario.setPassword(null);
			System.out.println("usuarioRecuperado: "+usuario);
			session.setAttribute("nIdUsuario",usuario.getnId());
			session.setAttribute("usuario", usuario);
		}
		
		
		model.addAttribute("active","nav-item active");		  
		return "index";
	}
	
	@GetMapping("/login")
	public String mostrarLogin() {
		return "login";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
		return "redirect:/login";
	}
	
	@GetMapping("/bcrypt/{texto}")
	@ResponseBody //regresa el texto al navegador de internet
	public String encriptar(@PathVariable("texto") String texto) {
		
		return texto +"Texto encriptado en bCrypt: "+passwordEncoder.encode(texto);
				
		
	}
	
//	@GetMapping("/bcrypt")
//	@ResponseBody //regresa el texto al navegador de internet
//	public String encriptarMasivo() {
//		
//		List<Usuario> listaUsuarios = usuarioService.obtenerUsuarios();
//		
//		List<Usuario> listaNueva= new ArrayList<Usuario>();
//		
//		for (Usuario usuarioR: listaUsuarios) {
//			
//			Usuario usuario=new Usuario();
//			
//			usuario.setnId(usuarioR.getnId());
//			usuario.setNombre(usuarioR.getNombre());
//			usuario.setEmail(usuarioR.getEmail() == null ? "" : usuarioR.getEmail());
//			usuario.setUsername(usuarioR.getUsername());
//			System.out.println("pass: "+usuarioR.getPassword().substring(6));
//			usuario.setPassword(passwordEncoder.encode(usuarioR.getPassword().substring(6)));
//			usuario.setEstatus(1);
//			usuario.setFechaRegistro(new Date());
//			usuario.setPerfiles(usuarioR.getPerfiles());
//			
//			listaNueva.add(usuario);
//			
//		}
//		
//		usuarioService.actualizacionPassMasivo(listaNueva);
//		
//		return "actualizacion completa";
//				
//		
//	}
//	
	
}
