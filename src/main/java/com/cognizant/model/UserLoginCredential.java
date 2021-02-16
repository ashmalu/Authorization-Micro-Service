package com.cognizant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name="user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserLoginCredential {

	@Id
	@Column(name="userid" ,length=20)
	private String userid;
	@Column(name="upassword",length=20)
	private String upassword;
	@Column(name="uname",length=20)
	private String uname;
	@Column(name="role",length=20)
	private String role;
	private String authToken;

	
	
	
}
