package com.eheio.pfa.dao;

import org.hibernate.mapping.Value;
import org.springframework.data.jpa.repository.JpaRepository;

import com.eheio.pfa.entities.Admin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends JpaRepository<Admin, Integer> {


  
	

}
