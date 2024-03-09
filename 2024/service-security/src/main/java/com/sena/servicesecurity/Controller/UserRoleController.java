package com.sena.servicesecurity.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.servicesecurity.DTO.ApiResponseDto;
import com.sena.servicesecurity.DTO.IUserRoleDto;
import com.sena.servicesecurity.Entity.UserRole;
import com.sena.servicesecurity.IService.IUserRoleService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/userRole")
public class UserRoleController extends ABaseController<UserRole,IUserRoleService>{
	public UserRoleController(IUserRoleService service) {
        super(service, "UserRole");
    }
	
	@GetMapping("/list")
    public ResponseEntity<ApiResponseDto<List<IUserRoleDto>>> show() {
        try {
            List<IUserRoleDto> entity = service.getList();
            return ResponseEntity.ok(new ApiResponseDto<List<IUserRoleDto>>("Registro encontrado", entity, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<IUserRoleDto>>(e.getMessage(), null, false));
        }
	}
}
