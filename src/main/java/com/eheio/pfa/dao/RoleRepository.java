package com.eheio.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eheio.pfa.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	Role  findByName(String name);

}
