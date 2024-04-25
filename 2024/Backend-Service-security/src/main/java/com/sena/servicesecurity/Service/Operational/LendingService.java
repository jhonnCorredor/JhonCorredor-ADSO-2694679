package com.sena.servicesecurity.Service.Operational;

import com.sena.servicesecurity.DTO.ILendingDto;
import com.sena.servicesecurity.Entity.Operational.Book;
import com.sena.servicesecurity.Entity.Operational.Lending;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.Operational.IBookRepository;
import com.sena.servicesecurity.IRepository.Operational.ILendingRepository;
import com.sena.servicesecurity.IService.Operational.ILendingService;
import com.sena.servicesecurity.Service.ABaseService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LendingService extends ABaseService<Lending> implements ILendingService{

	@Override
	protected IBaseRepository<Lending, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Autowired
	private ILendingRepository repository;

	@Autowired
	private IBookRepository bookRepository;

	@Override
	public Lending save(Lending entity) throws Exception {
	    try {
	        entity.setCreatedAt(LocalDateTime.now());
	        entity.setDate(LocalDateTime.now());
	        entity.setCreatedBy((long) 1); 
	        
	        Lending savedPrestamoLibro = getRepository().save(entity);
	        
	        Optional<Book> optionalLibro = bookRepository.findById(savedPrestamoLibro.getBook().getId());
	        
	        if (optionalLibro.isPresent()) {
	            Book libro = optionalLibro.get();
	            int nuevaCantidad;

	            if (!savedPrestamoLibro.getAction()) {
	                nuevaCantidad = libro.getAmount() + savedPrestamoLibro.getAmount();
	            } else {
	                if (savedPrestamoLibro.getAmount() <= libro.getAmount()) {
	                    nuevaCantidad = libro.getAmount() - savedPrestamoLibro.getAmount();
	                } else {
	                    throw new Exception("Cantidad de préstamo excede la cantidad de libros disponibles.");
	                }
	            }

	            libro.setAmount(nuevaCantidad);
	            bookRepository.save(libro);
	        } else {
	            throw new Exception("Libro no encontrado");
	        }

	        return savedPrestamoLibro;
	    } catch (Exception e) {
	        throw new Exception("Error al guardar la entidad: " + e.getMessage());
	    }
	}
		
    @Override
    public void update(Long id, Lending entity) throws Exception {
        Optional<Lending> op = getRepository().findById(id);
        if (op.isEmpty()) {
            throw new Exception("Registro no encontrado");
        } else if (op.get().getDeletedAt() != null) {
            throw new Exception("Registro inhabilitado");
        }
        Lending entityUpdate = op.get();
        
        Optional<Book> optionalLibro = bookRepository.findById(entityUpdate.getBook().getId());
        
        int cantidadInicial = entityUpdate.getAmount();
        int cantidadNueva = entity.getAmount();
        int cantidadLibro = cantidadInicial - cantidadNueva;
        
        if (optionalLibro.isPresent()) {
            Book libro = optionalLibro.get();
            int nuevaCantidad;
            
            if(entityUpdate.getAction() != entity.getAction()) {
            	int cantidadInicial2 = entityUpdate.getAmount();
            	cantidadInicial2 = cantidadInicial2 * (-2);
            	if (!entity.getAction()) {
            		nuevaCantidad= libro.getAmount() - cantidadInicial2;
            		
            		if(nuevaCantidad >= 0) {
            			libro.setAmount(nuevaCantidad);
            		}else {
                        throw new Exception("Cantidad de préstamo excede la cantidad de libros disponibles.");
                    }
            		
            }else {
        		nuevaCantidad= libro.getAmount() + cantidadInicial2;
        		if(nuevaCantidad >= 0) {
        			libro.setAmount(nuevaCantidad);
        		}else {
                    throw new Exception("Cantidad de préstamo excede la cantidad de libros disponibles.");
                }
            	}
            }
            if (!entity.getAction()) {
                nuevaCantidad = libro.getAmount() - cantidadLibro;
            } else {
                    nuevaCantidad = libro.getAmount() + cantidadLibro;
            }
    		if(nuevaCantidad >= 0) {
    			libro.setAmount(nuevaCantidad);
    		}else {
                throw new Exception("Cantidad de préstamo excede la cantidad de libros disponibles.");
            }
            bookRepository.save(libro);
        }
        else {
            throw new Exception("Libro no encontrado");
        }
        
        String[] ignoreProperties = { "id", "createdAt", "deletedAt", "createdBy", "deletedBy" };
        BeanUtils.copyProperties(entity, entityUpdate, ignoreProperties);
        entityUpdate.setUpdatedAt(LocalDateTime.now());
        entityUpdate.setUpdatedBy((long)1); //Cuanto esté el loggin, se debe enviar el ID del usuario con Auth
        getRepository().save(entityUpdate);
    }

	@Override
	public List<ILendingDto> getListBookClient(Long clientId) {
		return repository.getListBookClient(clientId);
	}

}
