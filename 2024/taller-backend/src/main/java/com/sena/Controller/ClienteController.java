package com.sena.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.Entity.Cliente;
import com.sena.IService.IClienteService;;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("v1/api/cliente")
public class ClienteController extends ABaseController<Cliente,IClienteService>{
	
	public ClienteController(IClienteService service) {
        super(service, "Module");
    }

}
