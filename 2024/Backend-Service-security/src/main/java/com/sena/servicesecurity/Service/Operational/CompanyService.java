package com.sena.servicesecurity.Service.Operational;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.Entity.Operational.Company;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.Operational.ICompanyRepository;
import com.sena.servicesecurity.IService.Operational.ICompanyService;
import com.sena.servicesecurity.Service.ABaseService;

@Service
public class CompanyService extends ABaseService<Company> implements ICompanyService{

	@Override
	protected IBaseRepository<Company, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}

	@Autowired
	private ICompanyRepository repository;
}
