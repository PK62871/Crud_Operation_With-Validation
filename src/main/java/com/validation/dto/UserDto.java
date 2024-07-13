package com.validation.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserDto {
	
	private Integer id;
	
	@NotEmpty(message = "Please Fill The Name Field ")
	private String name;
	
	@NotEmpty(message = "Please Fill The Address Field")
	private String address;
	
	@Email(message = "Email Should Be well Formated")
	private String email;
	
	@Min(18)
	@Max(60)
	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public UserDto(Integer id, @NotNull String name, @NotNull String address, @Email String email,
			@Min(18) @Max(60) Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.age = age;
	}

	public UserDto() {
	
	}
	
	

}
