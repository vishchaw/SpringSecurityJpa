package com.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.User;
import com.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository dao;

	@Override
	public User createUser(User user) {
		
		return dao.save(user);
	}

	@Override
	public Optional<User> getUserById(int id) {
		
		return  dao.findById(id);
	}

}
