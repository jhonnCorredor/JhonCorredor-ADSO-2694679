package com.sena.servicesecurity.Controller.Parameter;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.servicesecurity.Controller.ABaseController;
import com.sena.servicesecurity.Entity.Operational.Position;
import com.sena.servicesecurity.Entity.Parameter.Municipality;
import com.sena.servicesecurity.IService.Parameter.IMunicipalityService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/municipality")
public class MunicipalityController extends ABaseController<Municipality,IMunicipalityService>{

	protected MunicipalityController(IMunicipalityService service) {
		super(service, "Municipality");
		// TODO Auto-generated constructor stub
	}

}
