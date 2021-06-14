package br.com.nutrition.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nutrition.datasource.model.Nutricionista;
import br.com.nutrition.excepition.NutricionistaNotFoundException;
import br.com.nutrition.repository.NutricionistaRepository;
import br.com.nutrition.resourse.model.NutricionistaResource;
import br.com.nutrition.service.BuscarNutricionistaPorIdServiceImpl;
import br.com.nutrition.service.BuscarNutricionistasServiceImpl;
import br.com.nutrition.service.CadastroNutricionistaServiceImpl;

@RestController
@RequestMapping(value = "/api")
public class NutricionistaController {

	@Autowired
	private BuscarNutricionistasServiceImpl serviceBuscar;
	
	@Autowired
	private CadastroNutricionistaServiceImpl serviceCadastro;
	@Autowired
	private BuscarNutricionistaPorIdServiceImpl serviceBuscarById;
	
	@GetMapping(path = "/nutricionistas")
	public List<Nutricionista> buscarNutricionistas() {
		return serviceBuscar.buscarTodosNutricionista();
	}
	
	@GetMapping(path = "/nutricionista/id/{id}")
	public Nutricionista buscarNutricionistaById(@PathVariable (name = "id", required = true)Long id) throws NutricionistaNotFoundException {
		return serviceBuscarById.buscarById(id);
	}
	
	@PostMapping(path = "/nutricionista/save")
	public void salvarNutricionista(@RequestBody NutricionistaResource nutricionista) {
		serviceCadastro.cadastro(nutricionista);;
	}
	
	@PostMapping(path = "/nutricionista/delete/{id}")
	public void deleteNutricionista(@PathVariable (name = "id", required = true)Long id) throws NutricionistaNotFoundException {
		serviceBuscarById.buscarById(id);
	}
}
