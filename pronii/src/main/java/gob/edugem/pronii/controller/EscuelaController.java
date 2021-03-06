package gob.edugem.pronii.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import gob.edugem.pronii.model.Perfil;
import gob.edugem.pronii.model.TcDocentes;
import gob.edugem.pronii.model.TcEscuela;
import gob.edugem.pronii.model.TwEscuelaDocentes;
import gob.edugem.pronii.model.Usuario;
import gob.edugem.pronii.service.DirectoresService;
import gob.edugem.pronii.service.DocenteEscuelaService;
import gob.edugem.pronii.service.EscuelaService;
import gob.edugem.pronii.service.ModalidadService;
import gob.edugem.pronii.service.MunicipioService;
import gob.edugem.pronii.service.PreProfService;
import gob.edugem.pronii.service.RegionalService;
import gob.edugem.pronii.service.SexoService;
import gob.edugem.pronii.service.TipoLicenciaService;
import gob.edugem.pronii.service.TurnoService;
import gob.edugem.pronii.service.UsuarioService;
import gob.edugem.pronii.service.ZonaEscolarService;

@Controller
@RequestMapping("/escuela/")
public class EscuelaController {

	@Autowired
	private EscuelaService escuelaService;

	@Autowired
	private DocenteEscuelaService docenteEscuelaService;

	@Autowired
	private SexoService sexoService;

	@Autowired
	private PreProfService preProfeService;
	
	@Autowired
	private RegionalService regionalService;
	
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
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private TipoLicenciaService tipoLicenciaService;
	

	public String nId;
	public Long nIdEscuela;
	

	@GetMapping("consultaDocentes")
	public String muestraDocentes(Authentication auth, Model model) {

		String username = auth.getName();
		System.out.println("Nombre del usuario: " + username);
		TcEscuela tcEscuela = escuelaService.obtenerEscuelaCct(username);
		nIdEscuela = tcEscuela.getnId();
		List<TwEscuelaDocentes> listaDoncentesEscuela = docenteEscuelaService.obtenerDocentesEscuela(tcEscuela.getnId());
		System.out.println(listaDoncentesEscuela.size());
		
		model.addAttribute("listaDocentesEscuela", listaDoncentesEscuela);
		model.addAttribute("Director", tcEscuela.getnIdDirector() != null ? tcEscuela.getTcDirectores().getsNombre() : "No hay Director Asignado a esta escuela");
		

		return "escuela/listaDocentes";
	}

	@GetMapping("formDocente")
	public String formDocente(Model model, TcDocentes tcDocentes) {
		model.addAttribute("tcDocentes", tcDocentes = null);
		return "escuela/formDocente";
	}

	@GetMapping("consultaCurp")
	public String consultaCurp(@RequestParam(required = false) String curp, TcDocentes tcDocentes, Model model) {
		System.err.println("nIdEscuela controller: "+nIdEscuela);
		tcDocentes = docenteEscuelaService.consultaDocenteCurp(curp);
		
		
		
		nId = "actualizar";
		System.out.println("primer consulta " + tcDocentes);

		if (tcDocentes == null) {
			tcDocentes = docenteEscuelaService.consultaCurpDocenteRenapo(curp);
			nId = null;
			System.out.println("consulta renapo: " + tcDocentes.toString());

		} else if (tcDocentes.getsFechaNacimiento() == null) {
			TcDocentes tcDocentesRenapo = new TcDocentes();
			tcDocentesRenapo = docenteEscuelaService.consultaCurpDocenteRenapo(curp);
			nId = "actualizar";
			tcDocentes.setsFechaNacimiento(tcDocentesRenapo.getsFechaNacimiento());
			System.out.println("consulta renapo: " + tcDocentes.toString());
		}
		
        List<TwEscuelaDocentes> listaRelacion = docenteEscuelaService.consultaRelacionDocenteEscuela(nIdEscuela, tcDocentes.getnId());
		
		if (listaRelacion.size() > 0) {
			for (TwEscuelaDocentes twEscuelaDocentes : listaRelacion) {
				tcDocentes.setnIdTieneLicencia(twEscuelaDocentes.getnTieneLicencia());
				tcDocentes.setnIdTipoLicencia(twEscuelaDocentes.getnIdTipoLicencia());
				tcDocentes.setsFechaInicioLicencia(twEscuelaDocentes.getdFechaInicioLicencia());
				tcDocentes.setsFechaFinLicencia(twEscuelaDocentes.getdFechaFinLicencia());
			}
		}else {
			tcDocentes.setnIdTieneLicencia(2L);
		}

		model.addAttribute("nId", nId);
		model.addAttribute("tcDocentes", tcDocentes);

		return "escuela/formDocente";
	}

	@PostMapping("guardaDocente")
	public String guardarEscuela(TcDocentes tcDocentes, Model model, RedirectAttributes attributes) {

		TwEscuelaDocentes twEscuelaDocentes = new TwEscuelaDocentes();
		System.err.println("nIdEscuela controller: "+nIdEscuela);
		twEscuelaDocentes.setnIdEscuela(nIdEscuela);
		twEscuelaDocentes.setnGrupoPrimero(0);
		twEscuelaDocentes.setnGrupoSegundo(0);
		twEscuelaDocentes.setnGrupoTercero(0);
		twEscuelaDocentes.setnHorasPrimero(0);
		twEscuelaDocentes.setnHorasSegundo(0);
		twEscuelaDocentes.setnHorasTercero(0);
		twEscuelaDocentes.setnAlumnosPrimeroH(0);
		twEscuelaDocentes.setnAlumnosPrimeroM(0);
		twEscuelaDocentes.setnAlumnosSegundoH(0);
		twEscuelaDocentes.setnAlumnosSegundoM(0);
		twEscuelaDocentes.setnAlumnosTerceroH(0);
		twEscuelaDocentes.setnAlumnosTerceroM(0);
		twEscuelaDocentes.setnEstatus(0);
		twEscuelaDocentes.setnTieneLicencia(tcDocentes.getnIdTieneLicencia());
		
		if (tcDocentes.getnIdTieneLicencia() == 2) {
			twEscuelaDocentes.setnIdTipoLicencia(0L);
		}else {
			twEscuelaDocentes.setnIdTipoLicencia(tcDocentes.getnIdTipoLicencia());
		}
		twEscuelaDocentes.setdFechaInicioLicencia(tcDocentes.getsFechaInicioLicencia());
		twEscuelaDocentes.setdFechaFinLicencia(tcDocentes.getsFechaFinLicencia());
		

		if (tcDocentes.getnId() == null) {
			
			tcDocentes.setnPerfil(0);
			TcDocentes docenteGuardado = docenteEscuelaService.guardaDocente(tcDocentes);
			
			twEscuelaDocentes.setnIdDocente(docenteGuardado.getnId());

			docenteEscuelaService.guardaDocenteEscuela(twEscuelaDocentes);
			
			//crea usuario para acceso
			
			Usuario user = new Usuario();
			user.setNombre(docenteGuardado.getsNombre()+' '+docenteGuardado.getsPrimerApellido()+' '+ docenteGuardado.getsSegundoApellido());
			user.setEmail(docenteGuardado.getsCorreo());
			user.setUsername(docenteGuardado.getsCurp());
			user.setPassword(passwordEncoder.encode(docenteGuardado.getsClaveSerPub()));
			user.setEstatus(1);	
			
			Perfil perfil = new Perfil();			
			perfil.setnId(3L);			
			user.agregar(perfil);	
			
			usuarioService.guardaUsuario(user);		
			attributes.addFlashAttribute("msg", "Docente registrado correctamente");

		} else {
			
		
			List<TwEscuelaDocentes> listaRelacion = docenteEscuelaService.consultaRelacionDocenteEscuela(twEscuelaDocentes.getnIdEscuela(), tcDocentes.getnId());

			System.err.println("listaRelacion: "+listaRelacion.size());
			
			if (listaRelacion.size() > 0) {
				docenteEscuelaService.guardaDocente(tcDocentes);
				attributes.addFlashAttribute("msg","El Docente que intenta agregar ya se encuentra registrado en la escuela");
			} else {
				docenteEscuelaService.guardaDocente(tcDocentes);
				twEscuelaDocentes.setnIdDocente(tcDocentes.getnId());
				docenteEscuelaService.guardaDocenteEscuela(twEscuelaDocentes);
				attributes.addFlashAttribute("msg", "Docente agregado a la escuela correctamente");
			}
		}
		attributes.addFlashAttribute("nIdEscuela", nIdEscuela);
		return "redirect:/escuela/consultaDocentes";

	}
	
	@GetMapping("quitarDocente")
	public String quitarDocente(@RequestParam(required = false) Long id, RedirectAttributes attributes) {
		
		docenteEscuelaService.eliminarDocenteEscuelaId(id);		
		
		attributes.addFlashAttribute("nIdEscuela", nIdEscuela);
		attributes.addFlashAttribute("msg", "Docente eliminado correctamente!");
		return "redirect:/escuela/consultaDocentes";
	}

	@GetMapping("consultaMatricula")
	public String muestraMatricula(TwEscuelaDocentes twEscuelaDocentes, @RequestParam (required = false) Long id, Model model) {
		
		twEscuelaDocentes=docenteEscuelaService.consultaDocenteEscuela(id);
		model.addAttribute("twEscuelaDocentes", twEscuelaDocentes);
		return "escuela/registroMatricula";
	}
	
	@PostMapping("guardaMatricula")
	public String registraMatricula(TwEscuelaDocentes twEscuelaDocentes, RedirectAttributes attributes ) {
		
		TwEscuelaDocentes twEscuelaDocentesConsultado= docenteEscuelaService.consultaDocenteEscuela(twEscuelaDocentes.getnId());
		
		twEscuelaDocentes.setnEstatus(1);
		twEscuelaDocentes.setnTieneLicencia(twEscuelaDocentesConsultado.getnTieneLicencia());
		twEscuelaDocentes.setnIdTipoLicencia(twEscuelaDocentesConsultado.getnIdTipoLicencia());
		twEscuelaDocentes.setdFechaInicioLicencia(twEscuelaDocentesConsultado.getdFechaInicioLicencia());
		twEscuelaDocentes.setdFechaFinLicencia(twEscuelaDocentesConsultado.getdFechaFinLicencia());
		docenteEscuelaService.guardaDocenteEscuela(twEscuelaDocentes);
		attributes.addFlashAttribute("nIdEscuela", nIdEscuela);
		attributes.addFlashAttribute("msg", "Matrícula del docente registrada correctamente!");
		return "redirect:/escuela/consultaDocentes";
		
	}
	
	@GetMapping("consultaMatriculaGeneral")
	public String consultaMatriculaGeneral(Authentication auth ,Model model, TcEscuela tcEscuela) {	
		tcEscuela = escuelaService.obtenerEscuelaCct(auth.getName());
//		if (tcEscuela.getnIdDirector() != null) {
//			String sNombreDirector= directoresService.consultaDirectorPorId(tcEscuela.getnIdDirector()).getsNombre();
//			model.addAttribute("sNombreDirector", sNombreDirector);
//		}else {
//			model.addAttribute("sNombreDirector", "No hay Director Asignado a esta escuela");
//		}
		
		//model.addAttribute("nId", "actualizacion");
		model.addAttribute("tcEscuela", tcEscuela);
		return "escuela/registroMatriculaGeneral";
	}
	
	@PostMapping("guardaMatriculaGeneral")
	public String registraMatriculaGeneral(TcEscuela tcEscuela, RedirectAttributes attributes ) {
		
		
		escuelaService.guardaEscuela(tcEscuela);
		attributes.addFlashAttribute("nIdEscuela", nIdEscuela);
		attributes.addFlashAttribute("msg", "Matrícula registrada correctamente!");
		return "redirect:/";
		
	}

	@GetMapping("formEscuela")
	public String formEscuela(Authentication auth ,Model model, TcEscuela tcEscuela) {	
		tcEscuela = escuelaService.obtenerEscuelaCct(auth.getName());
		if (tcEscuela.getnIdDirector() != null) {
			String sNombreDirector= directoresService.consultaDirectorPorId(tcEscuela.getnIdDirector()).getsNombre();
			model.addAttribute("sNombreDirector", sNombreDirector);
		}else {
			model.addAttribute("sNombreDirector", "No hay Director Asignado a esta escuela");
		}
		
		model.addAttribute("nId", "actualizacion");
		model.addAttribute("tcEscuela", tcEscuela);
		return "escuela/formEscuela";
	}
	
	@PostMapping("guardaEscuela")
	public String guardarEscuela(TcEscuela tcEscuela, RedirectAttributes attributes) {
		
		TcEscuela tcEscuelaSave= escuelaService.obtenerEscuelaId(tcEscuela.getnId());
		tcEscuelaSave.setnHorasDeterminadas(tcEscuela.getnHorasDeterminadas());
		tcEscuelaSave.setnHorasIndeterminadas(tcEscuela.getnHorasIndeterminadas());
				
		escuelaService.guardaEscuela(tcEscuelaSave);
		
			attributes.addFlashAttribute("msgHoras", "Datos de la escuela guardados correctamente!");
			return "redirect:/";			
	}
	
	@GetMapping("formActualizaContra")
	public String formActualizaContra(Usuario usuario, @RequestParam(required = false) Long id, HttpSession session) {
		
		Long nId=(Long) session.getAttribute("nIdUsuario");
		System.out.println(session.getAttribute("nIdUsuario"));
		
		usuario.setnId(nId);
		
		return "escuela/formActualizaPass";
	}
	
	@PostMapping("actualizaPassword")
	public String actualizaPassword(Usuario usuario, Model model, RedirectAttributes attributes) {

		System.out.println(usuario);
		
		if (usuario.getPassword().equals(usuario.getPasswordConfirm()) ) {
			Usuario usuariorecuperado = usuarioService.obtenerUsuarioId(usuario.getnId());		
			usuariorecuperado.setPassword(passwordEncoder.encode(usuario.getPassword()));
			
			usuarioService.guardaUsuario(usuariorecuperado);
			
			attributes.addFlashAttribute("msgActualizaContra", "Contraseña actualizada con exito,  su nueva contraseña es: "+usuario.getPassword());
			return "redirect:/";
		}else {
			model.addAttribute("msg", "las contraseñas no coinciden. Intentar de nuevo");
			return "escuela/formActualizaPass";
		}

		

	}
	
	@GetMapping("reestablecerPassword")
	public String reestablecerPassword(@RequestParam(required = false) Long id, RedirectAttributes attributes) {
		
		TwEscuelaDocentes twEscuelaDocentes = docenteEscuelaService.consultaDocenteEscuela(id);
		
		Usuario usuarioConsultado= usuarioService.obterUsuarioUsername(twEscuelaDocentes.getTcDocentes().getsCurp());
		
		usuarioConsultado.setPassword(passwordEncoder.encode(twEscuelaDocentes.getTcDocentes().getsClaveSerPub()));
		
		usuarioService.guardaUsuario(usuarioConsultado);
		
		attributes.addFlashAttribute("msg", "Contraseña reestablecida correctamente");
		return "redirect:/escuela/consultaDocentes";
	}
	
	
	
	
	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("listaGenero", sexoService.obtenerGenero());
		model.addAttribute("listaPreProfe", preProfeService.obtenerPreProfe());
		model.addAttribute("ListaRegionales", regionalService.obtenerRegiones());
		model.addAttribute("ListaTurno", turnoService.obtenerTurnoEstatus());
		model.addAttribute("ListaZona", zonaEscolarService.obtenerZonaEscolarEstatus());
		model.addAttribute("ListaMunicipio", municipioService.obtenerMunicipioEstatus());
		model.addAttribute("ListaModalidad", modalidadService.obtenerModalidadEstatus());
		model.addAttribute("listaTipoLicencia", tipoLicenciaService.obtenerTipoLicencias());
		model.addAttribute("nIdEscuela", nIdEscuela);
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

}
