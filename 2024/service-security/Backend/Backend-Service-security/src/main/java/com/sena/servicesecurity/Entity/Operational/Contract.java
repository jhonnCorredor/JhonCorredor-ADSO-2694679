package com.sena.servicesecurity.Entity.Operational;

import java.time.LocalDate;

import com.sena.servicesecurity.Entity.ABaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="contract")
public class Contract extends ABaseEntity{

	@Column(name="code",length=150, nullable= false)
	private String code;
	
	@Column(name = "date_start", nullable = false)
    private LocalDate dateStart;
	
	@Column(name = "date_ending", nullable = false)
    private LocalDate dateEnding;
	
	@Column(name="salary",nullable =false)
	private Double salary;
	
	@Column(name="object",nullable =false)
	private String object;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "company_id", nullable = false)
    private Company company;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "employed_id", nullable = false)
    private Employed employed;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LocalDate getDateStart() {
		return dateStart;
	}

	public void setDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}

	public LocalDate getDateEnding() {
		return dateEnding;
	}

	public void setDateEnding(LocalDate dateEnding) {
		this.dateEnding = dateEnding;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Employed getEmployed() {
		return employed;
	}

	public void setEmployed(Employed employed) {
		this.employed = employed;
	}
	
}
