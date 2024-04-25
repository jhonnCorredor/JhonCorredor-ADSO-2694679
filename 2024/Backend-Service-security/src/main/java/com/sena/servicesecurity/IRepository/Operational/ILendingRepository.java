package com.sena.servicesecurity.IRepository.Operational;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sena.servicesecurity.DTO.ILendingDto;
import com.sena.servicesecurity.Entity.Operational.Lending;
import com.sena.servicesecurity.IRepository.IBaseRepository;

@Repository
public interface ILendingRepository extends IBaseRepository<Lending,Long>{

	@Query(value = "SELECT \r\n"
			+ "Lending.*,\r\n"
			+ "b.title as book,\r\n"
			+ "pc.first_name as client,\r\n"
			+ "pe.first_name as employed\r\n"
			+ "FROM Lending\r\n"
			+ "INNER JOIN book b ON b.id = Lending.book_id\r\n"
			+ "INNER JOIN client c ON c.id = Lending.client_id\r\n"
			+ "INNER JOIN employed e ON e .id = Lending.employed_id\r\n"
			+ "INNER JOIN person pc ON pc.id = c.person_id\r\n"
			+ "INNER JOIN person pe ON pe.id = e.person_id\r\n"
			+ "WHERE client_id = :clientId", nativeQuery = true)
	List<ILendingDto> getListBookClient(@Param("clientId") Long clientId);
	
}
