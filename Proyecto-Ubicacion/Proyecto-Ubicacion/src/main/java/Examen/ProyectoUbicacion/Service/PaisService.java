package Examen.ProyectoUbicacion.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Examen.ProyectoUbicacion.Entity.Pais;
import Examen.ProyectoUbicacion.IRepository.IPaisRepository;
import Examen.ProyectoUbicacion.IService.IPaisService;

@Service
public class PaisService implements IPaisService{

	@Autowired
	private IPaisRepository repository;
	
	@Override
	public List<Pais> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Pais> findById(Long id) {
		return repository.findById(id);
	}

	
	
	
	@Override
	public void deletedAt(Long id) {
		//Consultar si existe el registro
		Optional<Pais> op = repository.findById(id);
		
		if(op.isEmpty()){
			System.out.print("Registro no existe para eliminar.");
		}else {
			Pais updateFactura= op.get();					
			updateFactura.setFechaEliminacion(LocalDateTime.now());					
			repository.save(updateFactura);
		}	
		
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);	
	}

	@Override
	public Pais save(Pais pais) {
		return repository.save(pais);
	
	}

	@Override
	public void update(Pais pais, Long id) {
		// TODO Auto-generated method stub
		//Consultar si existe el registro
		Optional<Pais> op = repository.findById(id);
		
		if(op.isEmpty()){
			System.out.print("Registro no existe.");
		}else {
			Pais updateFactura = op.get();					
			updateFactura.setCodigo(pais.getCodigo());
			updateFactura.setNombre(pais.getNombre());
			updateFactura.setContinenteId(pais.getContinenteId());
			
			
		
			
			updateFactura.setEstado(pais.getEstado());
			updateFactura.setFechaModificacion(LocalDateTime.now());
			
			repository.save(updateFactura);
		}	

	}

}
