package gob.edugem.pronii.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.edugem.pronii.dto.DtoDatosCurp;
import gob.edugem.pronii.model.TcDirectores;
import gob.edugem.pronii.repository.DirectoresRepository;
import gob.edugem.pronii.service.DirectoresService;

@Service
public class DirectoresServiceImpl extends WsConsultaCurpServiceImpl implements DirectoresService {
	
	@Autowired
    private DirectoresRepository directoresRepositorio;


	@Override
	public List<TcDirectores> consultaDirectorPorNombre(String term) {
		
		return directoresRepositorio.findBysNombre(term);
	}


	@Override
	public TcDirectores consultaDirectorPorId(Long id) {
		
		return directoresRepositorio.findById(id).get();
	}


	@Override
	public TcDirectores consultaCurpDirectorRenapo(String curp) {
		TcDirectores tcDirectores= new TcDirectores();
		DtoDatosCurp data = super.consultaCurp(curp);
		
		if (data.getResultado().equals("EXITO")) {
			tcDirectores.setsCurp(data.getsCurp());
			tcDirectores.setsNombre(data.getsNombre());
			tcDirectores.setsApellidoPaterno(data.getsApellidoPaterno());
			tcDirectores.setsApellidoMaterno(data.getsApellidoMaterno());
			//tcDirectores.setsFechaNacimiento(data.getsFechaNacimiento());
			//tcDirectores.setnIdSexo(data.getsSexo());
		}else {
			tcDirectores = null;
		}
		
		return tcDirectores;
		
	}


	@Override
	public TcDirectores consultaDirectorCurp(String curp) {
		
		return directoresRepositorio.findBysCurp(curp);
	}

	
	@Override
	@Transactional
	public TcDirectores guardarDirector(TcDirectores tcDirector) {
		TcDirectores tcDirectores = directoresRepositorio.save(tcDirector);
		return tcDirectores;
	}
	
	
	
	
	

	
}
