package com.sena.servicesecurity.IRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.DTO.IUserDto;
import com.sena.servicesecurity.DTO.IViewDto;
import com.sena.servicesecurity.Entity.User;

@Repository
public interface IUserRepository extends IBaseRepository<User, Long>{
	
	@Query(value = " SELECT \r\n"
			+ "u.id,	\r\n"
			+ "u.username user, \r\n"
			+ "CONCAT(p.first_name,' ',p.last_name) personName, \r\n"
			+ "p.email personEmail, \r\n"
			+ "u.state,\r\n"
			+ "v.route\r\n"
			+ "FROM user u \r\n"
			+ "INNER JOIN person p ON p.id = u.person_id\r\n"
			+ "INNER JOIN user_role ur ON ur.user_id = u.id \r\n"
			+ "INNER JOIN role r ON r.id = ur.role_id \r\n"
			+ "INNER JOIN module_role mr ON mr.role_id = r.id\r\n"
			+ "INNER JOIN module m ON mr.module_id = m.id\r\n"
			+ "INNER JOIN module_view mv ON mv.module_id = m.id\r\n"
			+ "INNER JOIN view v ON mv.view_id = v.id\r\n"
					+ "WHERE "
					+ "	u.username = :username AND "
					+ " u.password = :password  ", nativeQuery = true)
			Optional<IUserDto> getLogin(String username, String password);
	
	
	
			@Query(value = "use service_security;\r\n"
			+ "\r\n"
			+ "SELECT \r\n"
			+ "v.description,\r\n"
			+ "v.name,\r\n"
			+ "v.route\r\n"
			+ "\r\n"
			+ "\r\n"
			+ "FROM view v\r\n"
			+ "INNER JOIN module_view mv ON mv.view_id = v.id\r\n"
			+ "INNER JOIN module m ON mv.module_id = m.id \r\n"
			+ "INNER JOIN module_role mr ON mr.module_id = m.id\r\n"
			+ "INNER JOIN role r ON r.id = mr.role_id\r\n"
			+ "\r\n"
			+ "WHERE \r\n"
			+ "r.id = :id  ", nativeQuery = true)
			List<IViewDto> getRutas(Long id);
	
	
	@Query(value = " SELECT "
			+ " u.id,	"
			+ " u.username user, "
			+ " CONCAT(p.first_name,' ',p.last_name) personName, "
			+ " p.email personEmail, "
			+ " u.state "
			+ "FROM "
			+ "	user u "
			+ "INNER JOIN person p ON p.id = u.person_id ", nativeQuery = true)
	List<IUserDto> getList();
	
	@Query(value = " SELECT "
			+ " u.id,	"
			+ " u.username user, "
			+ " CONCAT(p.first_name,' ',p.last_name) personName, "
			+ " p.email personEmail, "
			+ " u.state "
			+ "FROM "
			+ "	user u "
			+ "INNER JOIN person p ON p.id = u.person_id ", nativeQuery = true)
	List<Object[]> getDList();



}
