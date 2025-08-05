package com.accenture.desafio_fullstack.Repository;

import com.accenture.desafio_fullstack.entity.SupplierEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Long>{

}
