package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Roles {
	
	@Id
	private int id;
	private String roles;
	
	
	public Roles(int id, String roles) {
		super();
		this.id = id;
		this.roles = roles;
	}
	public int getId() {
		return id;
	}
	public Roles() {
		super();
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	

}
