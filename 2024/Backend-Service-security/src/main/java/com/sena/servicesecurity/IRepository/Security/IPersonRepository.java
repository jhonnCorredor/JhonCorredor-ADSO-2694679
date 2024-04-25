package com.sena.servicesecurity.IRepository.Security;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.DTO.IPersonDto;
import com.sena.servicesecurity.Entity.Security.Person;
import com.sena.servicesecurity.IRepository.IBaseRepository;


@Repository
public interface IPersonRepository extends IBaseRepository<Person, Long>{


		@Query(value = " SELECT  "
				+ " id, "
				+ " concat(first_name,'  ',last_name) as person, "
				+ " type_document, "
				+ " document "
				+ "	FROM  "
				+ "	person "
				+ "	WHERE  "
				+ " deleted_at IS NULL", nativeQuery = true)
		List<IPersonDto> getList();
		
		@Query(value = " SELECT  "
				+ " id, "
				+ " concat(first_name,'  ',last_name) as person "
				+ "	FROM  "
				+ "	person "
				+ "	WHERE  "
				+ " deleted_at IS NULL", nativeQuery = true)
		List<Object[]> getDList();
		
		@Query(value = "SELECT "
	            + "p.id, "
	            + "CONCAT(p.first_name, ' ', p.last_name) AS person, "
	            + "p.document "
	            + "FROM "
	            + "person p "
	            + "LEFT JOIN client c ON p.id = c.person_id "
	            + "WHERE "
	            + "p.type_document = :type AND "
	            + "c.person_id IS NULL AND "
	            + "p.deleted_at IS NULL", nativeQuery = true)
		List<IPersonDto> getTypeDocument(@Param("type") String type);
		
		@Query(value = "SELECT p.id, " 
				+ "CONCAT(p.first_name, ' ', p.last_name) AS person "
				+"FROM person AS p " 
				+"WHERE p.document = :document",nativeQuery = true)
		IPersonDto getValidationDocument(@Param("document") String document);
		
		@Query(value = "SELECT p.id, " 
				+ "CONCAT(p.first_name, ' ', p.last_name) AS person "
				+"FROM person AS p " 
				+"WHERE "
				+"p.email = :email",nativeQuery = true)
		IPersonDto getValidationEmail(@Param("email") String email);
}
