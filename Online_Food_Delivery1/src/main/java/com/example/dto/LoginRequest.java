package com.example.dto;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
	
	@NotBlank(message = "email is required")
	private String email;
	@NotBlank(message = "password is required")
	private String password;
	public LoginRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginRequest(@NotBlank(message = "email is required") String email,
			@NotBlank(message = "password is required") String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginRequest [email=" + email + ", password=" + password + "]";
	}
	
	

}
