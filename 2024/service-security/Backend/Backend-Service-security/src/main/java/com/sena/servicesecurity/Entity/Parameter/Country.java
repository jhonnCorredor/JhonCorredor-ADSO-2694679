package com.sena.servicesecurity.Entity.Parameter;

import org.hibernate.annotations.Collate;

import com.sena.servicesecurity.Entity.ABaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "country")
public class Country extends ABaseEntity{

	
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    
    @Column(name = "code", length = 50, nullable = false)
    private String code;
    
    
    @Column(name = "description", length = 50, nullable = false)
    private String description;
    
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
   	@JoinColumn(name = "continent_id", nullable = false)
       private Continent continent;
    
    
    

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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

	




	
 
  
}
