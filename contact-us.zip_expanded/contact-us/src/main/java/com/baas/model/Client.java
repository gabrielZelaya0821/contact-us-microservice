package com.baas.model;

import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "client")
@JsonSerialize
public class Client {
	@Id
	@Column(name = "client_id",length = 64)
	private String clientId;
	
	@Column(name = "name",nullable = false,length = 64)
	@JsonProperty
	@NotBlank(message = "Must enter a name")
	private String name;
	
	@Column(name = "address",nullable = false,length = 64)
	@JsonProperty
	@NotBlank(message = "Must enter an address")
	private String address;

	//LIKE CONTAINS Ignore case
	
	@Column(name="phone_num",nullable = false,length = 64)
	@JsonProperty
	@NotNull(message = "Must enter a phone number")
	private int phoneNum;
	//startsWith
	
	@Column(name = "email",nullable = false,length = 64)
	@JsonProperty
	@Email(message = "Invalid email address")
	private String email;
	//like

	@Column(name = "company",nullable = false,length = 64)
	@JsonProperty
	@NotBlank(message = "Must enter a company name")
	private String company;
	//ignoreCase


	@Column(name = "question",length = 256)
	@JsonProperty
	@NotBlank(message = "Must enter a question")
	private String question;
	//like
	
	public static void perepareToPersist(Client client) {
		client.setClientId(UUID.randomUUID().toString());
	}
	
	private Client() {
		super();
	}
	
	private Client(String clientId,String name,String address,
			int phoneNum,String email,String company,String question) {
		this.clientId = clientId;
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
		this.email = email;
		this.company = company;
		this.question = question;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPhoneNum() {
		return phoneNum;
	}
	
	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getClientId() {
		return clientId;
	}
	
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
}
