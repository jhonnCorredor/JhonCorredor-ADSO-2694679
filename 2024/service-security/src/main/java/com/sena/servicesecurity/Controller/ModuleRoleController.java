package com.sena.servicesecurity.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.servicesecurity.DTO.ApiResponseDto;
import com.sena.servicesecurity.DTO.IModuleRoleDto;
import com.sena.servicesecurity.Entity.ModuleRole;
import com.sena.servicesecurity.IService.IModuleRoleService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/module-role")
public class ModuleRoleController extends ABaseController<ModuleRole,IModuleRoleService>{
	public ModuleRoleController(IModuleRoleService service) {
        super(service, "ModuleRole");
    }
	
	@GetMapping("/list")
    public ResponseEntity<ApiResponseDto<List<IModuleRoleDto>>> show() {
        try {
            List<IModuleRoleDto> entity = service.getList();
            return ResponseEntity.ok(new ApiResponseDto<List<IModuleRoleDto>>("Registro encontrado", entity, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<IModuleRoleDto>>(e.getMessage(), null, false));
        }
	}
}
