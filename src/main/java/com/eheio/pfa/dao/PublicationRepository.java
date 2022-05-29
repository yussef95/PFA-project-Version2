package com.eheio.pfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eheio.pfa.entities.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Integer> {

}
