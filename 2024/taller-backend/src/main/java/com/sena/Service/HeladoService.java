package com.sena.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.Entity.Helado;
import com.sena.IRepository.IBaseRepository;
import com.sena.IRepository.IHeladoRepository;
import com.sena.IService.IHeladoService;

@Service
public class HeladoService extends ABaseService<Helado> implements IHeladoService{

	@Override
	protected IBaseRepository<Helado, Long> getRepository() {
		return repository;
	}
	
	@Autowired
	public IHeladoRepository repository;

}
