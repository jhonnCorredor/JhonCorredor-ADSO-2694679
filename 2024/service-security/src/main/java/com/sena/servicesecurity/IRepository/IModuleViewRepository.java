package com.sena.servicesecurity.IRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.DTO.IModuleViewDto;
import com.sena.servicesecurity.Entity.ModuleView;

@Repository
public interface IModuleViewRepository extends IBaseRepository<ModuleView, Long>{

	@Query(value = "SELECT"
			+ " mv.id AS id,"
			+ " m.name AS module,"
			+ " v.name AS view,"
			+ " mv.state AS state " +
            "FROM module_view mv " +
            "INNER JOIN module m ON m.id = mv.module_id " +
            "INNER JOIN view v ON v.id = mv.view_id " +
            "WHERE mv.deleted_at IS NULL",
    nativeQuery = true)
	List<IModuleViewDto> getList();
	
	@Query(value = "SELECT"
			+ " mv.id AS id,"
			+ " m.name AS module,"
			+ " v.name AS view,"
			+ " mv.state AS state " +
            "FROM module_view mv " +
            "INNER JOIN module m ON m.id = mv.module_id " +
            "INNER JOIN view v ON v.id = mv.view_id " +
            "WHERE mv.deleted_at IS NULL",
    nativeQuery = true)
	List<Object[]> getDList();
}
