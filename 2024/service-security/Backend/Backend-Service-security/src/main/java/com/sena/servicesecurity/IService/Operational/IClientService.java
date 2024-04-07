package com.sena.servicesecurity.IService.Operational;

import java.util.List;

import com.sena.servicesecurity.DTO.IClientDto;
import com.sena.servicesecurity.Entity.Operational.Client;
import com.sena.servicesecurity.Entity.Security.Person;
import com.sena.servicesecurity.IService.IBaseService;

public interface IClientService extends IBaseService<Client>{
	
	List<IClientDto> getList();
	public String GenerateCodeClient(Long idPerson) throws Exception;
	public Client savePersonCustomer(Person entity) throws Exception;
}
