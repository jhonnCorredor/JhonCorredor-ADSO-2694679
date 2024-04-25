package com.sena.servicesecurity.Entity.Operational;

import com.sena.servicesecurity.Entity.ABaseEntity;
import com.sena.servicesecurity.Entity.Security.Person;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="book")
public class Book extends ABaseEntity{

	@Column(name="title", nullable = true)
	private String title;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "author_id", nullable = false)
    private Author author;
	
	@Column(name="code", nullable = true)
	private String code;
	
	@Column(name="amount", nullable = true)
	private int amount;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
}
