package com.demo.contoller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Roles;
import com.demo.model.User;
import com.demo.service.RoleService;
import com.demo.service.UserService;

@RestController
public class MainController {
	
	
	@Autowired
	UserService dao;
	
	
	@Autowired
	RoleService daoRole;
	
	@GetMapping(path="/home")
	public String welcomeMsg()
	{
		System.out.println("Welcome to Spring security");
		return "Welcome to Spring security";
		
	}
	
	@GetMapping(path="/user")
	public String welcomeUser()
	{
		System.out.println("Welcome User !to Spring security ");
		return "Welcome User !to Spring security";
		
	}
	
	@GetMapping(path="/admin")
	public String welcomeAdmin()
	{
		System.out.println("Welcome Admin ! to Spring security");
		return "Welcome  Admin ! to Spring security";
		
	}
	
	@GetMapping(path="/boss/{id}")
	public Optional<User> welcomeBoss(@PathVariable int id)
	{
		Optional<User> user = dao.getUserById(id);
		
		return user;
		
	}
	
	@PostMapping(path="/createuser")
	public User createUser(@RequestBody User user)
	{
		System.out.println("creatig user ...");
		return dao.createUser(user);
		
	}
	
	@PostMapping(path="/createroles")
	public Roles createRole(@RequestBody Roles role)
	{
		System.out.println("creatig roles ...");
		return daoRole.createRoles(role);
		
	}
	
	

}
