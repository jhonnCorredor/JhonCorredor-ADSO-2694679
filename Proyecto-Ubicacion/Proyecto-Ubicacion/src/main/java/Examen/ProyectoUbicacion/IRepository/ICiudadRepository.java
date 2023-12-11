package Examen.ProyectoUbicacion.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import Examen.ProyectoUbicacion.Entity.Ciudad;


public interface ICiudadRepository extends JpaRepository<Ciudad, Long>{

}
