package com.doceasy.backend.dto;

import java.util.UUID;

import com.doceasy.backend.entity.DocumentExample;

import lombok.Data;

@Data
public class DocumentExampleDTO {

	private UUID uuid;
	private UUID uuidDocumento;
	private byte[] content;

	/**
	 * Converte o DTO para entidade
	 * @return
	 */
	public static DocumentExample toEntity(DocumentExampleDTO dto) {
		DocumentExample document = new DocumentExample();
		
		document.setUuid(dto.getUuid());
		document.setUuidDocumento(dto.getUuidDocumento());
		document.setContent(dto.getContent());
		
		return document;
	}
	
}
