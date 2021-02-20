package gob.edugem.pronii.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import gob.edugem.pronii.dto.AutoCompleteDto;
import gob.edugem.pronii.model.TcDirectores;
import gob.edugem.pronii.service.DirectoresService;

@Controller
public class AutoComplete {
	
	@Autowired
	private DirectoresService directorService;
	
	
	
	@RequestMapping(value="*/directorAutocomplete")
	@ResponseBody
	public List<AutoCompleteDto> directorAutocomplete(@RequestParam(value="term", required = false, defaultValue="") String term) {
		List<AutoCompleteDto> listaEncontrada = new ArrayList<AutoCompleteDto>();
		List<TcDirectores> listaDirector = null;
		if (term.length() >= 3) {
			listaDirector = directorService.consultaDirectorPorNombre(term.toUpperCase());
		}
		System.out.println("listaDirector: "+listaDirector.size());
		for (TcDirectores tcDirectores : listaDirector) {
						
			AutoCompleteDto data = new AutoCompleteDto();
			data.setLabel(tcDirectores.getsNombre().toString());
			data.setValue(tcDirectores.getnId());
			listaEncontrada.add(data);
			
		}
		
		return listaEncontrada;
	}
	
	

}
