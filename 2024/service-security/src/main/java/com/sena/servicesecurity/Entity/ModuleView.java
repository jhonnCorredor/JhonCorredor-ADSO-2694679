package com.sena.servicesecurity.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "module_view")
public class ModuleView extends ABaseEntity{
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "module_id", nullable = false)
    private User module;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "view_id", nullable = false)
    private Role view;

	public User getModule() {
		return module;
	}

	public void setModule(User module) {
		this.module = module;
	}

	public Role getView() {
		return view;
	}

	public void setView(Role view) {
		this.view = view;
	}

	  
}