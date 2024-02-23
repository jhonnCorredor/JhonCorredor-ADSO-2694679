package Examen.ProyectoUbicacion.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import Examen.ProyectoUbicacion.Entity.Continente;
import Examen.ProyectoUbicacion.IRepository.IContinenteRepository;
import Examen.ProyectoUbicacion.IService.IContinenteService;


public class ContinenteService  implements IContinenteService{
	
	@Autowired
	private IContinenteRepository repository;
	
	@Override
	public List<Continente> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Continente> findById(Long id) {
		return repository.findById(id);
	}


	@Override
	public void update(Continente continente, Long id) {
		//Consultar si existe el registro
				Optional<Continente> op = repository.findById(id);
				
				if(op.isEmpty()){
					System.out.print("Registro no existe.");
				}else {
					Continente updateCliente = op.get();					
					updateCliente.setCodigo(continente.getCodigo());
					updateCliente.setNombre(continente.getNombre());
					
					
					updateCliente.setEstado(continente.getEstado());
					updateCliente.setFechaModificacion(LocalDateTime.now());
					
					repository.save(updateCliente);
				}
	}
	
	@Override 
	public void deletedAt(Long id) {
		//Consultar si existe el registro
		Optional<Continente> op = repository.findById(id);
		
		if(op.isEmpty()){
			System.out.print("Registro no existe para eliminar.");
		}else {
			Continente updateCliente = op.get();					
			updateCliente.setFechaEliminacion(LocalDateTime.now());					
			repository.save(updateCliente);
		}	
		
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);	
	}

	@Override
	public Continente save(Continente continente) {
		return repository.save(continente);
	}


}