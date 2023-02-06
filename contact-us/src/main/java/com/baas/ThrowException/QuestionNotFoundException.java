package com.baas.ThrowException;

@SuppressWarnings("serial")
public class QuestionNotFoundException extends Exception{

	public QuestionNotFoundException(String message) {
		super(message);
	}
}
