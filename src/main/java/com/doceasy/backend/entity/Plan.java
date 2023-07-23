package com.doceasy.backend.entity;

import com.doceasy.backend.dto.PlanDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "tbplano")
public class Plan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	private String nome;

	@NotNull
	@NotBlank
	private String criador;
	
	@NotNull
	@NotBlank
	private String descricao;
	
	/**
	 * Converte a entidade em DTO
	 * @return
	 */
	public static PlanDTO toDto(Plan plan) {
		PlanDTO dto = new PlanDTO();
		
		dto.setId(plan.getId());
		dto.setNome(plan.getNome());
		dto.setCriador(plan.getCriador());
		dto.setDescricao(plan.getDescricao());
		
		return dto;
	}
	
}
