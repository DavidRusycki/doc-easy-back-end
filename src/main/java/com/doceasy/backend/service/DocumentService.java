package com.doceasy.backend.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doceasy.backend.entity.Document;
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
	public Document save(Document plan, InputStream stream) throws IOException {
		
		//TODO Implementar log de erro quando não conseguir salvar.
		Document result = repository.save(plan);
		exampleService.save(result, stream);
		
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
