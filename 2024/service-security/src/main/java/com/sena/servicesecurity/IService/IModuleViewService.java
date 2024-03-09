package com.sena.servicesecurity.IService;

import java.util.List;

import com.sena.servicesecurity.DTO.IModuleViewDto;
import com.sena.servicesecurity.Entity.ModuleView;

public interface IModuleViewService extends IBaseService<ModuleView>{

	List<IModuleViewDto> getList();
}
