package gob.edugem.pronii.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import gob.edugem.pronii.model.Perfil;
import gob.edugem.pronii.model.TcDirectores;
import gob.edugem.pronii.model.TcEscuela;
import gob.edugem.pronii.model.TcRegional;
import gob.edugem.pronii.model.TwEscuelaDocentes;
import gob.edugem.pronii.model.Usuario;
import gob.edugem.pronii.service.DirectoresService;
import gob.edugem.pronii.service.DocenteEscuelaService;
import gob.edugem.pronii.service.EscuelaService;
import gob.edugem.pronii.service.ModalidadService;
import gob.edugem.pronii.service.MunicipioService;
import gob.edugem.pronii.service.RegionalService;
import gob.edugem.pronii.service.TurnoService;
import gob.edugem.pronii.service.UsuarioService;
import gob.edugem.pronii.service.ZonaEscolarService;
import gob.edugem.pronii.utils.Constantes;

@Controller
@RequestMapping("/administrador/")
public class AdministradorController {

	@Autowired
	private RegionalService regionalService;
	@Autowired
	private EscuelaService escuelaService;
	@Autowired
	private TurnoService turnoService;
	@Autowired
	private ZonaEscolarService zonaEscolarService;
	@Autowired
	private MunicipioService municipioService;
	@Autowired 
	private ModalidadService modalidadService;
	@Autowired 
	private DirectoresService directoresService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired 
	private DocenteEscuelaService docenteEscuelaService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	
	public String sNombreDirector;
	public String nId;
	public Long nIdRegion;
	public Long nIdEscuela;
	

	@GetMapping("tablero")
	public String muestraTablero(Model model) {
		return "administrador/tablero";
	}

	// Muestra pabtalla inicio de consulta escuelas
	@GetMapping("pantallaInicioAdminEscuelas")
	public String muestraEscuelas(Model model, TcRegional tcRegional) {
		return "administrador/listaEscuelas";
	}

	@GetMapping("consultaEscuelaRegion")
	public String muestraEscuelasRegion(TcRegional tcRegional, Model model) {
		//System.out.printf("el valor es :" + tcRegional.getnId());
		List<TcEscuela> ListaEscuela = escuelaService.ListaEscuelaRegion(tcRegional.getnId());
		nIdRegion=tcRegional.getnId();
		model.addAttribute("ListaEscuela", ListaEscuela);
		return "administrador/listaEscuelas";
	}
	
	@GetMapping("formEscuela")
	public String formEscuela(Model model, TcEscuela tcEscuela) {	
		tcEscuela.setnIdRegional(nIdRegion);
		return "administrador/formEscuela";
	}
	
	
	@PostMapping("guardaEscuela")
	public String guardarEscuela(TcEscuela tcEscuela, TcRegional tcRegional, Model model, RedirectAttributes attributes) {
		
		//sNombreDirector= tcEscuela.getTcDirectores().getsNombre();
		nId=null;
		String valorRecibido;
		
		if (tcEscuela.getnId() != null) {
			TcEscuela tcEscuelaConsultada= escuelaService.obtenerEscuelaId(tcEscuela.getnId());
			
			tcEscuelaConsultada.setsCct(tcEscuela.getsCct());
			tcEscuelaConsultada.setsNombre(tcEscuela.getsNombre());
			tcEscuelaConsultada.setnIdTurno(tcEscuela.getnIdTurno());
			tcEscuelaConsultada.setnIdZonaEscolar(tcEscuela.getnIdZonaEscolar());
			tcEscuelaConsultada.setsDomicilio(tcEscuela.getsDomicilio());
			tcEscuelaConsultada.setsColonia(tcEscuela.getsColonia());
			tcEscuelaConsultada.setsLocalidad(tcEscuela.getsLocalidad());
			tcEscuelaConsultada.setnIdMunicipio(tcEscuela.getnIdMunicipio());
			tcEscuelaConsultada.setsTelefono(tcEscuela.getsTelefono());
			tcEscuelaConsultada.setsCorreo(tcEscuela.getsCorreo());
			tcEscuelaConsultada.setnIdModalidad(tcEscuela.getnIdModalidad());
			tcEscuelaConsultada.setnIdRegional(tcEscuela.getnIdRegional());
			
			valorRecibido=escuelaService.guardaEscuela(tcEscuela);
		}else {
			valorRecibido=escuelaService.guardaEscuela(tcEscuela);
		}
			
		if (valorRecibido.equals(Constantes.guardar) || valorRecibido.equals(Constantes.actualizar)) {		
			tcRegional.setnId(nIdRegion);
			System.out.println("tcRegional id: "+tcRegional.getnId());
			String msg;
			msg = valorRecibido == Constantes.guardar ? "Escuela registrada correctamente!" : "Escuela actualizada correctamente!";
			attributes.addFlashAttribute("tcRegional", tcRegional);
			attributes.addFlashAttribute("msg", msg);
			return "redirect:/administrador/consultaEscuelaRegion";
		}else {
			if (tcEscuela.getnIdDirector() != null ) {
				sNombreDirector= directoresService.consultaDirectorPorId(tcEscuela.getnIdDirector()).getsNombre();
			}else {
				sNombreDirector= "sin director asignado";
			}
			
			model.addAttribute("sNombreDirector", sNombreDirector);
			model.addAttribute("msg", "la CCT que intenta registrar ya existe en la base de datos");
			return "administrador/formEscuela";
		}
		
		
		
	}
	
	@GetMapping("editarEscuela")
	public String editarEscuela(@RequestParam(required = false) Long id, Model model) {		
		TcEscuela tcEscuela= escuelaService.obtenerEscuelaId(id);
		TcDirectores tcDirectores=null;
		if (tcEscuela.getnIdDirector() != null) {
			tcDirectores = directoresService.consultaDirectorPorId(tcEscuela.getnIdDirector());
			sNombreDirector= tcDirectores.getsNombre()+' '+tcDirectores.getsApellidoPaterno()+' '+tcDirectores.getsApellidoMaterno();
		}else {
			sNombreDirector= "No hay Director Asignado a esta escuela.";
		}
		
		List<TwEscuelaDocentes> listaDoncentesEscuela = docenteEscuelaService.obtenerDocentesEscuela(tcEscuela.getnId());
		System.out.println(listaDoncentesEscuela.size());
		
		model.addAttribute("listaDocentesEscuela", listaDoncentesEscuela);	
		model.addAttribute("sNombreDirector", sNombreDirector);
		model.addAttribute("nId", "actualizacion");
		model.addAttribute("tcEscuela", tcEscuela);
		return "administrador/formEscuela";
	}
	
	@GetMapping("eliminarEscuela")
	public String eliminarEscuela(@RequestParam(required = false) Long id, TcRegional tcRegional, RedirectAttributes attributes) {				
		
		TcEscuela tcEscuela = escuelaService.obtenerEscuelaId(id);
		
		
		
		//elimina relacion docente escuela
		docenteEscuelaService.eliminarDocenteEscuelaIdEscuela(id);
		
		//elimina usuario de acceso
		usuarioService.eliminaUsuarioPorUsername(tcEscuela.getsCct());
		
		//elimina la escuela
		 escuelaService.eliminarEscuelaId(id);

		
		tcRegional.setnId(nIdRegion);
		System.out.println("tcRegional id: "+tcRegional.getnId());
		attributes.addFlashAttribute("tcRegional", tcRegional);
		attributes.addFlashAttribute("msg", "Escuela eliminada correctamente!");
		return "redirect:/administrador/consultaEscuelaRegion";
	}
	
	
	@GetMapping("agregarDirector")
	public String agregarDirector(@RequestParam(required = false) Long id, TcDirectores tcDirectores,  Model model) {		
		nIdEscuela=id;
		
		TcEscuela tcEscuela= escuelaService.obtenerEscuelaId(id);
		
		if (tcEscuela.getnIdDirector() != null) {
			TcDirectores tcDirectorConsultado = directoresService.consultaDirectorPorId(tcEscuela.getnIdDirector());		
			model.addAttribute("tcDirectores", tcDirectorConsultado);
		}else {
			model.addAttribute("tcDirectores", null);
		}
			
		return "administrador/formDirector";
	}
	
	@GetMapping("consultaCurp")
	public String consultaCurp(@RequestParam(required = false) String curp, TcDirectores tcDirectores, Model model) {
		tcDirectores = directoresService.consultaDirectorCurp(curp);
		nId = "actualizar";
		System.out.println("primer consulta " + tcDirectores);

		if (tcDirectores == null) {
			tcDirectores = directoresService.consultaCurpDirectorRenapo(curp);
			nId = null;
			System.out.println("consulta renapo: " + tcDirectores.toString());

		} 

		model.addAttribute("nId", nId);
		model.addAttribute("tcDirectores", tcDirectores);

		return "administrador/formDirector";
	}
	
	@PostMapping("asignaDirector")
	public String asignaDirector(TcDirectores tcDirectores, Model model,TcRegional tcRegional, RedirectAttributes attributes) {
		
		TcEscuela tcEscuela = escuelaService.obtenerEscuelaId(nIdEscuela);
		

		if (tcDirectores.getnId() == null) { // si el director es nuevo se asigna a la escuela  
			
			tcDirectores.setnEstatus(1);
			TcDirectores directorGuardado = directoresService.guardarDirector(tcDirectores);
			tcEscuela.setnIdDirector(directorGuardado.getnId());		
			escuelaService.guardaEscuela(tcEscuela);
			attributes.addFlashAttribute("msg", "Director asignado correctamente");

		} else { // si no se valida que el director no este en dos escuelas con el mismo turno
					
			List<TcEscuela> listaEscuela= escuelaService.obtenerEscuelaDirector(tcDirectores.getnId());
			
			if (listaEscuela.size() > 0) {
				TcEscuela escuelaSeleccionada = escuelaService.obtenerEscuelaId(nIdEscuela);
				boolean turnoEncontrado= false;
				for (int i = 0; i < listaEscuela.size(); i++) {
					if (listaEscuela.get(i).getnIdTurno() == escuelaSeleccionada.getnIdTurno()) {
						turnoEncontrado=true;
					}
				}
				
				if (turnoEncontrado) {
					model.addAttribute("tcDirectores", tcDirectores);
					model.addAttribute("msg", "El director que intenta asignar a la escuela, ya se encuentra asignado a otra escuela con el mismo turno");
					return "administrador/formDirector";
				}else {
					
					tcEscuela.setnIdDirector(tcDirectores.getnId());
					escuelaService.guardaEscuela(tcEscuela);
					attributes.addFlashAttribute("msg", "Director asignado correctamente");
				}
				
			}else {
				
				tcEscuela.setnIdDirector(tcDirectores.getnId());
				escuelaService.guardaEscuela(tcEscuela);
				attributes.addFlashAttribute("msg", "Director asignado correctamente");
			}
			
			
		}
		
		
		tcRegional.setnId(tcEscuela.getnIdRegional());
		attributes.addFlashAttribute("tcRegional", tcRegional);
		return "redirect:/administrador/consultaEscuelaRegion";

	}
	
	@GetMapping("reestablecerPassword")
	public String reestablecerPassword(@RequestParam(required = false) Long id, TcRegional tcRegional, RedirectAttributes attributes) {
		
        TcEscuela tcEscuela = escuelaService.obtenerEscuelaId(id);
		
		Usuario usuarioConsultado= usuarioService.obterUsuarioUsername(tcEscuela.getsCct());
		
		if (usuarioConsultado== null ) {
			
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

			usuarioService.guardaUsuario(user);
			
		}else {
			usuarioConsultado.setPassword(passwordEncoder.encode(tcEscuela.getsCct()));		
			usuarioService.guardaUsuario(usuarioConsultado);
		}
		
		
		tcRegional.setnId(nIdRegion);
		attributes.addFlashAttribute("msg", "Contraseña reestablecida correctamente");
		attributes.addFlashAttribute("tcRegional", tcRegional);
		return "redirect:/administrador/consultaEscuelaRegion";
	}
	
	@GetMapping("reestablecerPasswordDocente")
	public String reestablecerPassword(@RequestParam(required = false) Long id, RedirectAttributes attributes, Model model) {
		
		TwEscuelaDocentes twEscuelaDocentes = docenteEscuelaService.consultaDocenteEscuela(id);
		
		Usuario usuarioConsultado= usuarioService.obterUsuarioUsername(twEscuelaDocentes.getTcDocentes().getsCurp());
		
		if (usuarioConsultado == null) {
			Usuario user = new Usuario();
			user.setNombre(twEscuelaDocentes.getTcDocentes().getsNombre()+' '+twEscuelaDocentes.getTcDocentes().getsPrimerApellido()+' '+ twEscuelaDocentes.getTcDocentes().getsSegundoApellido());
			user.setEmail(twEscuelaDocentes.getTcDocentes().getsCorreo());
			user.setUsername(twEscuelaDocentes.getTcDocentes().getsCurp());
			user.setPassword(passwordEncoder.encode(twEscuelaDocentes.getTcDocentes().getsClaveSerPub()));
			user.setEstatus(1);	
			
			Perfil perfil = new Perfil();			
			perfil.setnId(3L);			
			user.agregar(perfil);	
			
			usuarioService.guardaUsuario(user);
		}else {
			usuarioConsultado.setPassword(passwordEncoder.encode(twEscuelaDocentes.getTcDocentes().getsClaveSerPub()));
			
			usuarioService.guardaUsuario(usuarioConsultado);
			
		}
		
		
		model.addAttribute("id", twEscuelaDocentes.getnIdEscuela());
		attributes.addFlashAttribute("msgDocente", "Contraseña reestablecida correctamente");
		return "redirect:/administrador/editarEscuela?id="+twEscuelaDocentes.getnIdEscuela();
	}
	
	
	
	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("ListaRegionales", regionalService.obtenerRegiones());
		model.addAttribute("ListaTurno", turnoService.obtenerTurnoEstatus());
		model.addAttribute("ListaZona", zonaEscolarService.obtenerZonaEscolarEstatus());
		model.addAttribute("ListaMunicipio", municipioService.obtenerMunicipioEstatus());
		model.addAttribute("ListaModalidad", modalidadService.obtenerModalidadEstatus());
		model.addAttribute("nIdRegion",nIdRegion);
		model.addAttribute("nIdEscuela",nIdEscuela);
		
		
		
	}
	
	
	
	

}
