package com.doceasy.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doceasy.backend.entity.Document;
import com.doceasy.backend.entity.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long>{

	Optional<Plan> findByNome(String name);

}
