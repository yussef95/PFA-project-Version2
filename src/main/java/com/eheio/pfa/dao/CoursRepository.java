package com.eheio.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eheio.pfa.entities.Cours;

public interface CoursRepository extends JpaRepository<Cours, Integer> {

}
