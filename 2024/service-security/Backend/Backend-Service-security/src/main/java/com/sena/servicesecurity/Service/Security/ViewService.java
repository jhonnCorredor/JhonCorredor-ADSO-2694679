package com.sena.servicesecurity.Service.Security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.DTO.IViewDto;
import com.sena.servicesecurity.Entity.Security.View;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.Security.IViewRepository;
import com.sena.servicesecurity.IService.Security.IViewService;
import com.sena.servicesecurity.Service.ABaseService;

@Service
public class ViewService extends ABaseService<View> implements IViewService{

	@Override
	protected IBaseRepository<View, Long> getRepository() {
		return repository;
	}
	
	@Autowired
	private IViewRepository repository;

	@Override
	public List<IViewDto> getList() {
		return repository.getList();
	}
	
	
}