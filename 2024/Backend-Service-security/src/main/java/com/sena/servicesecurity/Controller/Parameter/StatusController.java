package com.sena.servicesecurity.Controller.Parameter;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.servicesecurity.Controller.ABaseController;
import com.sena.servicesecurity.Entity.Parameter.Status;
import com.sena.servicesecurity.IService.Operational.ICompanyService;
import com.sena.servicesecurity.IService.Parameter.IStatusService;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/status")
public class StatusController extends ABaseController<Status,IStatusService>{

	

	protected StatusController(IStatusService service) {
		super(service, "Status");
		// TODO Auto-generated constructor stub
	}

}
