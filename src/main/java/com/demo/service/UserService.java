package com.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.demo.model.User;

@Repository
public interface UserService {

		public User createUser(User user);
		public Optional<User> getUserById(int id);
	
}
