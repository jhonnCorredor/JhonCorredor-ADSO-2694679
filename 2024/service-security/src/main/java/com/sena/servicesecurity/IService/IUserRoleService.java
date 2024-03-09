package com.sena.servicesecurity.IService;

import java.util.List;

import com.sena.servicesecurity.DTO.IUserRoleDto;
import com.sena.servicesecurity.Entity.UserRole;

public interface IUserRoleService extends IBaseService<UserRole>{

	List<IUserRoleDto> getList();
}
