package com.sena.servicesecurity.Entity.Security;

import java.time.LocalDate;

import com.sena.servicesecurity.Entity.ABaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class Person extends ABaseEntity {
    
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;
    
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;
    
    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;
    
    @Column(name = "phone", length = 15, nullable = false)
    private String phone;
    
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;
    
    @Column(name = "gender", length = 10, nullable = false)
    private String gender;
    
    @Column(name = "address", length = 100, nullable = false)
    private String address;
    
 
    
    @Column(name = "type_document", length = 50, nullable = false)
    private String typeDocument;
    
    @Column(name = "document", length = 10, nullable = false, unique=true)
    private String Document;
    
    @Column(name = "ubication", nullable = false)
    private String ubication;

	public String getUbication() {
		return ubication;
	}

	public void setUbication(String ubication) {
		this.ubication = ubication;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTypeDocument() {
		return typeDocument;
	}
	
	public void setTypeDocument(String typeDocument) {
		this.typeDocument = typeDocument;
	}

	public String getDocument() {
		return Document;
	}

	public void setDocument(String document) {
		Document = document;
	}  
	
}
