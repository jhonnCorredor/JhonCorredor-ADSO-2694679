package com.sena.servicesecurity.Controller.Operational;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sena.servicesecurity.Entity.Operational.Client;
import com.sena.servicesecurity.Entity.Security.Person;
import com.sena.servicesecurity.IService.Operational.IClientService;

import com.sena.servicesecurity.Controller.ABaseController;
import com.sena.servicesecurity.DTO.ApiResponseDto;
import com.sena.servicesecurity.DTO.IClientDto;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("v1/api/client")
public class ClientController extends ABaseController<Client,IClientService>{

	protected ClientController(IClientService service) {
		super(service, "Client");
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/list")
    public ResponseEntity<ApiResponseDto<List<IClientDto>>> show() {
        try {
            List<IClientDto> entity = service.getList();
            return ResponseEntity.ok(new ApiResponseDto<List<IClientDto>>("Registro encontrado", entity, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<IClientDto>>(e.getMessage(), null, false));
        }
		}
	
	   @PostMapping("/clientPerson")
	    public ResponseEntity<ApiResponseDto<Client>> save(@RequestBody Person entity) {
	        try {
	            return ResponseEntity.ok(new ApiResponseDto<Client>("Datos guardados", service.savePersonCustomer(entity), true));
	        } catch (Exception e) {
	            return ResponseEntity.internalServerError().body(new ApiResponseDto<Client>(e.getMessage(), null, false));
	        }
	    }
	    
}
