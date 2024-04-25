package com.sena.servicesecurity.Service.Parameter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.Entity.Parameter.Location;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.Parameter.ILocationRepository;
import com.sena.servicesecurity.IService.Parameter.ILocationService;
import com.sena.servicesecurity.Service.ABaseService;



@Service
public class LocationService extends ABaseService<Location> implements ILocationService {

  

    @Override
    protected IBaseRepository<Location, Long> getRepository() {
        return repository;
    }
    
    @Autowired
    public ILocationRepository repository;

}
