package com.sena.servicesecurity.Controller.Parameter;
	
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.sena.servicesecurity.Controller.ABaseController;
import com.sena.servicesecurity.Entity.Parameter.Continent;
import com.sena.servicesecurity.IService.Parameter.IContinentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/continent")
public class ContinentController extends ABaseController<Continent,IContinentService>{

	public ContinentController(IContinentService service) {
        super(service, "Continent");
    }

	
}
