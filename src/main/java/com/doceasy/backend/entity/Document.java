package com.doceasy.backend.entity;

import java.util.UUID;

import com.doceasy.backend.dto.DocumentDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tbdocumento")
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID uuid;
	
	private Long idPlano;
	
	@Column(length = 100, nullable = false)
	private String nome;
	
	@Column(length = 100, nullable = false)
	private String descricao;
	
	private String descricaoCompleta;
	
	private Integer situacao;
	
	/**
	 * Converte a entidade em DTO
	 * @return
	 */
	public static DocumentDTO toDto(Document document) {
		DocumentDTO dto = new DocumentDTO();
		
		dto.setUuid(document.getUuid());
		dto.setIdPlano(document.getIdPlano());
		dto.setNome(document.getNome());
		dto.setDescricao(document.getDescricao());
		dto.setDescricaoCompleta(document.getDescricaoCompleta());
		dto.setSituacao(document.getSituacao());
		
		return dto;
	}
	
}
