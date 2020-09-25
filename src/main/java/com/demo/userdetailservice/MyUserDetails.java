package com.demo.userdetailservice;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.demo.model.Roles;
import com.demo.model.User;



public class MyUserDetails implements UserDetails {
	
	
	
	
	private String userName;
	private String  password;
	private boolean isActive;
	private List<? extends GrantedAuthority> rolesList ;
	
	public MyUserDetails(User user , Roles role) {
		
		
		
		
		
		
		
		if(user!=null && role!=null)
		{			
			System.out.println(".........user is not null");
			  this.userName = user.getName();
			  this.password =user.getPassword();
			  this.isActive = user.getActive();
			
			/*
			 * this.rolesList = Arrays.stream(role.getRoles().split(","))
			 * .map(SimpleGrantedAuthority::new) .collect(Collectors.toList());
			 */
			  
			  
			
			  
			 String  rolesListA[] =  role.getRoles().split(",");
			 
			 
			 SimpleGrantedAuthority [] GrantedAuthority  = new SimpleGrantedAuthority[rolesListA.length] ;
			 int a[] = null;
			
			  
			 		for (int i=0 ; i<rolesListA.length; i++)
			 		{
			 			
			 			rolesListA[i] = rolesListA[i].trim();
			 			
			 			GrantedAuthority[i] = new SimpleGrantedAuthority(rolesListA[i]);
			 			
			 		}
			 		
			 		this.rolesList = Arrays.asList(GrantedAuthority);
			 		
			
			 		
	}}
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		//return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER") );
		
		return rolesList;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return isActive;
	}

}
