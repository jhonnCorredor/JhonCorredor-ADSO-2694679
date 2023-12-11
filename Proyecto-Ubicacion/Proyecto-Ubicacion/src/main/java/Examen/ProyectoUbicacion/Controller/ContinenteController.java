package Examen.ProyectoUbicacion.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Examen.ProyectoUbicacion.Entity.Continente;
import Examen.ProyectoUbicacion.IService.IContinenteService;


@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("v1/api/continente")
public class ContinenteController {
	@Autowired
	private IContinenteService service;
	
	@GetMapping
	public List<Continente> findAll() {
		return service.findAll();
	}
	
	@GetMapping("{id}")
	public Optional<Continente> findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Continente save(@RequestBody Continente continente) {
		return service.save(continente);
	}
	
	@PutMapping("{id}")
	public void save(@RequestBody Continente continente, @PathVariable  Long id) {
		service.update(continente, id);
	}
	
	@PutMapping("deleted-at/{id}")
	public void deletedAt(@PathVariable  Long id) {
		service.deletedAt(id);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable  Long id) {
		service.delete(id);
	}
}
