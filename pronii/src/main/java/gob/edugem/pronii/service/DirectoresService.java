package gob.edugem.pronii.service;

import java.util.List;

import gob.edugem.pronii.model.TcDirectores;

public interface DirectoresService {
	
	public List<TcDirectores> consultaDirectorPorNombre(String term);
	
	public TcDirectores consultaDirectorPorId(Long id);

}
