package com.sena.servicesecurity.Controller.Operational;
import com.sena.servicesecurity.Controller.ABaseController;
import com.sena.servicesecurity.Entity.Operational.Author;
import com.sena.servicesecurity.IService.Operational.IAuthorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("v1/api/author")
public class AuthorController extends ABaseController<Author,IAuthorService>{

	protected AuthorController(IAuthorService service) {
		super(service, "Author");
	}

}
