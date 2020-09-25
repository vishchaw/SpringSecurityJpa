package com.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Roles;
import com.demo.repository.RolesRepository;


@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RolesRepository dao;

	@Override
	public Optional<Roles> getRolesById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Roles createRoles(Roles role) {
		// TODO Auto-generated method stub
		return dao.save(role);
	}

}
