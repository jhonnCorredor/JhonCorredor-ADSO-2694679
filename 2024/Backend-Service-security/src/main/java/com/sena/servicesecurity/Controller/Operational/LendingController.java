package com.sena.servicesecurity.Controller.Operational;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sena.servicesecurity.DTO.ApiResponseDto;
import com.sena.servicesecurity.DTO.ILendingDto;
import com.sena.servicesecurity.Controller.ABaseController;
import com.sena.servicesecurity.Entity.Operational.Lending;
import com.sena.servicesecurity.IService.Operational.ILendingService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("v1/api/lending")
public class LendingController extends ABaseController<Lending, ILendingService>{

	protected LendingController(ILendingService service) {
		super(service, "Lending");
	}
	
    @GetMapping("/list/{id}")
    public ResponseEntity<ApiResponseDto<List<ILendingDto>>> ListBookClient(@PathVariable Long id) {
        try {
        	
        	List<ILendingDto> lending = service.getListBookClient(id);
            return ResponseEntity.ok(new ApiResponseDto<List<ILendingDto>>("Datos obtenidos", lending, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<ILendingDto>>(e.getMessage(), null, false));
        }
    }
    

}
