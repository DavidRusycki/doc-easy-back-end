package com.doceasy.backend.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doceasy.backend.dto.HealthDTO;

@RestController
@RequestMapping("/doceasy")
public class ControllerHealth {

	@GetMapping("/health")
	public HealthDTO health() {
		HealthDTO dto = new HealthDTO();
		
		dto.setStatus("running");
		dto.setTimestamp(System.currentTimeMillis());
		
		return dto;
	}
	
}
