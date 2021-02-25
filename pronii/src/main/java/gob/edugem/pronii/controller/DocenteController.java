package gob.edugem.pronii.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
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

	Long nIdDocente;

	@GetMapping("registraCertificaciones")
	public String muestraRegistroCertificacion(Authentication auth, TwNivelIdioma twNivelIdioma, TwCenni twCenni,
			TwMetodologia twMetodologia, Model model) {

		TcDocentes tcDocente = docenteService.consultaDocenteCurp(auth.getName());
		nIdDocente = tcDocente.getnId();

		twNivelIdioma = certificacionesService.consultaCertificacionNivel(nIdDocente);
		twCenni = certificacionesService.consultaCertificacionCenni(nIdDocente);
		twMetodologia = certificacionesService.consultaCertificacionMetodologia(nIdDocente);

		if (twNivelIdioma != null) {
			model.addAttribute("twNivelIdioma", twNivelIdioma);
		}
		if (twCenni != null) {
			model.addAttribute("twCenni", twCenni);
		}
		if (twMetodologia != null) {
			model.addAttribute("twMetodologia", twMetodologia);
		}

		System.err.println("nIdDocente: " + nIdDocente);

		return "docente/registraCertificaciones";
	}

	@PostMapping("guardaCerNivel")
	public String guardaCerNivel(TwNivelIdioma twNivelIdioma, RedirectAttributes attributes) {

		twNivelIdioma.setnIdDocente(nIdDocente);
		System.out.println(twNivelIdioma);
		certificacionesService.guardaCertificacionNivel(twNivelIdioma);

		return "redirect:/docente/registraCertificaciones";
	}

	@PostMapping("guardaCerCenni")
	public String guardaCerCenni(TwCenni twCenni, RedirectAttributes attributes) {

		twCenni.setnIdDocente(nIdDocente);
		System.out.println(twCenni);
		certificacionesService.guardaCertificacionCenni(twCenni);

		return "redirect:/docente/registraCertificaciones";
	}

	@PostMapping("guardaCerMetodo")
	public String guardaCerCenni(TwMetodologia twMetodologia, RedirectAttributes attributes) {

		twMetodologia.setnIdDocente(nIdDocente);
		System.out.println(twMetodologia);
		certificacionesService.guardaCertificacionMetodologia(twMetodologia);

		return "redirect:/docente/registraCertificaciones";
	}

	@GetMapping("muestraForm")
	public String consultaCurp(Authentication auth, TcDocentes tcDocentes, Model model) {

		tcDocentes = docenteService.consultaDocenteCurp(auth.getName());
		model.addAttribute("listaEscuelas", docenteService.consultaEscuelaRelacionadas(tcDocentes.getnId()));
		model.addAttribute("tcDocentes", tcDocentes);

		return "docente/formDocente";
	}

	@PostMapping("guardaDocente")
	public String guardarEscuela(TcDocentes tcDocentes, Model model, RedirectAttributes attributes) {

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
		model.addAttribute("nIdDocente", nIdDocente);
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
