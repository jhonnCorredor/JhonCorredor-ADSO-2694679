package com.sena.servicesecurity.Service.Operational;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.DTO.IEmployedDto;
import com.sena.servicesecurity.Entity.Operational.Employed;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.Operational.IEmployedRepository;
import com.sena.servicesecurity.IService.Operational.IEmployedService;
import com.sena.servicesecurity.Service.ABaseService;

@Service
public class EmployedService extends ABaseService<Employed> implements IEmployedService{

	@Override
	protected IBaseRepository<Employed, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Autowired
	private IEmployedRepository repository;

	@Override
	public List<IEmployedDto> getListEmployee() {
		
		return repository.getListEmployee();
	}

	@Override
	public Employed save(Employed entity) throws Exception {
		try {
			String document = repository.getDocument(entity.getPerson().getId());
			String company = repository.getCompany(entity.getCompany().getId());
			// Obtener el año actual
			int currentYear = LocalDate.now().getYear();

			// Obtener los primeros 4 dígitos de document
			String documentPrefix = document.substring(0, Math.min(document.length(), 4));

			// Combinar los elementos para formar el código
			String code = currentYear + "-" + documentPrefix + "-" + company;

			
			entity.setCode(code);
            entity.setCreatedAt(LocalDateTime.now());
            entity.setCreatedBy((long)1); //Cuanto esté el loggin, se debe enviar el ID del usuario con Auth
            return getRepository().save(entity);
        } catch (Exception e) {
            // Captura la excepción
            throw new Exception("Error al guardar la entidad: " + e.getMessage());
        }
	}

	@Override
	public void update(Long id, Employed entity) throws Exception {
		Optional<Employed> op = getRepository().findById(id);

        if (op.isEmpty()) {
            throw new Exception("Registro no encontrado");
        } else if (op.get().getDeletedAt() != null) {
            throw new Exception("Registro inhabilitado");
        }

        String document = repository.getDocument(entity.getPerson().getId());
		String company = repository.getCompany(entity.getCompany().getId());
		// Obtener el año actual
		int currentYear = LocalDate.now().getYear();

		// Obtener los primeros 4 dígitos de document
		String documentPrefix = document.substring(0, Math.min(document.length(), 4));

		// Combinar los elementos para formar el código
		String code = currentYear + "-" + documentPrefix + "-" + company;
		
        Employed entityUpdate = op.get();

        String[] ignoreProperties = { "id", "createdAt", "deletedAt", "createdBy", "deletedBy" };
        BeanUtils.copyProperties(entity, entityUpdate, ignoreProperties);
        entityUpdate.setCode(code);
        entityUpdate.setUpdatedAt(LocalDateTime.now());
        entityUpdate.setUpdatedBy((long)1); //Cuanto esté el loggin, se debe enviar el ID del usuario con Auth
        getRepository().save(entityUpdate);
	}
	
	

}
