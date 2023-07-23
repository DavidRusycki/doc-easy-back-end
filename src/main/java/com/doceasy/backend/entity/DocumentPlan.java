package com.doceasy.backend.entity;

import java.util.List;
import java.util.stream.Collectors;

import com.doceasy.backend.dto.DocumentPlanDTO;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class DocumentPlan {

	private Plan plan;
	private List<Document> documents;
	
	/**
	 * Converte a entidade em DTO
	 * @return
	 */
	public static DocumentPlanDTO toDto(DocumentPlan documentPlan) {
		DocumentPlanDTO dto = new DocumentPlanDTO();
		
		dto.setPlan(Plan.toDto(documentPlan.getPlan()));
		dto.setDocuments(documentPlan.getDocuments().stream().map(Document::toDto).collect(Collectors.toList()));
				
		return dto;
	}
	
}
