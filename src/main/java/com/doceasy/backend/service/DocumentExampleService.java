package com.doceasy.backend.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doceasy.backend.entity.Document;
import com.doceasy.backend.entity.DocumentExample;
import com.doceasy.backend.repository.DocumentExampleRepository;

@Service
public class DocumentExampleService {

	@Autowired
	private DocumentExampleRepository repository;
	
	/**
	 * Retorna todos os registros
	 * @return
	 */
	public List<DocumentExample> getAll() {
		List<DocumentExample> list = null;
		
		list = repository.findAll();
		
		return list;
	}

	/**
	 * Retorna o registro de exemplo de acordo com o documento
	 * @param uuid
	 * @return
	 */
	public DocumentExample getFromDocumentUuid(UUID uuid) {		
		DocumentExample document = repository.findByUuidDocumento(uuid);
		
		return document;
	}
	
	/**
	 * Salva a entidade no banco
	 * @param plan
	 * @return
	 * @throws IOException 
	 */
	public DocumentExample save(Document document, InputStream stream) throws IOException {
		//TODO Implementar log de erro quando não conseguir salvar.
		
		DocumentExample example = new DocumentExample();
		example.setUuidDocumento(document.getUuid());
		example.setContent(stream.readAllBytes());	
		
		return repository.save(example);
	}
	
	/**
	 * Salva a entidade no banco
	 * @param plan
	 * @return
	 */
	public DocumentExample save(DocumentExample example) {
		
		//TODO Implementar log de erro quando não conseguir salvar.
		
		return repository.save(example);
	}

	/**
	 * Remove a entidade do banco
	 * @param plan
	 * @return
	 */
	public Boolean delete(UUID uuid) {
		Optional<DocumentExample> optional = repository.findById(uuid);
		DocumentExample example = optional.get();
		repository.delete(example);
		
		return true;
	}
	
}
