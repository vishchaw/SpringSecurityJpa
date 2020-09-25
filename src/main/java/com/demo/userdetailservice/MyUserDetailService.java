package com.demo.userdetailservice;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.model.Roles;
import com.demo.model.User;
import com.demo.service.RoleService;
import com.demo.service.UserService;


@Service
public class MyUserDetailService implements UserDetailsService{
	
	@Autowired
	UserService userservice;
	
	@Autowired
	RoleService roleservice;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		
		
		System.out.println(".............username" + username);
		
		// TODO Auto-generated method stub
		int id=0;
		 switch (username){
		 
		 case "vishal" :
			 id=3;
			 break;
		 case "admin" :
			 id=1;
			 break;
		 case "user" :
			 id=2;
			 break;
		 case "under" :
			 id=5;
			 break;
		 }
		 
		 Optional<User> optionaluser = userservice.getUserById(id);
		
		 Optional<Roles> optionalrole = roleservice.getRolesById(id);
		
		 
		 optionaluser.orElseThrow(()-> new UsernameNotFoundException("user doesn't exist"));
		 optionalrole.orElseThrow(()-> new UsernameNotFoundException("role doesn't exist"));
		 
		 User user = optionaluser.get();
		 Roles role = optionalrole.get();
		 
		MyUserDetails userdetails =  new MyUserDetails(user ,role);
		
		
		
		return userdetails;
				
	}

}
