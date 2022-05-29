package com.eheio.pfa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eheio.pfa.dto.ListDataAdmin;
import com.eheio.pfa.dto.ListDataArticleProfile;
import com.eheio.pfa.dto.ListDataEvenement;
import com.eheio.pfa.dto.ListDataEvenementProfile;
import com.eheio.pfa.dto.ListaDataConcoursProfile;
import com.eheio.pfa.entities.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement, Integer> {
	
	//query pour lister tous les evenements  avec le nom complet de publicateur,dans espace admin
    
    @Query(value="  select ev.id_publication,ev.titre,ev.description,c.nom_complet,c.id_utilisateur from conseiller c "
    		+ "     inner join publication p on p.id_conseiller=c.id_utilisateur "
    		+ "     inner join evenement ev on ev.id_publication=p.id ",nativeQuery = true)
	        public List<ListDataEvenement> ListDataEvenement();
   
    //query pour lister les evenement de le publicateur courant dans espace conseiller.
    @Query(value="     select ev.id_publication,ev.titre,ev.description,c.id_utilisateur from conseiller c "
    		+    "     inner join publication p on p.id_conseiller=c.id_utilisateur "
    		+    "     inner join evenement ev on ev.id_publication=p.id where c.email=?1 ",nativeQuery = true)
	        public List<ListDataEvenementProfile> listDataEvenementProfiles(String email);
    
   
    
    
    
    
    
       
}
