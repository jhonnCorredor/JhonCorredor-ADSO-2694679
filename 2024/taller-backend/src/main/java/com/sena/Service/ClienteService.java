	package com.sena.Service;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	
	import com.sena.Entity.Cliente;
	import com.sena.IRepository.IBaseRepository;
	import com.sena.IRepository.IClienteRepository;
import com.sena.IService.IClienteService;
	
	@Service
	public class ClienteService extends ABaseService<Cliente> implements IClienteService{
	
		@Override
		protected IBaseRepository<Cliente, Long> getRepository() {
			return repository;
		}
		
		@Autowired
		public IClienteRepository repository;
	
	}
