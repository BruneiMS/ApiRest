package br.com.nutrition.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nutrition.datasource.model.Nutricionista;
import br.com.nutrition.repository.NutricionistaRepository;


@Service
public class BuscarNutricionistasServiceImpl {

	private static final Logger LOG = Logger.getLogger(BuscarNutricionistasServiceImpl.class);
	
	@Autowired
	private NutricionistaRepository nutricionistaRepository;
	
	public List<Nutricionista> buscarTodosNutricionista(){
		List<Nutricionista> listNutricionista = nutricionistaRepository.findAll();
		return listNutricionista;
	}
}
