package com.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.demo.userdetailservice.MyUserDetailService;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	MyUserDetailService service; 

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * auth.inMemoryAuthentication() .withUser("vishal") .password("vishal")
		 * .roles("USER") .and() .withUser("admin") .password("admin") .roles("ADMIN");
		 */
		
		try {
		auth.userDetailsService(service);
		}
		catch (UsernameNotFoundException e ) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
	
	@Bean
	public PasswordEncoder getpassword()
	{
		
		
		return NoOpPasswordEncoder.getInstance();
	}



	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().httpBasic().and().authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/user").hasAnyRole("USER" , "ADMIN")
		.antMatchers("/createuser").permitAll()
		.antMatchers("/createroles").permitAll()
		.antMatchers("/home").permitAll()
		.antMatchers("/boss").permitAll()
		
		.and().formLogin();
	}
	
	

}
