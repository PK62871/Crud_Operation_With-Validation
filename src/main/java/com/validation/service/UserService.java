package com.validation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.validation.entity.User;
import com.validation.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	//save User.
	
	public User saveUser(User user) {
		User saved = userRepository.save(user);
		return saved;
		
	}
}
