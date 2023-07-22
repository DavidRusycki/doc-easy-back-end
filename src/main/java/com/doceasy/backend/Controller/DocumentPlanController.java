package com.doceasy.backend.Controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.swing.text.Document;

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
import org.springframework.web.bind.annotation.RestController;

import com.doceasy.backend.dto.DocumentPlanDTO;
import com.doceasy.backend.entity.DocumentPlan;
import com.doceasy.backend.service.DocumentPlanService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/doceasy/document/plan")
public class DocumentPlanController {

	@Autowired
	private DocumentPlanService service;
	
	@GetMapping("/all")
	public List<DocumentPlanDTO> getAll() {
		List<DocumentPlan> search = service.getAll();
		List<DocumentPlanDTO> list = search.stream().map(DocumentPlan::toDto).collect(Collectors.toList());
		
		return list;
	}
	
	@PostMapping("/new")
	public ResponseEntity<DocumentPlanDTO> newDocumentPlan(@RequestBody DocumentPlanDTO dto) {
		DocumentPlan result = service.save(DocumentPlanDTO.toEntity(dto));
		
		return ResponseEntity.ok().body(DocumentPlan.toDto(result));
	}
	
	@PutMapping("/update")
	public ResponseEntity<DocumentPlanDTO> updateDocumentPlan(@RequestBody DocumentPlanDTO dto) {
		DocumentPlan result = service.save(DocumentPlanDTO.toEntity(dto));
		
		return ResponseEntity.ok().body(DocumentPlan.toDto(result));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteDocumentPlan(@PathVariable Long id) {
		Boolean bo = service.delete(id);
		
		return ResponseEntity.ok().build();
	}
	
}
