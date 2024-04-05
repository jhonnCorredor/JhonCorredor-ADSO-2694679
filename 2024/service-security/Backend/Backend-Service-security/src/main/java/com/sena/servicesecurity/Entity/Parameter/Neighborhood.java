package com.sena.servicesecurity.Entity.Parameter;

import com.sena.servicesecurity.Entity.ABaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "neighborhood")
public class Neighborhood extends ABaseEntity {

	  @Column(name = "name", nullable = false, unique = true)
	    private String name;
	    
	@Column(name = "code", nullable = false)
	    private String code;
	
	@Column(name = "description", nullable = false)
  private String description;
	
	
	 @ManyToOne(fetch = FetchType.EAGER, optional = false)
	   	@JoinColumn(name = "Location_id", nullable = false)
	       private Location Location;
	    

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Location getLocation() {
		return Location;
	}

	public void setLocation(Location location) {
		Location = location;
	}
	
	

}
