package com.validation.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.validation.dto.UserDto;
import com.validation.entity.User;
import com.validation.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public ResponseEntity<?> createUser(@Valid @RequestBody UserDto dto, BindingResult result) {

		if (result.hasErrors()) {
			Map<String, String> errors = new HashMap<String, String>();
			for (FieldError error : result.getFieldErrors()) {
				errors.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		}

		User user = new User();

		user.setName(dto.getName());
		user.setAddress(dto.getAddress());
		user.setEmail(dto.getEmail());
		user.setAge(dto.getAge());
		
		userService.saveUser(user);
		
		
		return new ResponseEntity<>("User is valid & Saved Successfully",HttpStatus.OK);

	}
}
