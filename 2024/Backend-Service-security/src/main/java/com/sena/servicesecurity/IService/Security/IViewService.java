package com.sena.servicesecurity.IService.Security;

import java.util.List;

import com.sena.servicesecurity.DTO.IViewDto;
import com.sena.servicesecurity.Entity.Security.View;
import com.sena.servicesecurity.IService.IBaseService;

public interface IViewService extends IBaseService<View>{
	List<IViewDto> getList();
}
