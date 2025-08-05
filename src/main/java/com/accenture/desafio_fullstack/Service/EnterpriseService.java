package com.accenture.desafio_fullstack.Service;

import java.util.HashSet;
import java.util.List;

import com.accenture.desafio_fullstack.Repository.EnterpriseRepository;
import com.accenture.desafio_fullstack.Repository.SupplierRepository;
import com.accenture.desafio_fullstack.entity.EnterpriseEntity;
import com.accenture.desafio_fullstack.entity.SupplierEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EnterpriseService {
	private final EnterpriseRepository enterpriseRepository;
	
	@Autowired
	private final SupplierRepository supplierRepository;

	public EnterpriseService(EnterpriseRepository enterpriseRepository, SupplierRepository supplierRepository) {
		this.enterpriseRepository = enterpriseRepository;
		this.supplierRepository = supplierRepository;
	}

	public List<EnterpriseEntity> getAll() {
		return enterpriseRepository.findAll();
	}

	public EnterpriseEntity save(EnterpriseEntity enterprise) {
		return enterpriseRepository.save(enterprise);
	}

	public EnterpriseEntity update(EnterpriseEntity enterprise) {
		enterpriseRepository.findById(enterprise.getId())
				.orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

		return enterpriseRepository.save(enterprise);
	}

	@Transactional
	public void delete(Long enterpriseId) {
	    EnterpriseEntity enterprise = enterpriseRepository.findById(enterpriseId)
	        .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

	    for (SupplierEntity supplier : new HashSet<>(enterprise.getSuppliers())) {
	        supplier.getEnterprises().remove(enterprise);
	    }

	    enterprise.getSuppliers().clear();

	    enterpriseRepository.delete(enterprise);
	}

	public void deleteAll() {
		enterpriseRepository.deleteAll();
	}

	public void linkSupplierToEnterprise(Long enterpriseId, Long supplierId) {
		EnterpriseEntity enterprise = enterpriseRepository.findById(enterpriseId)
				.orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

		SupplierEntity supplier = supplierRepository.findById(supplierId)
				.orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));

		if (!enterprise.getSuppliers().contains(supplier)) {
	        enterprise.getSuppliers().add(supplier);
	        enterpriseRepository.save(enterprise);
	    }
	}
	
	public EnterpriseEntity getEnterpriseWithSuppliers(Long id) {
	    return enterpriseRepository.findByIdWithSuppliers(id)
	        .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
	}
	
	@Transactional
	public void unlinkSupplierFromEnterprise(Long enterpriseId, Long supplierId) {
	    EnterpriseEntity enterprise = enterpriseRepository.findById(enterpriseId)
	        .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

	    SupplierEntity supplier = supplierRepository.findById(supplierId)
	        .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));

	    enterprise.getSuppliers().remove(supplier);
	    supplier.getEnterprises().remove(enterprise);

	    enterpriseRepository.save(enterprise);
	    supplierRepository.save(supplier);
	}
}
