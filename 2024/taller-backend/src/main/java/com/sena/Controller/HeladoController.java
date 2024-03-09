package com.sena.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.Entity.Helado;
import com.sena.IService.IHeladoService;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("v1/api/helado")
public class HeladoController extends ABaseController<Helado,IHeladoService>{

	public HeladoController(IHeladoService service) {
		super(service, "Helado");
	}

}
