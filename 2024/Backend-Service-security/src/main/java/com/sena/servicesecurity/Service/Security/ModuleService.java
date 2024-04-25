package com.sena.servicesecurity.Service.Security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.DTO.IModuleDto;
import com.sena.servicesecurity.Entity.Security.Module;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.Security.IModuleRepository;
import com.sena.servicesecurity.IService.Security.IModuleService;
import com.sena.servicesecurity.Service.ABaseService;

@Service
public class ModuleService extends ABaseService<Module> implements IModuleService{

	@Override
	protected IBaseRepository<Module, Long> getRepository() {
		return repository;
	}
	
	@Autowired
	private IModuleRepository repository;

	@Override
	public List<IModuleDto> getList() {
		return repository.getList();
	}	
}