package com.doceasy.backend.dto;

import java.util.UUID;

import com.doceasy.backend.entity.Document;

import lombok.Data;

@Data
public class DocumentDTO {

	private UUID uuid;
	private Long idPlano;
	private String nome;
	private String descricao;
	private String descricaoCompleta;
	private Integer situacao;

	/**
	 * Converte o DTO para entidade
	 * @return
	 */
	public static Document toEntity(DocumentDTO dto) {
		Document document = new Document();
		
		document.setUuid(dto.getUuid());
		document.setIdPlano(dto.getIdPlano());
		document.setNome(dto.getNome());
		document.setDescricao(dto.getDescricao());
		document.setDescricaoCompleta(dto.getDescricaoCompleta());
		document.setSituacao(dto.getSituacao());
		
		return document;
	}
	
}
