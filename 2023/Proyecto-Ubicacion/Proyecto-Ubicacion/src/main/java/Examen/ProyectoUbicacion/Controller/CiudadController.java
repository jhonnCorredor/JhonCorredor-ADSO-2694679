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

import Examen.ProyectoUbicacion.Entity.Ciudad;
import Examen.ProyectoUbicacion.IService.ICiudadService;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("v1/api/ciudad")
public class CiudadController {

	@Autowired
	private ICiudadService service;
	
	@GetMapping
	public List<Ciudad> findAll() {
		return service.findAll();
	}
	
	@GetMapping("{id}")
	public Optional<Ciudad> findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Ciudad save(@RequestBody Ciudad ciudad) {
		return service.save(ciudad);
	}
	
	@PutMapping("{id}")
	public void save(@RequestBody Ciudad ciudad, @PathVariable  Long id) {
		service.update(ciudad, id);
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
