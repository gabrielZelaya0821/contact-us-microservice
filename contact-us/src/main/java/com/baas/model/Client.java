package com.baas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
	@Id
	@Column(name = "client_id",length = 64)
	private String clientId;
	
	@Column(name = "name",nullable = false,length = 64)
	private String name;
	
	@Column(name = "address",nullable = false,length = 64)
	private String address;
	
	@Column(name="phone_num",nullable = false,length = 64)
	private int phoneNum;
	
	@Column(name = "email",nullable = false,length = 64)
	private String email;
	
	@Column(name = "company",nullable = false,length = 64)
	private String company;
	
	@Column(name = "question",length = 256)
	private String question;
	
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
