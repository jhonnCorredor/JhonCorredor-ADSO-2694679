package com.sena.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;

import com.sena.Entity.ABaseEntity;
import com.sena.IRepository.IBaseRepository;
import com.sena.IService.IBaseService;

public abstract class ABaseService<T extends ABaseEntity> implements IBaseService<T>{

	protected abstract IBaseRepository<T,Long> getRepository();
	
	@Override
	public List<T> All() throws Exception {
		return getRepository().findAll();
	}

	@Override
	public Optional<T> FindBy(Long id) throws Exception {
		Optional<T> op = getRepository().findById(id);
		
		if(op.isEmpty()) {
			throw new Exception("Registro no Encontrado");
		}
		return op;
	}

	@Override
	public T Save(T entity) throws Exception {
		try {
			entity.setCreatedAt(LocalDateTime.now());
			entity.setCreatedBy((long)1); 		
			return getRepository().save(entity);
			}catch (Exception e){
				throw new Exception("Registro no Encontrado");
			}
	}

	@Override
	public void Deleted(Long id) throws Exception {
		Optional<T> op = getRepository().findById(id);
		
		if(op.isEmpty()) {
			throw new Exception("Registro no Encontrado");
		}
		
		T entityUpdate = op.get();
        entityUpdate.setDeletedAt(LocalDateTime.now());
        entityUpdate.setDeletedBy((long)1);
        
        getRepository().save(entityUpdate);
	}

	@Override
	public void Updated(T entity,Long id) throws Exception {
		Optional<T> op = getRepository().findById(id);
		
		if(op.isEmpty()) {
			throw new Exception("Registro no Encontrado");
		}else if (op.get().getDeletedAt() != null) {
            throw new Exception("Registro inhabilitado");
        }
		
		T entityUpdate = op.get();

        String[] ignoreProperties = { "id", "createdAt", "deletedAt", "createdBy", "deletedBy" };
        BeanUtils.copyProperties(entity, entityUpdate, ignoreProperties);
        entityUpdate.setUpdateAt(LocalDateTime.now());
        entityUpdate.setUpdateBy((long)1);
        getRepository().save(entityUpdate);
	}	
}
