package com.sena.servicesecurity.Controller.Parameter;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.sena.servicesecurity.Controller.ABaseController;
import com.sena.servicesecurity.DTO.ApiResponseDto;
import com.sena.servicesecurity.DTO.ICountryDto;
import com.sena.servicesecurity.DTO.IRoleDto;
import com.sena.servicesecurity.Entity.Parameter.Country;
import com.sena.servicesecurity.IService.Parameter.ICountryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/country")
public class CountryController extends ABaseController<Country,ICountryService>{
	public CountryController(ICountryService service) {
        super(service, "Country");
    }


}
