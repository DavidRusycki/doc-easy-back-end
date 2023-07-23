package com.doceasy.backend.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.doceasy.backend.entity.DocumentPlan;

import lombok.Data;

@Data
public class DocumentPlanDTO {

	private PlanDTO plan;
	private List<DocumentDTO> documents;
	
	/**
	 * Converte a entidade em DTO
	 * @return
	 */
	public static DocumentPlan toEntity(DocumentPlanDTO dto) {
		DocumentPlan document = new DocumentPlan();

		document.setPlan(PlanDTO.toEntity(dto.getPlan()));
		document.setDocuments(dto.getDocuments().stream().map(DocumentDTO::toEntity).collect(Collectors.toList()));
		
		return document;
	}
	
}
