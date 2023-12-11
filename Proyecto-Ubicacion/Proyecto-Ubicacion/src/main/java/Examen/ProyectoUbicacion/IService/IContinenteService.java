package Examen.ProyectoUbicacion.IService;

import java.util.List;
import java.util.Optional;

import Examen.ProyectoUbicacion.Entity.Continente;


public interface IContinenteService {

	/**
	 * Método para consultar todo
	 * **/
	public List<Continente> findAll();
	
	/**
	 * Método para consultar por id
	 * **/
	public Optional<Continente> findById(Long id);
	
	
	/**
	 * Método para guardar
	 * **/
	public Continente save(Continente continente);
	
	/**
	 * Método para modificar
	 * **/
	public void update(Continente continente, Long id);
	
	/**
	 * Método para eliminar
	 * **/
	public void delete(Long id);
	
	/**
	 * Método para eliminar lógico
	 * **/
	public void deletedAt(Long id);
}
