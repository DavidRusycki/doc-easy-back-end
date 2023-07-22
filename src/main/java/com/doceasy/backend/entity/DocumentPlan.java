package com.doceasy.backend.entity;

import com.doceasy.backend.dto.DocumentPlanDTO;

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
public class DocumentPlan {

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
	public static DocumentPlanDTO toDto(DocumentPlan plan) {
		DocumentPlanDTO dto = new DocumentPlanDTO();
		
		dto.setId(plan.getId());
		dto.setNome(plan.getNome());
		dto.setCriador(plan.getCriador());
		dto.setDescricao(plan.getDescricao());
		
		return dto;
	}
	
}
