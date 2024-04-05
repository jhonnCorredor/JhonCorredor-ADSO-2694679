package com.sena.servicesecurity.Entity.Operational;

import com.sena.servicesecurity.Entity.ABaseEntity;
import com.sena.servicesecurity.Entity.Parameter.Municipality;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "company")
public class Company extends ABaseEntity{

	@Column(name="nit", nullable= false)
	private String nit;
	
	@Column(name="rs", nullable= false)
	private String rs;
	
	@Column(name = "address", length = 100, nullable = false)
    private String address;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "municipality_id", nullable = false)
    private Municipality municipality;
	
	@Column(name = "web", length = 50, nullable = false, unique = true)
    private String web;
	
	@Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;
    
    @Column(name = "phone", length = 15, nullable = false)
    private String phone;

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getRs() {
		return rs;
	}

	public void setRs(String rs) {
		this.rs = rs;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Municipality getMunicipality() {
		return municipality;
	}

	public void setMunicipality(Municipality municipality) {
		this.municipality = municipality;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
    
    
}
