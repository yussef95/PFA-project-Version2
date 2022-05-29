package com.eheio.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eheio.pfa.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

}
