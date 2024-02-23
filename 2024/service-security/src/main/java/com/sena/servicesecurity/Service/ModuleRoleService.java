package com.sena.servicesecurity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.Entity.ModuleRole;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.IModuleRoleRepository;
import com.sena.servicesecurity.IService.IModuleRoleService;

@Service
public class ModuleRoleService extends ABaseService<ModuleRole> implements IModuleRoleService{

	@Override
	protected IBaseRepository<ModuleRole, Long> getRepository() {
		return repository;
	}
	
	@Autowired
	private IModuleRoleRepository repository;

}
