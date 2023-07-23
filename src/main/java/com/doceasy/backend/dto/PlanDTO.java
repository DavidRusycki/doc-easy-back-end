package com.doceasy.backend.dto;

import com.doceasy.backend.entity.Plan;

import lombok.Data;

@Data
public class PlanDTO {

	private Long id;
	private String nome;
	private String criador;
	private String descricao;
	
	/**
	 * Converte o DTO para entidade
	 * @return
	 */
	public static Plan toEntity(PlanDTO dto) {
		Plan plan = new Plan();
		
		plan.setId(dto.getId());
		plan.setNome(dto.getNome());
		plan.setCriador(dto.getCriador());
		plan.setDescricao(dto.getDescricao());
		
		return plan;
	}
	
}
