package com.sena.servicesecurity.Service.Operational;

import java.time.LocalDate;
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
			
			String code = GenerateCodeClient(entity.getPerson().getId());
			

			
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

        String code = GenerateCodeClient(entity.getPerson().getId());
		
        Client entityUpdate = op.get();

        String[] ignoreProperties = { "id", "createdAt", "deletedAt", "createdBy", "deletedBy" };
        BeanUtils.copyProperties(entity, entityUpdate, ignoreProperties);
        entityUpdate.setCode(code);
        entityUpdate.setUpdatedAt(LocalDateTime.now());
        entityUpdate.setUpdatedBy((long)1); //Cuanto esté el loggin, se debe enviar el ID del usuario con Auth
        getRepository().save(entityUpdate);
	}
	
	@Override
	public String GenerateCodeClient(Long idPerson) throws Exception {
			
		Optional<Person> person = personService.findById(idPerson);
		
		String type= person.get().getTypeDocument();
		String document = person.get().getDocument();
		// Obtener el año actual
		int currentYear = LocalDate.now().getYear();

		// Obtener los últimos 4 dígitos de document
		String documentSuffix = document.substring(Math.max(0, document.length() - 4));

		// Combinar los elementos para formar el código
		String code = currentYear + "-" + type + "-" + documentSuffix;
		
		return code;
		
	}
	
	@Override
	public Client savePersonCustomer(Person entity) throws Exception {
		System.out.print(entity.getDocument());
	    Person person = personService.getValidation(entity);
	    
        Client entityCustomer = new Client();
        
	    String codeCustomer =GenerateCodeClient(person.getId());
	    
	    entityCustomer.setCode(codeCustomer);
	    entityCustomer.setPerson(person);
	    entityCustomer.setState(true);
	    entityCustomer.setCreatedAt(LocalDateTime.now());
	    entityCustomer.setCreatedBy((long) 1);
	    
	    Client customer = save(entityCustomer);
	    
	    return customer;
	}

}
