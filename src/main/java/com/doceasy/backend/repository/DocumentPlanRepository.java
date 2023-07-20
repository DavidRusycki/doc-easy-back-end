package com.doceasy.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doceasy.backend.entity.DocumentPlan;

@Repository
public interface DocumentPlanRepository extends JpaRepository<DocumentPlan, Long>{

}
