package com.doceasy.backend.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doceasy.backend.dto.DocumentExampleDTO;
import com.doceasy.backend.entity.Document;
import com.doceasy.backend.entity.DocumentExample;
import com.doceasy.backend.repository.DocumentRepository;

@Service
public class DocumentService {

	@Autowired
	private DocumentRepository repository;
	
	@Autowired
	private DocumentExampleService exampleService;
	
	/**
	 * Retorna todos os registros
	 * @return
	 */
	public List<Document> getAll() {
		List<Document> list = null;
		
		list = repository.findAll();
		
		return list;
	}

	/**
	 * Salva a entidade no banco
	 * @param plan
	 * @return
	 * @throws IOException 
	 */
	public Document save(Document plan, DocumentExampleDTO exampleDto) throws IOException {
		
		//TODO Implementar log de erro quando não conseguir salvar.
		
		if (plan.getUuid() != null) {
			DocumentExample example = exampleService.getFromDocumentUuid(plan.getUuid());
			
			if (example.getUuid() != null) {
				exampleService.delete(example.getUuid());
			}
		}
		
		Document result = repository.save(plan);
		exampleService.save(result, exampleDto);
		
		return result;
	}

	/**
	 * Salva a entidade no banco
	 * @param plan
	 * @return
	 * @throws IOException 
	 */
	public Document save(Document plan) {
		//TODO Implementar log de erro quando não conseguir salvar.
		
		if (plan.getUuid() != null) {
			Optional<Document> optional = repository.findById(plan.getUuid());
			Document loaded = optional.get();
			loaded.loadDataForUpdate(plan);	
			plan = loaded;
		}
		
		return repository.save(plan);
	}
	
	/**
	 * Remove a entidade do banco
	 * @param plan
	 * @return
	 */
	public Boolean delete(UUID uuid) {
		Optional<Document> optional = repository.findById(uuid);
		Document document = optional.get();
		repository.delete(document);
		
		return true;
	}
	
	public List<Document> getFromPlanName(String name) {
		List<Document> list = null;
		
		list = repository.findAll();
		
		return list;
	}
	
}
