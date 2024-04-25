package com.sena.servicesecurity.Controller.Operational;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.servicesecurity.Controller.ABaseController;
import com.sena.servicesecurity.Entity.Operational.Position;
import com.sena.servicesecurity.IService.Operational.IPositionService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/position")
public class PositionController extends ABaseController<Position, IPositionService>{

	protected PositionController(IPositionService service) {
		super(service, "Position");
		// TODO Auto-generated constructor stub
	}

}
