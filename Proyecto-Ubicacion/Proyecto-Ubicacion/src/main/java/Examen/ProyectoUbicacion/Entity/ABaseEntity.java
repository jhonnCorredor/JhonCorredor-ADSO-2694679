package Examen.ProyectoUbicacion.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ABaseEntity {
	
	@Column(name = "estado", nullable = false)
	private Boolean estado;
	
	@Column(name = "fecha_creacion", nullable = true)
	private LocalDateTime fechaCreacion;
	
	@Column(name = "fecha_modificacion", nullable = true)
	private LocalDateTime fechaModificacion;
	
	@Column(name = "fecha_eliminacion", nullable = true)
	private LocalDateTime fechaEliminacion;

	@Column(name = "usario_creacion", nullable = true)
	private LocalDateTime usarioCreacion;
	
	@Column(name = "usario_modificacion", nullable = true)
	private LocalDateTime usarioModificacion;
	
	@Column(name = "usario_eliminacion", nullable = true)
	private LocalDateTime usarioEliminacion;

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(LocalDateTime fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public LocalDateTime getFechaEliminacion() {
		return fechaEliminacion;
	}

	public void setFechaEliminacion(LocalDateTime fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}

	public LocalDateTime getUsarioCreacion() {
		return usarioCreacion;
	}

	public void setUsarioCreacion(LocalDateTime usarioCreacion) {
		this.usarioCreacion = usarioCreacion;
	}

	public LocalDateTime getUsarioModificacion() {
		return usarioModificacion;
	}

	public void setUsarioModificacion(LocalDateTime usarioModificacion) {
		this.usarioModificacion = usarioModificacion;
	}

	public LocalDateTime getUsarioEliminacion() {
		return usarioEliminacion;
	}

	public void setUsarioEliminacion(LocalDateTime usarioEliminacion) {
		this.usarioEliminacion = usarioEliminacion;
	}


}
