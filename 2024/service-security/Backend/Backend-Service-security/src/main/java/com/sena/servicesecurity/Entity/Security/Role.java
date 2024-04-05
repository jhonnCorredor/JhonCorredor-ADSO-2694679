package com.sena.servicesecurity.Entity.Security;

import java.util.HashSet;
import java.util.Set;

import com.sena.servicesecurity.Entity.ABaseEntity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "role")
public class Role extends ABaseEntity {
    
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    
    @Column(name = "description", nullable = false)
    private String description;

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
	

	public Set<Module> getModule() {
		return module;
	}

	public void setModule(Set<Module> module) {
		this.module = module;
	}


	@NotNull
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "module_role", schema = "security", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "module_id"))
	private Set<Module> module = new HashSet();
}