package com.sena.servicesecurity.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.servicesecurity.DTO.ApiResponseDto;
import com.sena.servicesecurity.DTO.IModuleViewDto;
import com.sena.servicesecurity.Entity.ModuleView;
import com.sena.servicesecurity.IService.IModuleViewService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/module-view")
public class ModuleViewController extends ABaseController<ModuleView,IModuleViewService>{
	public ModuleViewController(IModuleViewService service) {
        super(service, "ModuleView");
    }
	
	@GetMapping("/list")
    public ResponseEntity<ApiResponseDto<List<IModuleViewDto>>> show() {
        try {
            List<IModuleViewDto> entity = service.getList();
            return ResponseEntity.ok(new ApiResponseDto<List<IModuleViewDto>>("Registro encontrado", entity, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<IModuleViewDto>>(e.getMessage(), null, false));
        }
	}
}
