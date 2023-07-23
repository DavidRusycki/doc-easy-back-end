package com.doceasy.backend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doceasy.backend.entity.DocumentExample;

@Repository
public interface DocumentExampleRepository extends JpaRepository<DocumentExample, UUID>{

	DocumentExample findByUuidDocumento(UUID uuid);

}
