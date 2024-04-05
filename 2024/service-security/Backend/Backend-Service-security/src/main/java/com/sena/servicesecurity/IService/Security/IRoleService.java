package com.sena.servicesecurity.IService.Security;

import java.util.List;

import com.sena.servicesecurity.DTO.IRoleDto;
import com.sena.servicesecurity.Entity.Security.Role;
import com.sena.servicesecurity.IService.IBaseService;

public interface IRoleService extends IBaseService<Role>{

	List<IRoleDto> getList();
}
