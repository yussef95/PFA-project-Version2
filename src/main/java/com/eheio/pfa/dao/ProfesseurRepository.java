package com.eheio.pfa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eheio.pfa.dto.ListDataAdmin;
import com.eheio.pfa.dto.ListDataProfesseur;
import com.eheio.pfa.dto.ProfilData;
import com.eheio.pfa.dto.ProfileDataProf;
import com.eheio.pfa.entities.Conseiller;
import com.eheio.pfa.entities.Professeur;
import com.eheio.pfa.entities.Utilisateur;

public interface ProfesseurRepository extends JpaRepository<Professeur, Integer> {
	
    //query pour  afficher et editer le profile avec mon secteur et etablissement dans espace prfesseur

	@Query(value="          SELECT u.id,u.nom_complet,u.email,u.nom_utilisateur,s.libelle libelles,et.libelle libellee from utilisateur u"
	 		+ "	 		    inner join professeur p on u.id=p.id_utilisateur"
	 		+ "				inner join etablissement et on et.id=p.id_etablissement"
	 		+ "			    inner join secteur_orientation s on s.id=p.id_secteur_orientation where email=?1",nativeQuery = true)
    public ProfileDataProf profileProfesseur(String email);
	
	 //query pour lister tous les utilisateur(prof) avec ses etablissements et secteur pour prof,dans espace admin
    
    @Query(value="             SELECT u.id,u.nom_complet,u.email,u.nom_utilisateur,s.libelle libelles,et.libelle libellee,pr.isaprouv"
    		+ "	 		       from utilisateur u inner join professeur pr on u.id=pr.id_utilisateur"
    		+ "	 		       inner join etablissement et on  et.id = pr.id_etablissement Inner join  secteur_orientation s On"
    		+ "                s.id=pr.id_secteur_orientation",nativeQuery = true)
	        public List<ListDataProfesseur> listProf();
    
	Professeur findByEmail(/*@Param("email")*/ String email);

    
    

}
