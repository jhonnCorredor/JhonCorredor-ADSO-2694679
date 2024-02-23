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

import Examen.ProyectoUbicacion.Entity.Departamento;
import Examen.ProyectoUbicacion.IService.IDepartamentoService;


@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("v1/api/departamento")
public class DepartamentoController {
	@Autowired
	private IDepartamentoService service;
	
	@GetMapping
	public List<Departamento> findAll() {
		return service.findAll();
	}
	
	@GetMapping("{id}")
	public Optional<Departamento> findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Departamento save(@RequestBody Departamento departamento) {
		return service.save(departamento);
	}
	
	@PutMapping("{id}")
	public void save(@RequestBody Departamento departamento, @PathVariable  Long id) {
		service.update(departamento, id);
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
