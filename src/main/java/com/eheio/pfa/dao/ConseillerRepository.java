package com.eheio.pfa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eheio.pfa.dto.ListDataAdmin;
import com.eheio.pfa.dto.ProfilData;
import com.eheio.pfa.dto.ProfilDataConseillerPourEtudiant;
import com.eheio.pfa.entities.Conseiller;

public interface ConseillerRepository extends JpaRepository<Conseiller, Integer> {
	
	
	       //query pour  afficher et editer le profile avec mon secteur et etablissement dans espace conseiller
	
	        @Query(value="select c.id_utilisateur,c.nom_complet,c.email,c.nom_utilisateur,s.libelle libelles,e.libelle libellee from conseiller c"
	        		+ " inner join etablissement e on c.id_etablissement=e.id "
	        		+ " inner join secteur_orientation s on c.id_secteur_orientation=s.id where c.email=?1",nativeQuery = true)
	        public ProfilData profileConseiller(String email);
	       
	        
	      //query pour lister tous les utilisateur(conseillers) avec ses etablissements et secteur pour conseillers,dans espace admin
	      
	        @Query(value="select c.id_utilisateur,c.nom_complet,c.email,c.nom_utilisateur,c.isaprouv,s.libelle libelles,e.libelle libellee from conseiller c"
	        		+ " inner join etablissement e on c.id_etablissement=e.id "
	        		+ " inner join secteur_orientation s on c.id_secteur_orientation=s.id",nativeQuery = true)
	    	        public List<ListDataAdmin> listConseiller();
	
	        //query pour afficher les conseillers qui ont le meme etablissement de l'etudiant connécté
	        //avec ses secteurs d'orientation et etablissement dans espace etudiant
	        
	        @Query(value="select c.id_utilisateur,c.nom_complet,c.email,c.nom_utilisateur,s.libelle libelles,e.libelle libellee from conseiller c"
	        		+ " inner join etablissement e on c.id_etablissement=e.id "
	        		+ " inner join secteur_orientation s on c.id_secteur_orientation=s.id where"
	        		+ " c.id_etablissement=(select et.id_etablissement from etudiant et where et.email=?1 )",nativeQuery = true)
	    	        public List<ProfilDataConseillerPourEtudiant> profileConseillerEtudiant(String email);
}
