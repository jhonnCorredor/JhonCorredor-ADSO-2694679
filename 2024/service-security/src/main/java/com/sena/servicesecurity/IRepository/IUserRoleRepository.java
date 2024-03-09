package com.sena.servicesecurity.IRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.DTO.IUserRoleDto;
import com.sena.servicesecurity.Entity.UserRole;

@Repository
public interface IUserRoleRepository extends IBaseRepository<UserRole, Long>{

	@Query(value = "SELECT"
			+ " ur.id AS id,"
			+ " u.username AS user,"
			+ " r.name AS role,"
			+ " ur.state AS state " +
            "FROM user_role ur " +
            "INNER JOIN user u ON u.id = ur.user_id " +
            "INNER JOIN role r ON r.id = ur.role_id " +
            "WHERE ur.deleted_at IS NULL",nativeQuery = true)
		List<IUserRoleDto> getList();
	
	@Query(value = "SELECT"
			+ " ur.id AS id,"
			+ " u.username AS user,"
			+ " r.name AS role,"
			+ " ur.state AS state " +
            "FROM user_role ur " +
            "INNER JOIN user u ON u.id = ur.user_id " +
            "INNER JOIN role r ON r.id = ur.role_id " +
            "WHERE ur.deleted_at IS NULL",nativeQuery = true)
	List<Object[]> getDList();
}
