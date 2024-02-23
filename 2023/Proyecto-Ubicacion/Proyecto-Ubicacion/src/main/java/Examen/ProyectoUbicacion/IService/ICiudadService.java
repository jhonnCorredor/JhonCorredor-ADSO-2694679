package Examen.ProyectoUbicacion.IService;

import java.util.List;
import java.util.Optional;

import Examen.ProyectoUbicacion.Entity.Ciudad;


public interface ICiudadService {
	/**
	 * Método para consultar todo
	 * **/
	public List<Ciudad> findAll();
	
	/**
	 * Método para consultar por id
	 * **/
	public Optional<Ciudad> findById(Long id);
	
	
	/**
	 * Método para guardar
	 * **/
	public Ciudad save(Ciudad ciudad);
	
	/**
	 * Método para modificar
	 * **/
	public void update(Ciudad ciudad, Long id);
	
	/**
	 * Método para eliminar
	 * **/
	public void delete(Long id);
	
	/**
	 * Método para eliminar lógico
	 * **/
	public void deletedAt(Long id);
}
