package com.sena.servicesecurity.IRepository.Operational;

import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.Entity.Operational.Company;
import com.sena.servicesecurity.IRepository.IBaseRepository;

@Repository
public interface ICompanyRepository extends IBaseRepository<Company,Long>{

}
