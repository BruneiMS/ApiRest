package br.com.nutrition.service;

import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nutrition.datasource.model.Nutricionista;
import br.com.nutrition.repository.NutricionistaRepository;
import br.com.nutrition.resourse.model.NutricionistaResource;

@Service
public class CadastroNutricionistaServiceImpl {
	
	private static final Logger LOG = Logger.getLogger(CadastroNutricionistaServiceImpl.class);
	
	@Autowired
	private NutricionistaRepository nutricionistaRepository;
	
	@Autowired
	private NutricionistaConversor service;
	
	public void cadastro(NutricionistaResource nutricionistaResource) {
		
		try {
			Nutricionista nutricionista = service.conversor(nutricionistaResource);
			
			nutricionistaRepository.saveAndFlush(nutricionista);
		} catch (Exception e) {
			LOG.error("Erro ao salvar o nutricionista: " + e.getMessage(), e);
		}
		
		
	}
}
