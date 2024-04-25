package com.sena.servicesecurity.Service.Parameter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.Entity.Parameter.Status;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.Parameter.IStatusRepository;
import com.sena.servicesecurity.IService.Parameter.IStatusService;
import com.sena.servicesecurity.Service.ABaseService;

@Service
public class StatusService  extends ABaseService<Status> implements IStatusService{

	
	@Autowired
	public IStatusRepository repository;



	@Override
	protected IBaseRepository<Status, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
}

