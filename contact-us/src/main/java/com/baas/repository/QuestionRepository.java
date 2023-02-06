package com.baas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.baas.model.Question;

public interface QuestionRepository extends JpaRepository<Question, String>{
	List<Question> findQuestionsByClientId(String clientId);
}
