package com.sena.servicesecurity.IService.Security;

import java.util.List;


import com.sena.servicesecurity.DTO.IPersonDto;
import com.sena.servicesecurity.Entity.Security.Person;
import com.sena.servicesecurity.IService.IBaseService;
import com.sena.servicesecurity.Utils.Nomenclature;

public interface IPersonService extends IBaseService<Person>{
	
	List<IPersonDto> getList();
	Nomenclature[] getDirections();
	
	List<IPersonDto> getTypeDocument(String type);
	
	Person save(Person entity) throws Exception;
	
	public void updatePersonClient(Long id, Person entity) throws Exception;
}
