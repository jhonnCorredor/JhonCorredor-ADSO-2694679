package com.sena.servicesecurity.IRepository.Operational;

import org.springframework.stereotype.Repository;
import com.sena.servicesecurity.Entity.Operational.Book;
import com.sena.servicesecurity.IRepository.IBaseRepository;

@Repository
public interface IBookRepository extends IBaseRepository<Book,Long>{

}
