package com.doceasy.backend.dto;

import java.io.InputStream;
import java.util.UUID;

import com.doceasy.backend.entity.DocumentExample;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class DocumentExampleDTO {

	private UUID uuid;
	private UUID uuidDocumento;
	private String nomeOriginal;
	private Long tamanho;
	private byte[] content;
	
	@JsonIgnore
	private InputStream inputStream;

	/**
	 * Converte o DTO para entidade
	 * @return
	 */
	public static DocumentExample toEntity(DocumentExampleDTO dto) {
		DocumentExample document = new DocumentExample();
		
		document.setUuid(dto.getUuid());
		document.setUuidDocumento(dto.getUuidDocumento());
		document.setNomeOriginal(dto.getNomeOriginal());
		document.setTamanho(dto.getTamanho());
		document.setContent(dto.getContent());
		
		return document;
	}
	
}
