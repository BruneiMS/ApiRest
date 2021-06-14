package br.com.nutrition.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nutrition.datasource.model.Nutricionista;
import br.com.nutrition.excepition.NutricionistaNotFoundException;
import br.com.nutrition.repository.NutricionistaRepository;

@Service
public class BuscarNutricionistaPorIdServiceImpl {

	@Autowired
	private NutricionistaRepository nutricionistaRepository;
	
	public Nutricionista buscarById(Long id) throws NutricionistaNotFoundException {
		Optional<Nutricionista> optionalNutricionista = getOptional(id);
		
		Nutricionista nutricionista = null;
		if(!optionalNutricionista.isPresent()) {
			throw new NutricionistaNotFoundException("Nutricionista não Encontrado atraves do ID: " + id);
		} else {
			nutricionista = optionalNutricionista.get();
		}
		return nutricionista;
	}

	private Optional<Nutricionista> getOptional(Long id) {
		Optional<Nutricionista> optionalNutricionista = nutricionistaRepository.findById(id);
		return optionalNutricionista;
	}
	
	public void deletById(Long id) throws NutricionistaNotFoundException {
		
		Optional<Nutricionista> optionalNutricionista = getOptional(id);
		
		if(!optionalNutricionista.isPresent()) {
			throw new NutricionistaNotFoundException("Nutricionista não Encontrado atraves do ID: " + id);
		}else {
			nutricionistaRepository.delete(optionalNutricionista.get());
		}
		
		nutricionistaRepository.deleteById(id);
	}
}
