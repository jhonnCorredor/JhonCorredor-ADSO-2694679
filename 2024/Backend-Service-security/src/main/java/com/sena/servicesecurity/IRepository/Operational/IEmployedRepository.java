package com.sena.servicesecurity.IRepository.Operational;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.DTO.IEmployedDto;
import com.sena.servicesecurity.Entity.Operational.Employed;
import com.sena.servicesecurity.IRepository.IBaseRepository;

@Repository
public interface IEmployedRepository extends IBaseRepository<Employed,Long>{
	
	@Query( value = "SELECT \r\n"
			+ "em.code,\r\n"
			+ "em.id,\r\n"
			+ "concat(p.first_name,'  ',p.last_name) as person,\r\n"
			+ "ps.name AS position,\r\n"
			+ "cm.rs AS company\r\n"
			+ "FROM employed AS em\r\n"
			+ "INNER JOIN company AS cm ON em.company_id = cm.id\r\n"
			+ "INNER JOIN person AS p ON em.person_id = p.id\r\n"
			+ "INNER JOIN position AS ps ON em.position_id = ps.id", nativeQuery = true)
	List<IEmployedDto> getListEmployee();
	
	@Query( value = "SELECT \r\n"
			+ "p.document\r\n"
			+ "FROM person AS p\r\n"
			+ "WHERE p.id = :personId", nativeQuery = true)
	String getDocument(@Param("personId") Long personId);
	
	@Query( value = "SELECT \r\n"
			+ "c.nit\r\n"
			+ "FROM company AS c\r\n"
			+ "WHERE c.id = :companyId", nativeQuery = true)
	String getCompany(@Param("companyId") Long companyId);

}
