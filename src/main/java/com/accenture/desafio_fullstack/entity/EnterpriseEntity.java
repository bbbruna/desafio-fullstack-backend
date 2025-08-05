package com.accenture.desafio_fullstack.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "enterprise")
public class EnterpriseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String cnpj;
	private String name;
	private String cep;

	@ManyToMany
	@JoinTable(name = "enterprise_supplier", joinColumns = @JoinColumn(name = "enterprise_id"), inverseJoinColumns = @JoinColumn(name = "supplier_id"))
	private List<SupplierEntity> suppliers = new ArrayList<>();

	public EnterpriseEntity() {
	}

	public EnterpriseEntity(Long id, String cnpj, String name, String cep) {
		this.id = id;
		this.cnpj = cnpj;
		this.name = name;
		this.cep = cep;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public List<SupplierEntity> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<SupplierEntity> suppliers) {
		this.suppliers = suppliers;
	}

	public void addSupplier(SupplierEntity supplier) {
		this.suppliers.add(supplier);
	}

	public void removeSupplier(SupplierEntity supplier) {
		this.suppliers.remove(supplier);
	}
}
