package com.sena.servicesecurity.Service.Security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.DTO.IPersonDto;
import com.sena.servicesecurity.Entity.Security.Person;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.Security.IPersonRepository;
import com.sena.servicesecurity.IService.Security.IPersonService;
import com.sena.servicesecurity.Service.ABaseService;
import com.sena.servicesecurity.Utils.Nomenclature;


@Service
public class PersonService extends ABaseService<Person> implements IPersonService{
	@Override
	protected IBaseRepository<Person, Long> getRepository() {
		return repository;
	}
	
	@Autowired
	private IPersonRepository repository;

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
	public Person getValidation(Person entity) throws Exception{
		String document=entity.getDocument();
		String email = entity.getEmail();
		
		IPersonDto Persondocument =repository.getValidationDocument(document);
		IPersonDto PersonEmail =repository.getValidationEmail(email);
		
		if(Persondocument == null) {
			if(PersonEmail ==null) {
				return this.save(entity);
			}else {
				throw new Exception("Dato de email ya registrado");
			}
			
		}else {
			throw new Exception("Dato de document ya registrado");
		}
	}
	
}
