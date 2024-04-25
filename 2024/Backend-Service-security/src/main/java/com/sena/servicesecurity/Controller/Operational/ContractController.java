package com.sena.servicesecurity.Controller.Operational;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.servicesecurity.Controller.ABaseController;
import com.sena.servicesecurity.DTO.ApiResponseDto;
import com.sena.servicesecurity.DTO.IContractDto;
import com.sena.servicesecurity.Entity.Operational.Contract;
import com.sena.servicesecurity.IService.Operational.IContractService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/contract")
public class ContractController extends ABaseController<Contract,IContractService>{

	protected ContractController(IContractService service) {
		super(service, "Contract");
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/list")
    public ResponseEntity<ApiResponseDto<List<IContractDto>>> show() {
        try {
            List<IContractDto> entity = service.GetListContract();
            return ResponseEntity.ok(new ApiResponseDto<List<IContractDto>>("Registro encontrado", entity, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<IContractDto>>(e.getMessage(), null, false));
        }
    }
}
