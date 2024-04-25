package com.sena.servicesecurity.Service.Parameter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.Entity.Parameter.Neighborhood;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.Parameter.INeighborhoodRepository;
import com.sena.servicesecurity.IService.Parameter.INeighborhoodService;
import com.sena.servicesecurity.Service.ABaseService;

@Service
public class NeighborhoodService extends ABaseService<Neighborhood> implements INeighborhoodService{

	@Override
	protected IBaseRepository<Neighborhood, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Autowired
	public INeighborhoodRepository repository;



}
