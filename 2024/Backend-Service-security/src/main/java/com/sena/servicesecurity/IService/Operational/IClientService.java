package com.sena.servicesecurity.IService.Operational;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.sena.servicesecurity.DTO.IClientDto;
import com.sena.servicesecurity.Entity.Operational.Client;
import com.sena.servicesecurity.Entity.Security.Person;
import com.sena.servicesecurity.IService.IBaseService;

public interface IClientService extends IBaseService<Client>{
	
	List<IClientDto> getList();
	public String GenerateCodeClient(String document,String typedocument,LocalDateTime year) throws Exception;
	public Client savePersonCustomer(Person entity) throws Exception;
	Client consultClient(Long id);
	Optional<Client> findByPersonId(Long personId);
}
