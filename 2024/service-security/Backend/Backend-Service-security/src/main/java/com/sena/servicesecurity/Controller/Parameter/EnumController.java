package com.sena.servicesecurity.Controller.Parameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.servicesecurity.IService.Parameter.IEnumService;
import com.sena.servicesecurity.Utils.Days;
import com.sena.servicesecurity.Utils.Months;
import com.sena.servicesecurity.Utils.Nomenclature;
import com.sena.servicesecurity.Utils.TypeDocument;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/enum")
public class EnumController {
	
	@Autowired
	private IEnumService service;
	
	@GetMapping("/nomenclature")
    public Nomenclature[] getDirections() {
        return service.getDirections();
    }
	
	@GetMapping("/type-document")
    public TypeDocument[] getTdocument() {
        return service.getTdocuments();
    }
	
	@GetMapping("/day")
    public Days[] getDay() {
        return service.getDias();
    }

	@GetMapping("/month")
    public Months[] getMonth() {
        return service.getMeses();
    }
}
