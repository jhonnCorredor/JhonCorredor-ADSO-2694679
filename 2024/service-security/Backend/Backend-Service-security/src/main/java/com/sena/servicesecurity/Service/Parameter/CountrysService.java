package com.sena.servicesecurity.Service.Parameter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.DTO.ICountryDto;
import com.sena.servicesecurity.Entity.Parameter.Country;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.Parameter.ICountryRepository;
import com.sena.servicesecurity.IService.Parameter.ICountryService;
import com.sena.servicesecurity.Service.ABaseService;


@Service
public class CountrysService extends ABaseService<Country> implements ICountryService {

  


    
    @Autowired
    public ICountryRepository repository;

	@Override
	public List<ICountryDto> getListCountrys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected IBaseRepository<Country, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}


}
