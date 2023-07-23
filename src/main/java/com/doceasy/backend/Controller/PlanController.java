package com.doceasy.backend.Controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.RestController;

import com.doceasy.backend.dto.PlanDTO;
import com.doceasy.backend.entity.Plan;
import com.doceasy.backend.service.PlanService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/doceasy/plan")
public class PlanController {

	@Autowired
	private PlanService service;
	
	@GetMapping("/all")
	public List<PlanDTO> getAll() {
		List<Plan> search = service.getAll();
		List<PlanDTO> list = search.stream().map(Plan::toDto).collect(Collectors.toList());
		
		return list;
	}
	
	@PostMapping("/new")
	public ResponseEntity<PlanDTO> newDocumentPlan(@RequestBody PlanDTO dto) {
		Plan result = service.save(PlanDTO.toEntity(dto));
		
		return ResponseEntity.ok().body(Plan.toDto(result));
	}
	
	@PutMapping("/update")
	public ResponseEntity<PlanDTO> updateDocumentPlan(@RequestBody PlanDTO dto) {
		Plan result = service.save(PlanDTO.toEntity(dto));
		
		return ResponseEntity.ok().body(Plan.toDto(result));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity deleteDocumentPlan(@PathVariable Long id) {
		Boolean bo = service.delete(id);
		
		return ResponseEntity.ok().build();
	}
	
}
