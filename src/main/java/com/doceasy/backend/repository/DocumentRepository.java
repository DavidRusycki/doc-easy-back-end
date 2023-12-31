package com.doceasy.backend.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doceasy.backend.entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, UUID>{

	List<Document> findByIdPlano(Long id);

}
