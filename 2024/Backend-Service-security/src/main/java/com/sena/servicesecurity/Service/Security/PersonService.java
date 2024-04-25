package com.sena.servicesecurity.Service.Security;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.DTO.IPersonDto;
import com.sena.servicesecurity.Entity.Operational.Client;
import com.sena.servicesecurity.Entity.Security.Person;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.Security.IPersonRepository;
import com.sena.servicesecurity.IService.Security.IPersonService;
import com.sena.servicesecurity.Service.ABaseService;
import com.sena.servicesecurity.Service.Operational.ClientService;
import com.sena.servicesecurity.Utils.Nomenclature;


@Service
public class PersonService extends ABaseService<Person> implements IPersonService{
	
	@Autowired
	private IPersonRepository repository;
	
	@Autowired
	@Lazy
	ClientService clientService;
	
	@Override
	protected IBaseRepository<Person, Long> getRepository() {
		return repository;
	}
	
	@Override
	public List<IPersonDto> getList() {
		
		return repository.getList();
	}

	@Override
	public Nomenclature[] getDirections() {
		// TODO Auto-generated method stub
		return Nomenclature.values();
	}

	@Override
	public List<IPersonDto> getTypeDocument(String type) {
		return repository.getTypeDocument(type);
	}
	
	@Override
	public Person save(Person entity) throws Exception{
		String document=entity.getDocument();
		String email = entity.getEmail();
		
		IPersonDto Persondocument =repository.getValidationDocument(document);
		IPersonDto PersonEmail =repository.getValidationEmail(email);
		
		if(Persondocument == null) {
			if(PersonEmail ==null) {
				try {
		            entity.setCreatedAt(LocalDateTime.now());
		            entity.setCreatedBy((long)1); //Cuanto esté el loggin, se debe enviar el ID del usuario con Auth
		            return getRepository().save(entity);
		        } catch (Exception e) {
		            // Captura la excepción
		            throw new Exception("Error al guardar la entidad: " + e.getMessage());
		        }
			}else {
				throw new Exception("Dato de email ya registrado");
			}
			
		}else {
			throw new Exception("Dato de document ya registrado");
		}
	}

		@Override
		public void updatePersonClient(Long id, Person entity) throws Exception {
			Optional<Person> op = getRepository().findById(id);
	
	        if (op.isEmpty()) {
	            throw new Exception("Registro no encontrado");
	        } else if (op.get().getDeletedAt() != null) {
	            throw new Exception("Registro inhabilitado");
	        }
	        
	        
	        
	        Person entityUpdate = op.get();
	        Long id_person = entityUpdate.getId();
	        
	        System.out.println(id_person + "data del id");
	        
	
	        String[] ignoreProperties = { "id", "createdAt", "deletedAt", "createdBy", "deletedBy" };
	        BeanUtils.copyProperties(entity, entityUpdate, ignoreProperties);
	        entityUpdate.setUpdatedAt(LocalDateTime.now());
	        entityUpdate.setUpdatedBy((long)1); //Cuanto esté el loggin, se debe enviar el ID del usuario con Auth
	        getRepository().save(entityUpdate);
	       
	        
	        Client cliente = clientService.consultClient(id_person);
	        if(cliente != null) {

		        String code =clientService.GenerateCodeClient(entity.getDocument(), entity.getTypeDocument(), entityUpdate.getCreatedAt());
		        
	        	cliente.setCode(code);
	        	clientService.update(cliente.getId(),cliente);        	
	        }
			
		}
	
	
	
}
