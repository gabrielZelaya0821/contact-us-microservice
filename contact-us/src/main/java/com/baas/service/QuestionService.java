package com.baas.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.baas.ThrowException.ClientNotFoundException;
import com.baas.ThrowException.QuestionNotFoundException;
import com.baas.model.Question;
import com.baas.repository.ClientRepository;
import com.baas.repository.QuestionRepository;

@Service
public class QuestionService {
	
	private final QuestionRepository questionRespository;
	private final ClientRepository clientRepository;
	
	public QuestionService(QuestionRepository questionRespository,ClientRepository clientRepository) {
		this.questionRespository = questionRespository;
		this.clientRepository = clientRepository;
	}
	
	public Question findById(final String questionId)throws QuestionNotFoundException {
		return questionRespository.findById(questionId).
				orElseThrow(()->new QuestionNotFoundException
						("QuestionId: "+questionId+" not found"));
	}
	
	public List<Question> findQuestionsByClientId(String clientId) throws ClientNotFoundException{
		if (clientRepository.findById(clientId) == null) {
			throw new ClientNotFoundException("ID: "+clientId+" couldn't be found");
		} else {
			return questionRespository.findQuestionsByClientId(clientId);
		}
	}
	
	public Question findQuestionByClientId(final String clientId,final String questionId) 
			throws QuestionNotFoundException, ClientNotFoundException {
		if (clientRepository.findById(clientId) == null) {
			throw new ClientNotFoundException("ID: "+clientId+" couldn't be found");
		} else {
			return questionRespository.findById(questionId).
					orElseThrow(()->new QuestionNotFoundException("QuestionId: "+questionId+" not found"));
		}
	}
	
	public List<Question> findAllQuestions(){
		return questionRespository.findAll();
	}
	
	public void deleteById(final String questionId) {
		questionRespository.deleteById(questionId);
	}
}
