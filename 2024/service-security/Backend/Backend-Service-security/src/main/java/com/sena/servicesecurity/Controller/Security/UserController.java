package com.sena.servicesecurity.Controller.Security;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sena.servicesecurity.Controller.ABaseController;
import com.sena.servicesecurity.DTO.ApiResponseDto;
import com.sena.servicesecurity.DTO.IUserDto;
import com.sena.servicesecurity.Entity.Security.User;
import com.sena.servicesecurity.IService.Security.IUserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/user")
public class UserController extends ABaseController<User,IUserService>{
	public UserController(IUserService service) {
        super(service, "User");
    }
	
	
	
	@PostMapping("/login")
	public ResponseEntity<ApiResponseDto<Optional<IUserDto>>> show(@RequestBody Map<String, String> loginData) {
	    try {
	        String username = loginData.get("username");
	        String password = loginData.get("password");
	        
	        Optional<IUserDto> entity = service.getUserWithViews(username, password);
	        return ResponseEntity.ok(new ApiResponseDto<>("Registro encontrado", entity, true));
	    } catch (Exception e) {
	        return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, false));
	    }
	}

	
}
