package com.doceasy.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doceasy.backend.entity.DocumentPlan;
import com.doceasy.backend.repository.DocumentPlanRepository;

@Service
public class DocumentPlanService {

	@Autowired
	private DocumentPlanRepository repository;
	
	/**
	 * Retorna todos os registros
	 * @return
	 */
	public List<DocumentPlan> getAll() {
		List<DocumentPlan> list = null;
		
		list = repository.findAll();
		
		return list;
	}

	/**
	 * Salva a entidade no banco
	 * @param plan
	 * @return
	 */
	public DocumentPlan save(DocumentPlan plan) {
		
		//TODO Implementar log de erro quando não conseguir salvar.
		
		return repository.save(plan);
	}

	/**
	 * Remove a entidade do banco
	 * @param plan
	 * @return
	 */
	public Boolean delete(Long id) {
		Optional<DocumentPlan> optional = repository.findById(id);
		DocumentPlan plan = optional.get();
		repository.delete(plan);
		
		return true;
	}
	
}
