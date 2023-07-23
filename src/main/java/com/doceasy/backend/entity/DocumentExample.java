package com.doceasy.backend.entity;

import java.util.UUID;

import com.doceasy.backend.dto.DocumentExampleDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "tbdocumentoexemplo")
public class DocumentExample {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID uuid;
	
	@NotNull
	private UUID uuidDocumento;
	
	@NotNull
	private byte[] content;
	
	/**
	 * Converte a entidade em DTO
	 * @return
	 */
	public static DocumentExampleDTO toDto(DocumentExample document) {
		DocumentExampleDTO dto = new DocumentExampleDTO();
		
		dto.setUuid(document.getUuid());
		dto.setUuidDocumento(document.getUuidDocumento());
		dto.setContent(document.getContent());
		
		return dto;
	}
	
}
