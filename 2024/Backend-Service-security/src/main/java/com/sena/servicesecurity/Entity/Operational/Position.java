package com.sena.servicesecurity.Entity.Operational;

import com.sena.servicesecurity.Entity.ABaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="position")
public class Position extends ABaseEntity{

	@Column(name="code",length=150,nullable=false)
	private String code;
	
	@Column(name="name",length=150,nullable=false)
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
