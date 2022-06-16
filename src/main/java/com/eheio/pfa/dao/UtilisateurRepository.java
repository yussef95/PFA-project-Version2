package com.eheio.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eheio.pfa.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
	
	//@Query("SELECT u FROM Utilisateur u WHERE u.email = :email")
	Utilisateur findByEmail(/*@Param("email")*/ String email);
}
