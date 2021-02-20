package gob.edugem.pronii.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import gob.edugem.pronii.model.TcEscuela;
import gob.edugem.pronii.model.TcRegional;
import gob.edugem.pronii.service.DirectoresService;
import gob.edugem.pronii.service.EscuelaService;
import gob.edugem.pronii.service.ModalidadService;
import gob.edugem.pronii.service.MunicipioService;
import gob.edugem.pronii.service.RegionalService;
import gob.edugem.pronii.service.TurnoService;
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
	
	
	public String sNombreDirector;
	public String nId;
	public Long nIdRegion;
	

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
		
		String valorRecibido=escuelaService.guardaEscuela(tcEscuela);
		
		if (valorRecibido.equals(Constantes.guardar) || valorRecibido.equals(Constantes.actualizar)) {		
			tcRegional.setnId(nIdRegion);
			System.out.println("tcRegional id: "+tcRegional.getnId());
			String msg;
			msg = valorRecibido == Constantes.guardar ? "Escuela registrada correctamente!" : "Escuela actualizada correctamente!";
			attributes.addFlashAttribute("tcRegional", tcRegional);
			attributes.addFlashAttribute("msg", msg);
			return "redirect:/administrador/consultaEscuelaRegion";
		}else {
			sNombreDirector= directoresService.consultaDirectorPorId(tcEscuela.getnIdDirector()).getsNombre();
			model.addAttribute("sNombreDirector", sNombreDirector);
			model.addAttribute("msg", "la CCT que intenta registrar ya existe en la base de datos");
			return "administrador/formEscuela";
		}
		
		
		
	}
	
	@GetMapping("editarEscuela")
	public String editarEscuela(@RequestParam(required = false) Long id, Model model) {		
		TcEscuela tcEscuela= escuelaService.obtenerEscuelaId(id);
		sNombreDirector= directoresService.consultaDirectorPorId(tcEscuela.getnIdDirector()).getsNombre();
		model.addAttribute("sNombreDirector", sNombreDirector);
		model.addAttribute("nId", "actualizacion");
		model.addAttribute("tcEscuela", tcEscuela);
		return "administrador/formEscuela";
	}
	
	@GetMapping("eliminarEscuela")
	public String eliminarEscuela(@RequestParam(required = false) Long id, TcRegional tcRegional, RedirectAttributes attributes) {				
		escuelaService.eliminarEscuelaId(id);		
		tcRegional.setnId(nIdRegion);
		System.out.println("tcRegional id: "+tcRegional.getnId());
		attributes.addFlashAttribute("tcRegional", tcRegional);
		attributes.addFlashAttribute("msg", "Escuela eliminada correctamente!");
		return "redirect:/administrador/consultaEscuelaRegion";
	}
	
	
	
	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("ListaRegionales", regionalService.obtenerRegiones());
		model.addAttribute("ListaTurno", turnoService.obtenerTurnoEstatus());
		model.addAttribute("ListaZona", zonaEscolarService.obtenerZonaEscolarEstatus());
		model.addAttribute("ListaMunicipio", municipioService.obtenerMunicipioEstatus());
		model.addAttribute("ListaModalidad", modalidadService.obtenerModalidadEstatus());
		model.addAttribute("nIdRegion",nIdRegion);
		
		
		
	}
	
	
	
	

}
