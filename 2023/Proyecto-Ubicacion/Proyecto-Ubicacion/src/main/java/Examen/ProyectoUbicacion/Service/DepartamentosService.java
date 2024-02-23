package Examen.ProyectoUbicacion.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import Examen.ProyectoUbicacion.Entity.Departamento;
import Examen.ProyectoUbicacion.IRepository.IDepartamentoRepository;
import Examen.ProyectoUbicacion.IService.IDepartamentoService;

@Service
public class DepartamentosService implements IDepartamentoService{
	@Autowired
	private IDepartamentoRepository repository;
	



	@Override
	public List<Departamento> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Departamento> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Departamento save(Departamento departamento) {
		return repository.save(departamento);
	}

	@Override
	public void update(Departamento departamento, Long id) {
		//Consultar si existe el registro
				Optional<Departamento> op = repository.findById(id);
				
				if(op.isEmpty()){
					System.out.print("Registro no existe.");
				}else {
					Departamento updateFactura = op.get();					
					updateFactura.setCodigo(departamento.getCodigo());
					updateFactura.setNombre(departamento.getNombre());
					updateFactura.setPaisId(departamento.getPaisId());
					
					
					
					updateFactura.setEstado(departamento.getEstado());
					updateFactura.setFechaModificacion(LocalDateTime.now());
					
					repository.save(updateFactura);
				}	
		
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public void deletedAt(Long id) {
		//Consultar si existe el registro
		Optional<Departamento> op = repository.findById(id);
		
		if(op.isEmpty()){
			System.out.print("Registro no existe para eliminar.");
		}else {
			Departamento updateFactura= op.get();					
			updateFactura.setFechaEliminacion(LocalDateTime.now());					
			repository.save(updateFactura);
		}	
		
	}

	

	
	
	
	

	

	

}
