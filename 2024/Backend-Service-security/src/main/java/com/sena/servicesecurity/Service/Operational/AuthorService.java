package com.sena.servicesecurity.Service.Operational;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.Entity.Operational.Author;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.Operational.IAuthorRepository;
import com.sena.servicesecurity.IService.Operational.IAuthorService;
import com.sena.servicesecurity.Service.ABaseService;

@Service
public class AuthorService extends ABaseService<Author> implements IAuthorService{

	@Autowired
	private IAuthorRepository reposiroty;
	
	@Override
	protected IBaseRepository<Author, Long> getRepository() {
		return reposiroty;
	}

}
