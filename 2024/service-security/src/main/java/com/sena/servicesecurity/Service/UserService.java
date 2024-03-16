package com.sena.servicesecurity.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.DTO.IUserDto;
import com.sena.servicesecurity.DTO.IViewDto;
import com.sena.servicesecurity.Entity.User;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.IUserRepository;
import com.sena.servicesecurity.IService.IUserService;

@Service
public class UserService extends ABaseService<User> implements IUserService{

	@Override
	protected IBaseRepository<User, Long> getRepository() {
		return repository;
	}
	
	@Autowired
	private IUserRepository repository;

	@Override
	public Optional<IUserDto> getLogin(String username, String password) {
		
        Optional<IUserDto> userDtoOptional = repository.getLogin(username, password);

        if (userDtoOptional.isPresent()) {
            IUserDto dto = userDtoOptional.get();
            // Obtener las rutas del usuario
            List<IViewDto> rutas = repository.getRutas(dto.getId());
            // Establecer las rutas en el DTO de usuario
            dto.setRutas(rutas);
            return Optional.of(dto);
        } else {
            return Optional.empty();
        }
        //return repository.getLogin(username, password);
    }
	

	@Override
	public List<IUserDto> getList() {
		return repository.getList();
	}

	@Override
	public List<IViewDto> getRutas(Long id) {
		// TODO Auto-generated method stub
		return null;
	}	
}
