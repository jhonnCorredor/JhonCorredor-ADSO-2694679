package com.sena.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "helado")
public class Helado extends ABaseEntity{

	@Column(name = "sabor", length = 50, nullable = false)
	public String sabor;
	
	@Column(name = "precio", nullable = false)
	public Double precio;
	
	@Column(name = "cantidad", nullable = false)
	public int cantidad;

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
