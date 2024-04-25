package com.sena.servicesecurity.IRepository.Operational;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.DTO.IContractDto;
import com.sena.servicesecurity.Entity.Operational.Contract;
import com.sena.servicesecurity.IRepository.IBaseRepository;

@Repository
public interface IContractRepository extends IBaseRepository<Contract,Long>{
	@Query( value = "SELECT\r\n"
			+ "c.id,\r\n"
			+ "c.code,\r\n"
			+ "c.date_start,\r\n"
			+ "c.date_ending,\r\n"
			+ "c.salary,\r\n"
			+ "c.object,\r\n"
			+ "cm.rs AS company,\r\n"
			+ "concat(p.first_name,'  ',p.last_name) as person \r\n"
			+ "\r\n"
			+ "\r\n"
			+ "FROM service_security.contract AS c\r\n"
			+ "INNER JOIN company AS cm ON c.company_id = cm.id\r\n"
			+ "INNER JOIN employed AS em ON c.employed_id = em.id\r\n"
			+ "INNER JOIN position AS ps ON em.position_id = ps.id\r\n"
			+ "INNER JOIN person AS p ON em.person_id = p.id\r\n", nativeQuery = true)
	List<IContractDto> GetListContract();
}
