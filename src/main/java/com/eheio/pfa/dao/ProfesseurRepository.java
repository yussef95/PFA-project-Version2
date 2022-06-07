package com.eheio.pfa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eheio.pfa.dto.ListDataAdmin;
import com.eheio.pfa.dto.ListDataProfesseur;
import com.eheio.pfa.dto.ProfilData;
import com.eheio.pfa.dto.ProfileDataProf;
import com.eheio.pfa.entities.Professeur;

public interface ProfesseurRepository extends JpaRepository<Professeur, Integer> {
	
    //query pour  afficher et editer le profile avec mon secteur et etablissement dans espace prfesseur

	@Query(value="select p.id_utilisateur,p.nom_complet,p.email,p.nom_utilisateur,s.libelle libelles,e.libelle libellee from professeur p"
    		+ " inner join etablissement e on p.id_etablissement=e.id "
    		+ " inner join secteur_orientation s on p.id_secteur_orientation=s.id where p.email=?1",nativeQuery = true)
    public ProfileDataProf profileProfesseur(String email);
	
	 //query pour lister tous les utilisateur(prof) avec ses etablissements et secteur pour prof,dans espace admin
    
    @Query(value="select p.id_utilisateur,p.nom_complet,p.email,p.nom_utilisateur,p.isaprouv,s.libelle libelles,e.libelle libellee from professeur p"
    		+ " inner join etablissement e on p.id_etablissement=e.id "
    		+ " inner join secteur_orientation s on p.id_secteur_orientation=s.id",nativeQuery = true)
	        public List<ListDataProfesseur> listProf();

}
