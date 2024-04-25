package com.sena.servicesecurity.IService.Operational;

import java.util.List;

import com.sena.servicesecurity.DTO.IEmployedDto;
import com.sena.servicesecurity.Entity.Operational.Employed;
import com.sena.servicesecurity.IService.IBaseService;

public interface IEmployedService extends IBaseService<Employed>{

	List<IEmployedDto> getListEmployee();
}
