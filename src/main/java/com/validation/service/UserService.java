package com.validation.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.validation.dto.UserDto;
import com.validation.entity.User;
import com.validation.exception.UserNotFoundException;
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
	
	// Get Data.
	public List<User> findAllUser(){
		List<User> allUsers = userRepository.findAll();
		return allUsers;
		
	}
	
	// Get User By Id.
	public User findUserById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }
    

		// Delete User Record By Id.
	public void deleteUser(Integer id) {
		User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
		userRepository.delete(user);
		
	}
	
	// Update User Record.
	
	public User updateUser(Integer id, UserDto userDto) {
		User existingUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
		existingUser.setAddress(userDto.getAddress());
		existingUser.setName(userDto.getName());
		existingUser.setAge(userDto.getAge());
		existingUser.setEmail(userDto.getEmail());
		
		User updatedUser = userRepository.save(existingUser);
		
		return updatedUser;
		
	}
		
	}

