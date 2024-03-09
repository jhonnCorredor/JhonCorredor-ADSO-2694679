package com.sena.IRepository;

import org.springframework.stereotype.Repository;

import com.sena.Entity.Cliente;

@Repository
public interface IClienteRepository extends IBaseRepository<Cliente,Long>{
	
}
