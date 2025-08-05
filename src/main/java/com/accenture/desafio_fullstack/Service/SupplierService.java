package com.accenture.desafio_fullstack.Service;

import java.util.HashSet;
import java.util.List;

import com.accenture.desafio_fullstack.Repository.SupplierRepository;
import com.accenture.desafio_fullstack.entity.EnterpriseEntity;
import com.accenture.desafio_fullstack.entity.SupplierEntity;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class SupplierService {
private final SupplierRepository supplierRepository;
	
	public SupplierService(SupplierRepository supplierRepository) {
		this.supplierRepository = supplierRepository;
	}
	
	public List<SupplierEntity> getAll(){
		return supplierRepository.findAll();
	}
	
	public SupplierEntity save(SupplierEntity supplier){
		return supplierRepository.save(supplier);
	}
	
	public SupplierEntity update(SupplierEntity supplier) {
	    supplierRepository.findById(supplier.getId())
	        .orElseThrow(() -> new RuntimeException("Fornecedor não encontrada para atualizar"));

	    return supplierRepository.save(supplier);
	}
	
	@Transactional
	public void delete(Long supplierId) {
	    SupplierEntity supplier = supplierRepository.findById(supplierId)
	        .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));

	    // Para cada empresa associada, remova o fornecedor e salve a empresa
	    for (EnterpriseEntity enterprise : new HashSet<>(supplier.getEnterprises())) {
	        enterprise.getSuppliers().remove(supplier);
	    }

	    // Limpa a lista de empresas associadas ao fornecedor
	    supplier.getEnterprises().clear();

	    // Salva a mudança para quebrar o vínculo antes de deletar
	    supplierRepository.save(supplier);

	    // Agora sim, pode excluir com segurança
	    supplierRepository.delete(supplier);
	}
	
	public void deleteAll() {
		supplierRepository.deleteAll();
	}

}
