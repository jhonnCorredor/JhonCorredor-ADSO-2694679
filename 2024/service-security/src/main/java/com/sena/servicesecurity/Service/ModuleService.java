package com.sena.servicesecurity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.Entity.Module;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.IModuleRepository;
import com.sena.servicesecurity.IService.IModuleService;


@Service
public class ModuleService extends ABaseService<Module> implements IModuleService{
	@Override
	protected IBaseRepository<Module, Long> getRepository() {
		return repository;
	}
	
	@Autowired
	private IModuleRepository repository;	
}
