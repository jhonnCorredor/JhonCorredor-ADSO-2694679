package com.sena.servicesecurity.Service.Operational;

import com.sena.servicesecurity.Entity.Operational.Book;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.Operational.IBookRepository;
import com.sena.servicesecurity.IService.Operational.IBookService;
import com.sena.servicesecurity.Service.ABaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService extends ABaseService<Book> implements IBookService{

	@Override
	protected IBaseRepository<Book, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Autowired
	private IBookRepository repository;

}
