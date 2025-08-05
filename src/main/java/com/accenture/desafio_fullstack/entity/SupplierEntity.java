package com.accenture.desafio_fullstack.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "supplier")
public class SupplierEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String document;
	private String name;
	private String email;
	private String cep;
	private String rg;
	private String birthDate;

	@ManyToMany(mappedBy = "suppliers")
	@JsonIgnore
	private List<EnterpriseEntity> enterprises = new ArrayList<>();

	public SupplierEntity() {
	}

	public SupplierEntity(Long id, String document, String name, String email, String cep, String rg,
			String birthDate) {
		this.id = id;
		this.document = document;
		this.name = name;
		this.email = email;
		this.cep = cep;
		this.rg = rg;
		this.birthDate = birthDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public List<EnterpriseEntity> getEnterprises() {
		return enterprises;
	}

	public void setEnterprises(List<EnterpriseEntity> enterprises) {
		this.enterprises = enterprises;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
