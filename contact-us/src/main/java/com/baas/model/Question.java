package com.baas.model;

import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "question")
@JsonSerialize
public class Question {
	
	@Id
	@Column(name = "question_id",nullable = false,length = 64)
	private String questionId;
	
	@ManyToOne
	@JsonProperty
	@JoinColumn(name = "fk_question_id",referencedColumnName = "question_id")
	@NotBlank(message = "Must enter a question")
	private String question;
	
	
	public static void prepareToPersist(Question question) {
		question = new Question(question.questionId,UUID.randomUUID().toString());
		
	}	
}
