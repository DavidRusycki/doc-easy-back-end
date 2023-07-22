package com.doceasy.backend.dto;

import com.doceasy.backend.entity.DocumentPlan;

import lombok.Data;

@Data
public class DocumentPlanDTO {

	private Long id;
	private String nome;
	private String criador;
	private String descricao;
	
	/**
	 * Converte o DTO para entidade
	 * @return
	 */
	public static DocumentPlan toEntity(DocumentPlanDTO dto) {
		DocumentPlan plan = new DocumentPlan();
		
		plan.setId(dto.getId());
		plan.setNome(dto.getNome());
		plan.setCriador(dto.getCriador());
		plan.setDescricao(dto.getDescricao());
		
		return plan;
	}
	
}
