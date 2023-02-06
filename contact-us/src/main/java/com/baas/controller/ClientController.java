package com.baas.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baas.ThrowException.ClientNotFoundException;
import com.baas.ThrowException.QuestionNotFoundException;
import com.baas.model.Client;
import com.baas.model.Question;
import com.baas.service.ClientService;
import com.baas.service.QuestionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clients")
public class ClientController {

	private final ClientService clientService;
	private final QuestionService questionService;
	
	public ClientController(ClientService clientService,QuestionService questionService) {
		this.clientService = clientService;
		this.questionService = questionService;
	}
	
	@GetMapping("/{clientId}")
	public ResponseEntity<Client> getById(@PathVariable final String clientId) throws ClientNotFoundException {
		Client client = clientService.findById(clientId);
		return new ResponseEntity<>(client, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Client>> findAllClients(){
		return new ResponseEntity<>(clientService.findAllClients(),HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<Client> findByEmail(@RequestParam final String clientEmail) throws ClientNotFoundException {
		Client client = clientService.getByEmail(clientEmail);
		return new ResponseEntity<>(client,HttpStatus.OK);
	}
	
	@GetMapping("/{clientId}/questions")
	public ResponseEntity<List<Question>> findQuestionsByClientId(@PathVariable final String clientId)
			throws ClientNotFoundException{
		return new ResponseEntity<>(questionService.findQuestionsByClientId(clientId),HttpStatus.OK);
	}
	
	@GetMapping("/{clientId}/questions/{questionId}")
	public ResponseEntity<Question> findQuestionByClientId(@PathVariable final String clientId,
			@PathVariable final String questionId) throws QuestionNotFoundException, ClientNotFoundException{
		Question question = questionService.findQuestionByClientId(clientId, questionId);
		return new ResponseEntity<Question>(question,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Question>> findAllQuestions(){
		return new ResponseEntity<>(questionService.findAllQuestions(),HttpStatus.OK);
	}
 	
	@PostMapping
	public ResponseEntity<Client> saveClient(@RequestBody @Valid final Client client) {
		return new ResponseEntity<>(clientService.saveClient(client),HttpStatus.CREATED);
	}
	
	@PutMapping("/{clientId}")
	public ResponseEntity<Client> updateClient(@PathVariable final String clientId, 
										@RequestBody @Valid final Client client)throws ClientNotFoundException {
		return new ResponseEntity<>(clientService.updateClient(clientId,client),HttpStatus.OK);
	}
	
	@DeleteMapping("/{clientId}")
	public ResponseEntity<Client> deleteClient(@PathVariable final String clientId) {
		clientService.deleteById(clientId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{questionId}")
	public ResponseEntity<Question> deleteById(@PathVariable final String questionId){
		questionService.deleteById(questionId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}