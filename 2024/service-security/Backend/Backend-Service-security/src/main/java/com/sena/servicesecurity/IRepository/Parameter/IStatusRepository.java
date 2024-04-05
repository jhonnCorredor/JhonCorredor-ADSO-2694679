package com.sena.servicesecurity.IRepository.Parameter;

import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.Entity.Parameter.Country;
import com.sena.servicesecurity.Entity.Parameter.Status;
import com.sena.servicesecurity.IRepository.IBaseRepository;


@Repository
public interface IStatusRepository extends IBaseRepository<Status, Long>{

}
