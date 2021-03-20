package gob.edugem.pronii.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import gob.edugem.pronii.model.TcDocentes;
import gob.edugem.pronii.model.TwCenni;
import gob.edugem.pronii.model.TwMetodologia;
import gob.edugem.pronii.model.TwNivelIdioma;
import gob.edugem.pronii.model.Usuario;
import gob.edugem.pronii.service.CertificacionesService;
import gob.edugem.pronii.service.DocenteEscuelaService;
import gob.edugem.pronii.service.ModulosService;
import gob.edugem.pronii.service.NivelCertificacionService;
import gob.edugem.pronii.service.PreProfService;
import gob.edugem.pronii.service.SexoService;
import gob.edugem.pronii.service.TipoCertificacionService;
import gob.edugem.pronii.service.UsuarioService;

@Controller
@RequestMapping("/docente/")
public class DocenteController {

	@Autowired
	private TipoCertificacionService tipoCertificacionService;

	@Autowired
	private NivelCertificacionService nivelCertificacionService;

	@Autowired
	private DocenteEscuelaService docenteService;

	@Autowired
	private ModulosService modulosService;

	@Autowired
	private CertificacionesService certificacionesService;

	@Autowired
	private SexoService sexoService;

	@Autowired
	private PreProfService preProfeService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	
	@GetMapping("registraCertificaciones")
	public String muestraRegistroCertificacion(TwNivelIdioma twNivelIdioma, TwCenni twCenni,
			TwMetodologia twMetodologia, Model model, HttpSession session) {

		TcDocentes tcDocente = docenteService.consultaDocenteCurp((String) session.getAttribute("username"));
		

		twNivelIdioma = certificacionesService.consultaCertificacionNivel(tcDocente.getnId());
		twCenni = certificacionesService.consultaCertificacionCenni(tcDocente.getnId());
		twMetodologia = certificacionesService.consultaCertificacionMetodologia(tcDocente.getnId());

		if (twNivelIdioma != null) {
			model.addAttribute("twNivelIdioma", twNivelIdioma);
		}
		if (twCenni != null) {
			model.addAttribute("twCenni", twCenni);
		}
		if (twMetodologia != null) {
			model.addAttribute("twMetodologia", twMetodologia);
		}

		System.err.println("nIdDocente: " + tcDocente.getnId());

		return "docente/registraCertificaciones";
	}

	@PostMapping("guardaCerNivel")
	public String guardaCerNivel(TwNivelIdioma twNivelIdioma, RedirectAttributes attributes, HttpSession session) {
		
		TcDocentes tcDocentes =docenteService.consultaDocenteCurp((String) session.getAttribute("username"));

		twNivelIdioma.setnIdDocente(tcDocentes.getnId());
		System.out.println(twNivelIdioma);
		
		if (twNivelIdioma.getnId() != null) {
			System.out.println("entro actializar cer nivel");
			TwNivelIdioma twNivelIdiomaConsultado = certificacionesService.consultaCertificacionNivelId(twNivelIdioma.getnId());
			twNivelIdiomaConsultado.setnIdDocente(twNivelIdioma.getnIdDocente());
			twNivelIdiomaConsultado.setnIdTipoCertificacion(twNivelIdioma.getnIdTipoCertificacion());
			twNivelIdiomaConsultado.setnIdNivelIdioma(twNivelIdioma.getnIdNivelIdioma());
			twNivelIdiomaConsultado.setdFechaEmision(twNivelIdioma.getdFechaEmision());
			twNivelIdiomaConsultado.setdFechaVencimiento(twNivelIdioma.getdFechaVencimiento());
			twNivelIdiomaConsultado.setsNombreCertificacion(twNivelIdioma.getsNombreCertificacion());
			
			certificacionesService.guardaCertificacionNivel(twNivelIdiomaConsultado);
			
			
		}else {
			certificacionesService.guardaCertificacionNivel(twNivelIdioma);
		}
		
		
		attributes.addFlashAttribute("msg", "certificación de NIVEL DE IDIOMA registrada correctamente!!");

		return "redirect:/docente/registraCertificaciones";
	}

	@PostMapping("guardaCerCenni")
	public String guardaCerCenni(TwCenni twCenni, RedirectAttributes attributes, HttpSession session) {
		TcDocentes tcDocentes =docenteService.consultaDocenteCurp((String) session.getAttribute("username"));
		twCenni.setnIdDocente(tcDocentes.getnId());
		System.out.println(twCenni);
		
		if (twCenni.getnId() != null) {
			System.out.println("entro actializar cer meto");
			TwCenni twCenniConsultado = certificacionesService.consultaCertificacionCenniId(twCenni.getnId());
			
			twCenniConsultado.setnIdDocente(twCenni.getnIdDocente());
			twCenniConsultado.setnIdNivelIdioma(twCenni.getnIdNivelIdioma());
			twCenniConsultado.setdFechaEmision(twCenni.getdFechaEmision());
			twCenniConsultado.setdFechaVencimineto(twCenni.getdFechaVencimineto());
			
			certificacionesService.guardaCertificacionCenni(twCenniConsultado);
		}
		else {
			certificacionesService.guardaCertificacionCenni(twCenni);
		}
		
		attributes.addFlashAttribute("msg", "certificación CENNI registrada correctamente!!");

		return "redirect:/docente/registraCertificaciones";
	}

	@PostMapping("guardaCerMetodo")
	public String guardaCerCenni(TwMetodologia twMetodologia, RedirectAttributes attributes, HttpSession session) {
		
		TcDocentes tcDocentes =docenteService.consultaDocenteCurp((String) session.getAttribute("username"));
		
		twMetodologia.setnIdDocente(tcDocentes.getnId());
		
		System.out.println(twMetodologia);
		if (twMetodologia.getnId() != null) {
			System.out.println("entro actializar cer nivel");
			TwMetodologia metodologia = certificacionesService.consultaCertificacionMetodologiaId(twMetodologia.getnId());
			
			metodologia.setnIdDocente(twMetodologia.getnIdDocente());
			metodologia.setnIdTipoCertificacion(twMetodologia.getnIdTipoCertificacion());
			metodologia.setnIdModulo1(twMetodologia.getnIdModulo1());
			metodologia.setnIdModulo2(twMetodologia.getnIdModulo2());
			metodologia.setnIdModulo3(twMetodologia.getnIdModulo3());
			metodologia.setdFechaEmision(twMetodologia.getdFechaEmision());
			metodologia.setdFechaVencimineto(twMetodologia.getdFechaVencimineto());
			
			certificacionesService.guardaCertificacionMetodologia(metodologia);
		}else {
			certificacionesService.guardaCertificacionMetodologia(twMetodologia);
		}
		
		
		attributes.addFlashAttribute("msg", "certificación de Metodología en la enseñanza registrada correctamente!!");
		return "redirect:/docente/registraCertificaciones";
	}

	@GetMapping("muestraForm")
	public String consultaCurp(TcDocentes tcDocentes, Model model, HttpSession session) {

		tcDocentes = docenteService.consultaDocenteCurp((String) session.getAttribute("username"));
		System.out.println("tcDocentes: "+tcDocentes.toString());
		if (tcDocentes.getnPerfil() == 0) {
			tcDocentes.setbPerfil(false);
		}else {
			 tcDocentes.setbPerfil(true);
		}	
		model.addAttribute("listaEscuelas", docenteService.consultaEscuelaRelacionadas(tcDocentes.getnId()));
		model.addAttribute("tcDocentes", tcDocentes);

		return "docente/formDocente";
	}

	@PostMapping("guardaDocente")
	public String guardarEscuela(TcDocentes tcDocentes, Model model, RedirectAttributes attributes) {
		
		System.out.println("tcDocentes: "+tcDocentes.toString());
		if (tcDocentes.getbPerfil()) {
			tcDocentes.setnPerfil(1);
		}else {
			 tcDocentes.setnPerfil(0);
		}
		docenteService.guardaDocente(tcDocentes);
		attributes.addFlashAttribute("msgDocente", "Datos Actualizados");

		return "redirect:/";

	}
	
	@GetMapping("formActualizaContra")
	public String formActualizaContra(Usuario usuario, HttpSession session) {
		
		Long nId=(Long) session.getAttribute("nIdUsuario");
		System.out.println(session.getAttribute("nIdUsuario"));
		
		usuario.setnId(nId);
		
		return "docente/formActualizaPass";
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
			return "docente/formActualizaPass";
		}

		

	}

	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("listaCerNivel", tipoCertificacionService.obtenerTipoCertificaciones(1L));
		model.addAttribute("listaCerMetodologia", tipoCertificacionService.obtenerTipoCertificaciones(2L));
		model.addAttribute("listaNivelIdioma", nivelCertificacionService.obtenerNiveles(1L));
		model.addAttribute("listaNivelIdiomaCenni", nivelCertificacionService.obtenerNiveles(2L));
		model.addAttribute("listaModulo", modulosService.obtenerModulos());
		model.addAttribute("listaGenero", sexoService.obtenerGenero());
		model.addAttribute("listaPreProfe", preProfeService.obtenerPreProfe());
		
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
