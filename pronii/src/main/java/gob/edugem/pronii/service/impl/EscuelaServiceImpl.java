package gob.edugem.pronii.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.edugem.pronii.model.TcEscuela;
import gob.edugem.pronii.repository.EscuelaRepository;
import gob.edugem.pronii.service.EscuelaService;
import gob.edugem.pronii.utils.Constantes;

@Service
public class EscuelaServiceImpl implements EscuelaService {
	
	@Autowired
	private EscuelaRepository escuelaRepository;
	
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
	public String guardaEscuela(TcEscuela tcEscuela) {
		
		if (tcEscuela.getnId() != null ) { // si tiene id actualiza los datos. 
			escuelaRepository.save(tcEscuela);
			return Constantes.actualizar;
		}else {// si no verifica que la cct que intenta registrar no exista.
			if (escuelaRepository.findBysCct(tcEscuela.getsCct()).size() > 0) {
				return Constantes.errorYaExiste;
			}else {
				escuelaRepository.save(tcEscuela);
				return Constantes.guardar;
			}	
		}
			
	}

	@Override
	public void eliminarEscuelaId(Long id) {
		escuelaRepository.deleteById(id);		
	}

	

}
