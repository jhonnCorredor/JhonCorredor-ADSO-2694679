package com.sena.servicesecurity.IService.Security;

import java.util.List;

import com.sena.servicesecurity.DTO.IModuleDto;
import com.sena.servicesecurity.Entity.Security.Module;
import com.sena.servicesecurity.IService.IBaseService;

public interface IModuleService extends IBaseService<Module>{
	List<IModuleDto> getList();

}
