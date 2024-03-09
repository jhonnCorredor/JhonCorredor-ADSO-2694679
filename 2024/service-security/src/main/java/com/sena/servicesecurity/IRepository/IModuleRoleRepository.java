package com.sena.servicesecurity.IRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.DTO.IModuleRoleDto;
import com.sena.servicesecurity.Entity.ModuleRole;

@Repository
public interface IModuleRoleRepository extends IBaseRepository<ModuleRole, Long>{

	
	@Query(value = "SELECT "
			+ "mr.id AS id, "
			+ "m.name AS module, "
			+ "r.name AS role, "
			+ "mr.state AS state " +
            "FROM module_role mr " +
            "INNER JOIN module m ON m.id = mr.module_id " +
            "INNER JOIN role r ON r.id = mr.role_id " +
            "WHERE mr.deleted_at IS NULL",
    nativeQuery = true)
		List<IModuleRoleDto> getList();
	
	@Query(value = "SELECT "
			+ "mr.id AS id, "
			+ "m.name AS module, "
			+ "r.name AS role, "
			+ "mr.state AS state " +
            "FROM module_role mr " +
            "INNER JOIN module m ON m.id = mr.module_id " +
            "INNER JOIN role r ON r.id = mr.role_id " +
            "WHERE mr.deleted_at IS NULL",
    nativeQuery = true)
	List<Object[]> getDList();
}
