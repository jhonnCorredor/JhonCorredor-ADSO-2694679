package com.sena.servicesecurity.IRepository.Operational;

import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.Entity.Operational.Position;
import com.sena.servicesecurity.IRepository.IBaseRepository;

@Repository
public interface IPositionRepository extends IBaseRepository<Position,Long>{

}
