package com.doceasy.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doceasy.backend.entity.Plan;
import com.doceasy.backend.repository.PlanRepository;

@Service
public class PlanService {

	@Autowired
	private PlanRepository repository;
	
	/**
	 * Retorna todos os registros
	 * @return
	 */
	public List<Plan> getAll() {
		List<Plan> list = null;
		
		list = repository.findAll();
		
		return list;
	}

	/**
	 * Salva a entidade no banco
	 * @param plan
	 * @return
	 */
	public Plan save(Plan plan) {
		
		//TODO Implementar log de erro quando não conseguir salvar.
		
		return repository.save(plan);
	}

	/**
	 * Remove a entidade do banco
	 * @param plan
	 * @return
	 */
	public Boolean delete(Long id) {
		Optional<Plan> optional = repository.findById(id);
		Plan plan = optional.get();
		repository.delete(plan);
		
		return true;
	}
	
}
