package com.sena.IService;

import java.util.List;
import java.util.Optional;

import com.sena.Entity.ABaseEntity;

public interface IBaseService <T extends ABaseEntity>{
	
	List<T> All() throws Exception;
	Optional<T> FindBy(Long id) throws Exception;
	T Save(T entity) throws Exception;
	void Deleted(Long id) throws Exception;
	void Updated(T entity,Long id) throws Exception;

}
