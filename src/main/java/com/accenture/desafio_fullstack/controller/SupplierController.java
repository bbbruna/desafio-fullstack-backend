package com.accenture.desafio_fullstack.controller;

import java.util.List;

import com.accenture.desafio_fullstack.Service.SupplierService;
import com.accenture.desafio_fullstack.entity.SupplierEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
	private final SupplierService supplierService;

	public SupplierController(SupplierService supplierService) {
		super();
		this.supplierService = supplierService;
	}

	@GetMapping
	public List<SupplierEntity> getAll() {
		return supplierService.getAll();
	}

	@PostMapping
	public SupplierEntity create(@RequestBody SupplierEntity supplier) {
		return supplierService.save(supplier);
	}
	
	@PutMapping
	public SupplierEntity update(@RequestBody SupplierEntity supplier) {
		return supplierService.update(supplier);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		supplierService.delete(id);
	}

	@DeleteMapping
	public void deleteAll() {
		supplierService.deleteAll();
	}
}
