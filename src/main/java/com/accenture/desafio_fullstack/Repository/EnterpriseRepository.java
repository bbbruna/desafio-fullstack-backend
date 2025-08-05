package com.accenture.desafio_fullstack.Repository;

import java.util.Optional;

import com.accenture.desafio_fullstack.entity.EnterpriseEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EnterpriseRepository extends JpaRepository<EnterpriseEntity, Long> {

	@Query("SELECT e FROM EnterpriseEntity e LEFT JOIN FETCH e.suppliers WHERE e.id = :id")
	Optional<EnterpriseEntity> findByIdWithSuppliers(@Param("id") Long id);
}
