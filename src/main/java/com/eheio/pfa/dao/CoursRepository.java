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
    @Query(value="select c.id,c.titre,c.description  from professeur p inner join utilisateur u on u.id=p.id_utilisateur inner join cours c on c.id_professeur=u.id where u.email=?1",nativeQuery = true)
    
	public List<ListDataCoursAll> listDataCoursAlls(String email);
    
   
    
    
    
    //afiicher les cours pour l'etudiant publié par le professeur (etabllissement prof=etabllissement etud)
    
    
    @Query(value="            Select c.titre,c.description,nom_complet from utilisateur u inner join professeur p on u.id=p.id_utilisateur Inner join\r\n"
    		+ "    		      cours c on c.id_professeur=u.id  where  p.id_etablissement=\r\n"
    		+ "    		      (select et.id_etablissement from etudiant et  INNER JOIN utilisateur u on u.id=et.id_utilisateur where u.email=?1)",nativeQuery = true)
    public List<ListDataCours> listDataCours(String email);
    
	
}
