package com.accenture.desafio_fullstack.controller;

import java.util.List;

import com.accenture.desafio_fullstack.Service.EnterpriseService;
import com.accenture.desafio_fullstack.entity.EnterpriseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {
	private final EnterpriseService enterpriseService;

	public EnterpriseController(EnterpriseService enterpriseService) {
		super();
		this.enterpriseService = enterpriseService;
	}

	@GetMapping
	public List<EnterpriseEntity> getAll() {
		return enterpriseService.getAll();
	}

	@PostMapping
	public EnterpriseEntity create(@RequestBody EnterpriseEntity enterprise) {
		return enterpriseService.save(enterprise);
	}

	@PutMapping
	public EnterpriseEntity update(@RequestBody EnterpriseEntity enterprise) {
		return enterpriseService.update(enterprise);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		enterpriseService.delete(id);
	}

	@DeleteMapping
	public void deleteAll() {
		enterpriseService.deleteAll();
	}

	@PutMapping("/{enterpriseId}/supplier/{supplierId}")
	public void linkSupplierToEnterprise(@PathVariable("enterpriseId") Long idEnterprise,
			@PathVariable("supplierId") Long idSupplier) {
		enterpriseService.linkSupplierToEnterprise(idEnterprise, idSupplier);
	}

	@GetMapping("/{id}/suppliers")
	public EnterpriseEntity getEnterpriseWithSuppliers(@PathVariable("id") Long id) {
		return enterpriseService.getEnterpriseWithSuppliers(id);
	}

	@DeleteMapping("/{enterpriseId}/supplier/{supplierId}")
	public void unlinkSupplierFromEnterprise(@PathVariable("enterpriseId") Long enterpriseId,
			@PathVariable("supplierId") Long supplierId) {

		enterpriseService.unlinkSupplierFromEnterprise(enterpriseId, supplierId);
	}
}
