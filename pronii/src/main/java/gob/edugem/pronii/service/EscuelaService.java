package gob.edugem.pronii.service;

import java.util.List;

import gob.edugem.pronii.model.TcEscuela;

public interface EscuelaService  {
	public TcEscuela obtenerEscuelaId(Long  id);
	public TcEscuela obtenerEscuelaCct(String cct);
	public List <TcEscuela> ListaEscuelaRegion(Long nIdRegion);
	public String  guardaEscuela(TcEscuela tcEscuela);
	public void eliminarEscuelaId(Long id);
}
