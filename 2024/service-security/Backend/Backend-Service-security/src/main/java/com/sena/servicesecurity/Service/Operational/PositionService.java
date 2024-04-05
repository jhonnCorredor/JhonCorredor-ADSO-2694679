package com.sena.servicesecurity.Service.Operational;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.Entity.Operational.Position;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.Operational.IPositionRepository;
import com.sena.servicesecurity.IService.Operational.IPositionService;
import com.sena.servicesecurity.Service.ABaseService;

@Service
public class PositionService extends ABaseService<Position> implements IPositionService{

	@Override
	protected IBaseRepository<Position, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}

	@Autowired
	private IPositionRepository repository;
	

}
