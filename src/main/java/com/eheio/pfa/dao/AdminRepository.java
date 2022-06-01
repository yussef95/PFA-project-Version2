package com.eheio.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eheio.pfa.entities.Admin;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends JpaRepository<Admin, Integer> {


  @Query("SELECT a FROM Admin a WHERE a.email = :email")
    Admin findByEmail(@Param("email")  String email);
	

}
