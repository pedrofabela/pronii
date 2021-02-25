package gob.edugem.pronii.service;

import java.util.List;

import gob.edugem.pronii.model.TcDocentes;
import gob.edugem.pronii.model.TwEscuelaDocentes;

public interface DocenteEscuelaService {
	
	public List<TwEscuelaDocentes> obtenerDocentesEscuela(Long idEscuela);
	
	public TcDocentes consultaCurpDocenteRenapo(String curp);
	
	public TcDocentes consultaDocenteCurp(String curp);
	
	public TcDocentes guardaDocente(TcDocentes tcDocentes);
	
	public TcDocentes consultaDocenteId(Long idDocente);
	
	public void guardaDocenteEscuela(TwEscuelaDocentes twEscuelaDocentes);
	
	public List<TwEscuelaDocentes> consultaRelacionDocenteEscuela(Long idEscuela, Long idDocente);
	
	public List<TwEscuelaDocentes> consultaEscuelaRelacionadas(Long idDocente);
	
	public void eliminarDocenteEscuelaId(Long id);
	
	public void eliminarDocenteEscuelaIdEscuela(Long idEscuela);
	
	public TwEscuelaDocentes consultaDocenteEscuela(Long id);

}
