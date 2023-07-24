package com.doceasy.backend.entity;

import java.util.UUID;

import com.doceasy.backend.dto.DocumentExampleDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
	@NotBlank
	@Size(max = 100)
	private String nomeOriginal;
	
	@NotNull
	private Long tamanho;
	
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
		dto.setNomeOriginal(document.getNomeOriginal());
		dto.setTamanho(document.getTamanho());
		dto.setContent(document.getContent());
		
		return dto;
	}
	
}
