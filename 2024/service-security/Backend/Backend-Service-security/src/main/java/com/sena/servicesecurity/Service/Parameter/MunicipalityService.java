package com.sena.servicesecurity.Service.Parameter;



import com.sena.servicesecurity.Entity.Parameter.Municipality;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.Parameter.IMunicipalityRepository;
import com.sena.servicesecurity.IService.Parameter.IMunicipalityService;
import com.sena.servicesecurity.Service.ABaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MunicipalityService extends ABaseService<Municipality> implements IMunicipalityService{

	@Override
	protected IBaseRepository<Municipality, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}

	@Autowired
	private IMunicipalityRepository repository;

	
}
