package com.eheio.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eheio.pfa.entities.Etablissement;

public interface EtablissementRepository extends JpaRepository<Etablissement, Integer> {

}
