package com.sena.servicesecurity.Controller.Operational;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.servicesecurity.Controller.ABaseController;
import com.sena.servicesecurity.DTO.ApiResponseDto;
import com.sena.servicesecurity.DTO.IEmployedDto;
import com.sena.servicesecurity.Entity.Operational.Employed;
import com.sena.servicesecurity.IService.Operational.IEmployedService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/employed")
public class EmployedController extends ABaseController<Employed,IEmployedService>{

	protected EmployedController(IEmployedService service) {
		super(service, "Employed");
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/list")
    public ResponseEntity<ApiResponseDto<List<IEmployedDto>>> show() {
        try {
            List<IEmployedDto> entity = service.getListEmployee();
            return ResponseEntity.ok(new ApiResponseDto<List<IEmployedDto>>("Registro encontrado", entity, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<IEmployedDto>>(e.getMessage(), null, false));
        }
    }
}
