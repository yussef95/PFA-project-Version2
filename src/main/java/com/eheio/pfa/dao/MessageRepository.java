package com.eheio.pfa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eheio.pfa.dto.ProfilDataConseillerPourEtudiant;
import com.eheio.pfa.entities.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {
	
	//afficher les message pour le conseiller  dans espace conseiller
	  @Query(value="select * from message m where m.id_conseiller="
	  		+      "(select id_utilisateur from conseiller where email=?1)",nativeQuery = true)
	  public List<Message> messages(String email);
  	   
	

}
