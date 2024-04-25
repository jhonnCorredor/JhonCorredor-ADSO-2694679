package com.sena.servicesecurity.Service.Parameter;

import com.sena.servicesecurity.Entity.Parameter.Continent;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.Parameter.IContinentRepository;
import com.sena.servicesecurity.IService.Parameter.IContinentService;
import com.sena.servicesecurity.Service.ABaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContinentService extends ABaseService<Continent> implements IContinentService{

	@Override
	protected IBaseRepository<Continent, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Autowired
	public  IContinentRepository repository;
	


}
