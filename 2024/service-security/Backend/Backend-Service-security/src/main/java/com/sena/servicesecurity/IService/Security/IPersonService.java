package com.sena.servicesecurity.IService.Security;

import java.util.List;

import com.sena.servicesecurity.DTO.IPersonDto;
import com.sena.servicesecurity.Entity.Security.Person;
import com.sena.servicesecurity.IService.IBaseService;
import com.sena.servicesecurity.Utils.Direction;

public interface IPersonService extends IBaseService<Person>{
	
	List<IPersonDto> getList();
	Direction[] getDirections();
}
