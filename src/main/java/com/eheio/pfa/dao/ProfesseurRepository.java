package com.eheio.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eheio.pfa.entities.Professeur;

public interface ProfesseurRepository extends JpaRepository<Professeur, Integer> {

}
