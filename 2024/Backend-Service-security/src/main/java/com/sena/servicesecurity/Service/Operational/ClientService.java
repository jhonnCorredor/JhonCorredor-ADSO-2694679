package com.sena.servicesecurity.Service.Operational;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sena.servicesecurity.Entity.Security.Person;
import com.sena.servicesecurity.Service.ABaseService;
import com.sena.servicesecurity.Service.Security.PersonService;
import com.sena.servicesecurity.DTO.IClientDto;
import com.sena.servicesecurity.Entity.Operational.Client;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.Operational.IClientRepository;
import com.sena.servicesecurity.IService.Operational.IClientService;

@Service
public class ClientService extends ABaseService<Client> implements IClientService{

	@Override
	protected IBaseRepository<Client, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Autowired
	private IClientRepository repository;
	
	@Autowired
	private PersonService personService;

	@Override
	public List<IClientDto> getList() {
		return repository.getList();
	}

	@Override
	public Client save(Client entity) throws Exception {
		try {
			Optional<Person> findbyid =personService.findById(entity.getPerson().getId());
			Person person = findbyid.get();
			String code = GenerateCodeClient(person.getDocument(),person.getTypeDocument(),person.getCreatedAt());
				
			entity.setCode(code);
            entity.setCreatedAt(LocalDateTime.now());
            entity.setCreatedBy((long)1); //Cuanto esté el loggin, se debe enviar el ID del usuario con Auth
            return getRepository().save(entity);
        } catch (Exception e) {
            // Captura la excepción
            throw new Exception("Error al guardar la entidad: " + e.getMessage());
        }
	}

	@Override
	public void update(Long id, Client entity) throws Exception {
		Optional<Client> op = getRepository().findById(id);

        if (op.isEmpty()) {
            throw new Exception("Registro no encontrado");
        } else if (op.get().getDeletedAt() != null) {
            throw new Exception("Registro inhabilitado");
        }
        Client entityUpdate = op.get();
        
        Person personUpdate = entity.getPerson();
        
        
        Optional<Client> clientExist = getRepository().findById(id);
        Person personExist = clientExist.get().getPerson();
        
        if(personExist.getDocument() != entity.getPerson().getDocument() || personExist.getTypeDocument() != entity.getPerson().getTypeDocument()) {
        	
        	
        	String code = GenerateCodeClient(personUpdate.getDocument(),personUpdate.getTypeDocument(),clientExist.get().getCreatedAt());
        	
        	personService.update(personUpdate.getId(), personUpdate);
        	String[] ignoreProperties = { "id", "createdAt", "deletedAt", "createdBy", "deletedBy", };
            BeanUtils.copyProperties(entity, entityUpdate, ignoreProperties);
            entityUpdate.setCode(code);
            entityUpdate.setUpdatedAt(LocalDateTime.now());
            entityUpdate.setUpdatedBy((long)1); //Cuanto esté el loggin, se debe enviar el ID del usuario con Auth
            getRepository().save(entityUpdate);
        }else {
        	personService.update(personUpdate.getId(), personUpdate);
        	String[] ignoreProperties = { "id", "createdAt", "deletedAt", "createdBy", "deletedBy","code" };
            BeanUtils.copyProperties(entity, entityUpdate, ignoreProperties);
            entityUpdate.setUpdatedAt(LocalDateTime.now());
            entityUpdate.setUpdatedBy((long)1); //Cuanto esté el loggin, se debe enviar el ID del usuario con Auth
            getRepository().save(entityUpdate);
        }
	}
	
	@Override
	public String GenerateCodeClient(String document,String typedocument,LocalDateTime year) throws Exception {
		// Obtener los últimos 4 dígitos de document
		String documentSuffix = document.substring(Math.max(0, document.length() - 4));
		// Combinar los elementos para formar el código
		String code = year.getYear() + "-" + typedocument + "-" + documentSuffix;
		System.out.print("generate"+ code);
		return code;
		
	}
	
	@Override
	public Client savePersonCustomer(Person entity) throws Exception {
		System.out.print(entity.getDocument());
	    Person person = personService.save(entity);
	    
        Client entityCustomer = new Client();
        System.out.print(entityCustomer.getCode());
        
	    String codeCustomer =GenerateCodeClient(person.getDocument(),person.getTypeDocument(),person.getCreatedAt());
	    
	    entityCustomer.setCode(codeCustomer);
	    entityCustomer.setPerson(person);
	    entityCustomer.setState(true);
	    entityCustomer.setCreatedAt(LocalDateTime.now());
	    entityCustomer.setCreatedBy((long) 1);
	    
	    Client customer = save(entityCustomer);
	    
	    return customer;
	}

	@Override
	public Client consultClient(Long id) {
		// TODO Auto-generated method stub
		return repository.consultClient(id);
	}
	
	@Override
	public Optional<Client> findByPersonId(Long personId) {
		return  repository.findByPersonId(personId);
	}


	
	

}
