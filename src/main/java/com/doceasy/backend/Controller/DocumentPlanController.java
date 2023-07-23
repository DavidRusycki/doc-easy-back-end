package com.doceasy.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doceasy.backend.dto.DocumentPlanDTO;
import com.doceasy.backend.entity.DocumentPlan;
import com.doceasy.backend.service.DocumentPlanService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/doceasy/document")
public class DocumentPlanController {

	@Autowired
	private DocumentPlanService service;

	@GetMapping("/{name}")
	public DocumentPlanDTO getAllDocumentsFromPlanName(@PathVariable String name) {
		
		DocumentPlan documentPlan = service.getAllDocumentsFromPlanName(name);
		
		return DocumentPlan.toDto(documentPlan);
	}
	
}
