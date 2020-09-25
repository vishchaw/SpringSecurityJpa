package com.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.demo.model.Roles;


@Repository
public interface RoleService {
	
	public Optional<Roles> getRolesById(int id);
	public Roles createRoles(Roles role);

}
