package com.sena.servicesecurity.IRepository.Parameter;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.DTO.ICityDto;
import com.sena.servicesecurity.Entity.Parameter.Continent;
import com.sena.servicesecurity.Entity.Parameter.Municipality;
import com.sena.servicesecurity.IRepository.IBaseRepository;

@Repository
public interface IMunicipalityRepository extends IBaseRepository<Municipality, Long> {

}
