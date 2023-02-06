package com.baas.model;

import java.util.List;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
@JsonSerialize
public class Client {
	@Id
	@Column(name = "client_id",length = 64)
	private String clientId;
	
	@Column(nullable = false,length = 64)
	@JsonProperty
	@NotBlank(message = "Must enter a name")
	private String name;
	
	@Column(nullable = false,length = 64)
	@JsonProperty
	@NotBlank(message = "Must enter an address")
	private String address;
	
	@Column(name="phone_num",nullable = false,length = 64)
	@JsonProperty
	@NotNull(message = "Must enter a phone number")
	private int phoneNum;
	
	@Column(nullable = false,length = 64)
	@JsonProperty
	@Email(message = "Invalid email address")
	private String email;
	
	@Column(nullable = false,length = 64)
	@JsonProperty
	@NotBlank(message = "Must enter a company name")
	private String company;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_question_id",referencedColumnName = "question_id")
	private List<Question> questions;
	
	public static void perepareToPersist(Client client) {
		client.setClientId(UUID.randomUUID().toString());
	}
}
	