package com.sena.servicesecurity.Controller.Parameter;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.sena.servicesecurity.Controller.ABaseController;
import com.sena.servicesecurity.DTO.ApiResponseDto;
import com.sena.servicesecurity.DTO.IDepartmentDto;
import com.sena.servicesecurity.Entity.Parameter.Neighborhood;
import com.sena.servicesecurity.IService.Parameter.INeighborhoodService;
import com.sena.servicesecurity.IService.Parameter.IStatusService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/neighborhood")
public class NeighborhoodController extends ABaseController<Neighborhood,INeighborhoodService>{
	public NeighborhoodController(INeighborhoodService service) {
        super(service, "Neighborhood");
    }
	

}
