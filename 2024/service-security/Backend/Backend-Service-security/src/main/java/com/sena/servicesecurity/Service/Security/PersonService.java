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
import com.sena.servicesecurity.Utils.Direction;


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
	public Direction[] getDirections() {
		// TODO Auto-generated method stub
		return Direction.values();
	}
	
	
}
