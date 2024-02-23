package com.sena.servicesecurity.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "module")
public class Module extends ABaseEntity{

	@Column(name = "name", length = 50, nullable = false)
    private String name;
    
    @Column(name = "description", length = 50, nullable = false)
    private String description;
    
    @Column(name = "route", length = 50, nullable = false, unique = true)
    private String route;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}
     
}
