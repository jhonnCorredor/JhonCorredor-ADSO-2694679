package com.sena.servicesecurity.IRepository.Operational;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.DTO.IClientDto;
import com.sena.servicesecurity.DTO.IPersonDto;
import com.sena.servicesecurity.Entity.Operational.Client;
import com.sena.servicesecurity.IRepository.IBaseRepository;

@Repository
public interface IClientRepository extends IBaseRepository<Client,Long>{

	@Query(value = "SELECT "
	        + "c.id, "
	        + "c.code, "
	        + "CONCAT(p.first_name, ' ', p.last_name) AS name, "
	        + "p.type_document, "
	        + "p.document, "
	        + "p.id AS person_id, "
	        + "c.state "
	        + "FROM "
	        + "client c "
	        + "INNER JOIN person AS p ON p.id = c.person_id "
	        + "WHERE "
	        + "c.deleted_at IS NULL", nativeQuery = true)
	List<IClientDto> getList();
	
	@Query(value = "SELECT\r\n"
			+ "\r\n"
			+ "    \r\n"
			+ "    `person`.`document`,\r\n"
			+ "   \r\n"
			+ "    `person`.`type_document`\r\n"
			+ "   \r\n"
			+ "FROM `service_security`.`person`\r\n"
			+ "where id = :id" , nativeQuery = true)
	IPersonDto getDocument(@Param("id") Long id);
		
		@Query(value="SELECT * FROM `service_security`.`client` WHERE person_id = :id", nativeQuery =true)
		Client consultClient(@Param("id") Long id);
		
		@Query(value = "SELECT *\r\n"
	    		+ "FROM `service_security`.`client`\r\n"
	    		+ "where person_id =:personId",nativeQuery = true )
	    Optional<Client> findByPersonId(@Param("personId") Long personId);
}
