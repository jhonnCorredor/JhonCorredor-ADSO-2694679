package Examen.ProyectoUbicacion.IService;

import java.util.List;
import java.util.Optional;

import Examen.ProyectoUbicacion.Entity.Departamento;
public interface IDepartamentoService {
	/**
	 * Método para consultar todo
	 * **/
	public List<Departamento> findAll();
	
	/**
	 * Método para consultar por id
	 * **/
	public Optional<Departamento> findById(Long id);
	
	
	/**
	 * Método para guardar
	 * **/
	public Departamento save(Departamento departamento);
	
	/**
	 * Método para modificar
	 * **/
	public void update(Departamento departamento, Long id);
	
	/**
	 * Método para eliminar
	 * **/
	public void delete(Long id);
	
	/**
	 * Método para eliminar lógico
	 * **/
	public void deletedAt(Long id);
}
