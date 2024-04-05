package com.sena.servicesecurity.Service.Operational;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.DTO.IContractDto;
import com.sena.servicesecurity.Entity.Operational.Contract;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.Operational.IContractRepository;
import com.sena.servicesecurity.IService.Operational.IContractService;
import com.sena.servicesecurity.Service.ABaseService;

@Service
public class ContractService extends ABaseService<Contract> implements IContractService{
	

	@Autowired
	private IContractRepository repository;
	
	@Override
	public List<IContractDto> GetListContract() {
		// TODO Auto-generated method stub
		return repository.GetListContract();
	}

	@Override
	protected IBaseRepository<Contract, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
}
