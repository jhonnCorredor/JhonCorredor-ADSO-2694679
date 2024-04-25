package com.sena.servicesecurity.Controller.Operational;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sena.servicesecurity.Controller.ABaseController;
import com.sena.servicesecurity.Entity.Operational.Book;
import com.sena.servicesecurity.IService.Operational.IBookService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("v1/api/book")
public class BookController extends ABaseController<Book, IBookService>{

	protected BookController(IBookService service) {
		super(service, "Book");
		// TODO Auto-generated constructor stub
	}

}