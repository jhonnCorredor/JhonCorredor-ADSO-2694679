package com.sena.servicesecurity.IRepository.Parameter;

import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.Entity.Parameter.Location;
import com.sena.servicesecurity.IRepository.IBaseRepository;
@Repository
public interface ILocationRepository extends IBaseRepository<Location, Long> {

}
