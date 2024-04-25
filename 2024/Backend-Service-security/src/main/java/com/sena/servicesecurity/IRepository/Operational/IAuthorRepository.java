package com.sena.servicesecurity.IRepository.Operational;
import org.springframework.stereotype.Repository;
import com.sena.servicesecurity.Entity.Operational.Author;
import com.sena.servicesecurity.IRepository.IBaseRepository;

@Repository
public interface IAuthorRepository extends IBaseRepository<Author,Long>{

}
