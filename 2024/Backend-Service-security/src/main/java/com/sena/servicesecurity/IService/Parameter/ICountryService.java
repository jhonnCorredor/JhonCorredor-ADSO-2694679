package com.sena.servicesecurity.IService.Parameter;

import java.util.List;

import com.sena.servicesecurity.DTO.ICountryDto;
import com.sena.servicesecurity.Entity.Parameter.Country;
import com.sena.servicesecurity.IService.IBaseService;

public interface ICountryService  extends IBaseService<Country>{
	List<ICountryDto> getListCountrys();
}
