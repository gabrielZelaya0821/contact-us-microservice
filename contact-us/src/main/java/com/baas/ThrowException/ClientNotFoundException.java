package com.baas.ThrowException;

@SuppressWarnings("serial")
public class ClientNotFoundException extends Exception{
	
	public ClientNotFoundException(String message) {
		super(message);
	}
}