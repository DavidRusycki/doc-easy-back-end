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
import com.doceasy.backend.entity.Document;
import com.doceasy.backend.service.DocumentExampleService;
import com.doceasy.backend.service.DocumentService;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/doceasy/document")
public class DocumentController {

	@Autowired
	private DocumentService service;
	
	@GetMapping("/all")
	public List<DocumentDTO> getAll() {
		List<Document> search = service.getAll();
		List<DocumentDTO> list = search.stream().map(Document::toDto).collect(Collectors.toList());
		
		return list;
	}
	
	@PostMapping("/new")
	public ResponseEntity<DocumentDTO> newDocumentPlan(
		@RequestPart(name = "file", required = true) MultipartFile multipart, 
		@RequestParam(name = "document", required = true) String documentJson
	) {
		try {
			DocumentDTO dto = new ObjectMapper().readValue(documentJson, DocumentDTO.class);
			
			Document result = service.save(DocumentDTO.toEntity(dto), multipart.getInputStream());
			
			return ResponseEntity.ok().body(Document.toDto(result));
		} catch (Exception e) {
			e.printStackTrace();
			
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<DocumentDTO> updateDocument(@RequestBody DocumentDTO dto) {
		Document result = service.save(DocumentDTO.toEntity(dto));
		
		return ResponseEntity.ok().body(Document.toDto(result));
	}
	
	@DeleteMapping("/delete/{uuid}")
	public ResponseEntity deleteDocument(@PathVariable UUID uuid) {
		Boolean bo = service.delete(uuid);
		
		return ResponseEntity.ok().build();
	}
	
}
