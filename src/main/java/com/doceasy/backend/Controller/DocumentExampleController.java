package com.doceasy.backend.Controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.doceasy.backend.dto.DocumentDTO;
import com.doceasy.backend.dto.DocumentExampleDTO;
import com.doceasy.backend.entity.Document;
import com.doceasy.backend.entity.DocumentExample;
import com.doceasy.backend.service.DocumentExampleService;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/doceasy/document/example")
public class DocumentExampleController {

	@Autowired
	private DocumentExampleService service;
	
	@GetMapping("/all")
	public List<DocumentExampleDTO> getAll() {
		List<DocumentExample> search = service.getAll();
		List<DocumentExampleDTO> list = search.stream().map(DocumentExample::toDto).collect(Collectors.toList());
		
		return list;
	}
	
	@GetMapping("/{uuid}")
	public DocumentExampleDTO getFromDocumentUuid(@PathVariable UUID uuid) {
		DocumentExample document = service.getFromDocumentUuid(uuid);
		
		return DocumentExample.toDto(document);
	}
	
}
