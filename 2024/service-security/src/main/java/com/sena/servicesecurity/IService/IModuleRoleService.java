package com.sena.servicesecurity.IService;

import java.util.List;

import com.sena.servicesecurity.DTO.IModuleRoleDto;
import com.sena.servicesecurity.Entity.ModuleRole;

public interface IModuleRoleService extends IBaseService<ModuleRole>{
	
	List<IModuleRoleDto> getList();
}
