package com.eheio.pfa.dao;

import java.util.List;

import com.eheio.pfa.entities.Etudiant;
import com.eheio.pfa.entities.Utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eheio.pfa.dto.ListDataAdmin;
import com.eheio.pfa.dto.ProfilData;
import com.eheio.pfa.dto.ProfilDataConseillerPourEtudiant;
import com.eheio.pfa.entities.Conseiller;

public interface ConseillerRepository extends JpaRepository<Conseiller, Integer> {
	
	
	       //query pour  afficher et editer le profile avec mon secteur et etablissement dans espace conseiller
	
	        @Query(value="          SELECT u.id,u.nom_complet,u.email,u.nom_utilisateur,s.libelle libelles,et.libelle libellee from utilisateur u"
	    	 		+ "	 		    inner join conseiller c on u.id=c.id_utilisateur"
	    	 		+ "				inner join etablissement et on et.id=c.id_etablissement"
	    	 		+ "			    inner join secteur_orientation s on s.id=c.id_secteur_orientation where email=?1",nativeQuery = true)
	        public ProfilData profileConseiller(String email);
	       
	         
	        
	      //query pour lister tous les utilisateur(conseillers) avec ses etablissements et secteur pour conseillers,dans espace admin
	      
	        @Query(value=" SELECT u.id,u.nom_complet,u.email,u.nom_utilisateur,s.libelle libelles,et.libelle libellee,con.isaprouv"
	        		+ "	   from utilisateur u inner join conseiller con on u.id=con.id_utilisateur"
	        		+ "	   inner join etablissement et on  et.id = con.id_etablissement Inner join  secteur_orientation s On"
	        		+ "    s.id=con.id_secteur_orientation",nativeQuery = true)
	    	        public List<ListDataAdmin> listConseiller();
	
	        //query pour afficher les conseillers qui ont le meme etablissement de l'etudiant connécté
	        //avec ses secteurs d'orientation et etablissement dans espace etudiant
	        
	        @Query(value="select u.id,u.nom_complet,u.email,u.nom_utilisateur,s.libelle libelles,e.libelle libellee from utilisateur u"
	        		+ "	  inner join conseiller con on u.id=con.id_utilisateur"
	        		+ "	  inner join etablissement e on e.id=con.id_etablissement "
	        		+ "	  inner join secteur_orientation s on s.id=con.id_secteur_orientation where"
	        		+ "	  con.id_etablissement=(select et.id_etablissement from etudiant et"
	        		+ "   INNER JOIN utilisateur u on u.id=et.id_utilisateur where"
	        		+ "   u.email=?1)",nativeQuery = true)
	    	        public List<ProfilDataConseillerPourEtudiant> profileConseillerEtudiant(String email);
	    	Conseiller findByEmail(/*@Param("email")*/ String email);

	       
	
}
