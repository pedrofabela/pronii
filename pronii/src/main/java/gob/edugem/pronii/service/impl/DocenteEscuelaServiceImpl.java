package gob.edugem.pronii.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.edugem.pronii.dto.DtoDatosCurp;
import gob.edugem.pronii.model.TcDocentes;
import gob.edugem.pronii.model.TwEscuelaDocentes;
import gob.edugem.pronii.repository.DocenteEscuelaRepository;
import gob.edugem.pronii.repository.DocenteRepository;
import gob.edugem.pronii.service.DocenteEscuelaService;



@Service
public class DocenteEscuelaServiceImpl extends WsConsultaCurpServiceImpl implements DocenteEscuelaService {
	
	@Autowired
	private DocenteEscuelaRepository docenteEscuelaRepository;
	
	@Autowired
	private DocenteRepository docenteRepository;
	
	
	
	@Override
	public List<TwEscuelaDocentes> obtenerDocentesEscuela(Long idEscuela) {
		
		return docenteEscuelaRepository.findBynIdEscuela(idEscuela);
	}

	@Override
	public TcDocentes consultaCurpDocenteRenapo(String curp)  {
		
		TcDocentes tcDocentes= new TcDocentes();
		DtoDatosCurp data = super.consultaCurp(curp);
		
		if (data.getResultado().equals("EXITO")) {
			tcDocentes.setsCurp(data.getsCurp());
			tcDocentes.setsNombre(data.getsNombre());
			tcDocentes.setsPrimerApellido(data.getsApellidoPaterno());
			tcDocentes.setsSegundoApellido(data.getsApellidoMaterno());
			tcDocentes.setsFechaNacimiento(data.getsFechaNacimiento());
			tcDocentes.setnIdSexo(data.getsSexo());
		}else {
			tcDocentes = null;
		}
		
		return tcDocentes;
		 
	}

	@Override
	public TcDocentes consultaDocenteCurp(String curp) {
		
		return docenteRepository.findBysCurp(curp);
	}
	
	@Override
	public TcDocentes consultaDocenteId(Long idDocente) {	
		return docenteRepository.findById(idDocente).get();
	}

	@Override
	@Transactional
	public TcDocentes guardaDocente(TcDocentes tcDocentes) {
		
		TcDocentes docenteGuardado= docenteRepository.save(tcDocentes);
		
		return docenteGuardado;
	}

	@Override
	@Transactional
	public void guardaDocenteEscuela(TwEscuelaDocentes twEscuelaDocentes) {
		docenteEscuelaRepository.save(twEscuelaDocentes);		
	}

	@Override
	public List<TwEscuelaDocentes> consultaRelacionDocenteEscuela(Long idEscuela, Long idDocente) {
		
		System.err.println("idEscuela: "+idEscuela);
		System.err.println("idDocente"+idDocente);
		
		return docenteEscuelaRepository.findBynIdEscuelaAndnIdDocente(idEscuela, idDocente);
	}

	@Override
	@Transactional
	public void eliminarDocenteEscuelaId(Long id) {
		docenteEscuelaRepository.deleteById(id);
		
	}

	@Override
	public TwEscuelaDocentes consultaDocenteEscuela(Long id) {
		
		return docenteEscuelaRepository.findById(id).get();
	}

	@Override
	public List<TwEscuelaDocentes> consultaEscuelaRelacionadas(Long idDocente) {
		
		return docenteEscuelaRepository.findBynIdDocente(idDocente);
	}

	@Override
	@Transactional
	public void eliminarDocenteEscuelaIdEscuela(Long idEscuela) {
		
		docenteEscuelaRepository.deleteBynIdEscuela(idEscuela);
		
	}

	
}
