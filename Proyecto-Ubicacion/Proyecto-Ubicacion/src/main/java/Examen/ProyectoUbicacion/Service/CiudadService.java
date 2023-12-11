package Examen.ProyectoUbicacion.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import Examen.ProyectoUbicacion.Entity.Ciudad;
import Examen.ProyectoUbicacion.Entity.Continente;
import Examen.ProyectoUbicacion.IRepository.ICiudadRepository;
import Examen.ProyectoUbicacion.IRepository.IContinenteRepository;
import Examen.ProyectoUbicacion.IService.ICiudadService;
import Examen.ProyectoUbicacion.IService.IContinenteService;


public class CiudadService  implements ICiudadService{
	
	
	@Autowired
	private ICiudadRepository repository;
	
	@Override
	public List<Ciudad> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Ciudad> findById(Long id) {
		return repository.findById(id);
	}

	
	@Override 
	public void deletedAt(Long id) {
		//Consultar si existe el registro
		Optional<Ciudad> op = repository.findById(id);
		
		if(op.isEmpty()){
			System.out.print("Registro no existe para eliminar.");
		}else {
			Ciudad updateCliente = op.get();					
			updateCliente.setFechaEliminacion(LocalDateTime.now());					
			repository.save(updateCliente);
		}	
		
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);	
	}

	@Override
	public Ciudad save(Ciudad ciudad) {
		return repository.save(ciudad);
	}


	@Override
	public void update(Ciudad ciudad, Long id) {
		
		Optional<Ciudad> op = repository.findById(id);
		
		if(op.isEmpty()){
			System.out.print("Registro no existe.");
		}else {
		Ciudad updateCliente = op.get();					
							
		updateCliente.setCodigo(ciudad.getCodigo());
		updateCliente.setNombre(ciudad.getNombre());
			updateCliente.setEstado(ciudad.getEstado());
			updateCliente.setFechaModificacion(LocalDateTime.now());
			
			repository.save(updateCliente);
		}
		
	}
	


}