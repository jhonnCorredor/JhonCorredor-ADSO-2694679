package com.sena.servicesecurity.IRepository.Security;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.sena.servicesecurity.DTO.IModuleDto;
import com.sena.servicesecurity.Entity.Security.Module;
import com.sena.servicesecurity.IRepository.IBaseRepository;

public interface IModuleRepository extends IBaseRepository<Module, Long>{

	@Query(value = " SELECT "
			+ "	id,"
			+ "	name as module,"
			+ " route, "
			+ " description, "
			+ " state "
			+ "	FROM "
			+ "	module "
			+ "	WHERE "
			+ " deleted_at IS NULL", nativeQuery = true)
	List<IModuleDto> getList();	
	
	@Query(value = " SELECT "
			+ "	id,"
			+ "	name as module,"
			+ " route, "
			+ " description, "
			+ " state "
			+ "	FROM "
			+ "	module "
			+ "	WHERE "
			+ " deleted_at IS NULL", nativeQuery = true)
	List<Object[]> getDList();
	
}
