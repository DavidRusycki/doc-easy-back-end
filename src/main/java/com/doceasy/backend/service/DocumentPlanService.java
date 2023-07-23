package com.doceasy.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doceasy.backend.entity.Document;
import com.doceasy.backend.entity.DocumentPlan;
import com.doceasy.backend.entity.Plan;
import com.doceasy.backend.repository.DocumentRepository;
import com.doceasy.backend.repository.PlanRepository;

import lombok.Data;

@Data
@Service
public class DocumentPlanService {

	@Autowired
	private PlanRepository planRepository;
	@Autowired
	private DocumentRepository documentRepository;
	
	/**
	 * Retorna os documentos de um plano.
	 * @param name
	 * @return
	 */
	public DocumentPlan getAllDocumentsFromPlanName(String name) {
		
		Optional<Plan> optional = planRepository.findByNome(name);
		Plan plan = optional.get(); 
		
		List<Document> list = documentRepository.findByIdPlano(plan.getId());
		
		DocumentPlan documentPlan = new DocumentPlan();
		documentPlan.setPlan(plan);
		documentPlan.setDocuments(list);
		
		return documentPlan;
	}
	
}
