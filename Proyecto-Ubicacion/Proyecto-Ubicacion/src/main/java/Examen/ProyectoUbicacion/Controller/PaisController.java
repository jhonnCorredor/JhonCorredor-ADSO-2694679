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

import Examen.ProyectoUbicacion.Entity.Pais;
import Examen.ProyectoUbicacion.IService.IPaisService;


@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("v1/api/pais")
public class PaisController {
	@Autowired
	private IPaisService service;
	
	@GetMapping
	public List<Pais> findAll() {
		return service.findAll();
	}
	
	@GetMapping("{id}")
	public Optional<Pais> findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Pais save(@RequestBody Pais pais) {
		return service.save(pais);
	}
	
	@PutMapping("{id}")
	public void save(@RequestBody Pais pais, @PathVariable  Long id) {
		service.update(pais, id);
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
