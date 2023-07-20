package com.doceasy.backend.entity;

import com.doceasy.backend.dto.DocumentPlanDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbplano")
public class DocumentPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100, nullable = false)
	private String nome;
	
	private String descricao;
	
	/**
	 * Converte a entidade em DTO
	 * @return
	 */
	public static DocumentPlanDTO toDto(DocumentPlan plan) {
		DocumentPlanDTO dto = new DocumentPlanDTO();
		
		dto.setId(plan.getId());
		dto.setNome(plan.getNome());
		dto.setDescricao(plan.getDescricao());
		
		return dto;
	}
	
}
