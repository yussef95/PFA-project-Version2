package com.eheio.pfa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eheio.pfa.dto.ListDataCours;
import com.eheio.pfa.dto.ListDataCoursAll;
import com.eheio.pfa.dto.ListDataEvenement;
import com.eheio.pfa.dto.ListDataEvenementProfile;
import com.eheio.pfa.dto.ProfilDataConseillerPourEtudiant;
import com.eheio.pfa.entities.Cours;

public interface CoursRepository extends JpaRepository<Cours, Integer>

{

	//query pour lister les cours de le publicateur courant dans espace prof.
    @Query(value="     select cr.id,cr.titre,cr.description,p.id_utilisateur from professeur p "
    		+    "     inner join cours cr on cr.id_professeur=p.id_utilisateur where p.email=?1 ",nativeQuery = true)
    
	        public List<ListDataCours> listDataCours(String email);
    
   //query pour lister tous les cours  avec le nom complet de publicateur,
     
    @Query(value="  select cr.id,cr.titre,cr.description,p.nom_complet,p.id_utilisateur from professeur p "
    		+ "     inner join cours cr on cr.id_professeur=p.id_utilisateur",nativeQuery = true)
	        public List<ListDataCoursAll> dataCoursAlls();
    
    //query pour afficher les conseillers qui ont le meme etablissement de l'etudiant connécté
    //avec ses secteurs d'orientation et etablissement dans espace etudiant
    
    //afiicher les cours pour l'etudiant publié par le professeur (etabllissement prof=etabllissement etud)
    
    /*
    @Query(value="select cr.id,cr.titre,cr.description from cours cr"
    		+ " inner join etablissement e on cr.id_etablissement=e.id "
    		+ "  where"
    		+ "  cr.id_etablissement=(select et.id_etablissement from etudiant et where et.email=?1 )",nativeQuery = true)
    */
	
}
