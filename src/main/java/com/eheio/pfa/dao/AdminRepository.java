package com.eheio.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eheio.pfa.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	
	//@Query
	//("select a from Admin a where a.email=?1")
    Admin findByEmail(String email);
	

}
