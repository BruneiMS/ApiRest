package br.com.nutrition.service;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import br.com.nutrition.datasource.model.Nutricionista;
import br.com.nutrition.excepition.NutricionistaResourceException;
import br.com.nutrition.resourse.model.NutricionistaResource;

@Component
public class NutricionistaConversor {

	public Nutricionista conversor(NutricionistaResource nutricionistaResource) throws NutricionistaResourceException {
		
		try {
			Nutricionista nutricionista = new Nutricionista();
			Long idPaciente = checkidPaciente(nutricionistaResource.getIdPaciente());
			
			LocalDate idade = checkIdade(nutricionistaResource.getIdade());
			nutricionista.setIdPaciente(idPaciente);
			nutricionista.setIdade(idade);
			nutricionista.setCodigoRegistro(nutricionistaResource.getCodigoRegistro());
			nutricionista.setNome(nutricionistaResource.getNome());
			
			return nutricionista;
			
		}catch (Exception e) {
			throw new NutricionistaResourceException("Falha ao converter o resource para entidade, resource: " + nutricionistaResource);
		}
	
	}
	
	private Long checkidPaciente(String IdPaciente) {
		return Long.parseLong(IdPaciente);
	}
	
	private LocalDate checkIdade(String idade) {
		return LocalDate.parse(idade);
	}
}
