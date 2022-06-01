package com.eheio.pfa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eheio.pfa.dto.ListDataEtudiant;
import com.eheio.pfa.dto.ProfilData;
import com.eheio.pfa.dto.ProfileDataEtudiant;
import com.eheio.pfa.entities.Admin;
import com.eheio.pfa.entities.Conseiller;
import com.eheio.pfa.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
	
	//query pour edit et afficher de le profile avec mon etablissements et niveaux scolaire.
	 @Query(value="select et.id_utilisateur,et.nom_complet,et.email,et.nom_utilisateur,n.libelle libellen,e.libelle libellee from etudiant et"
				+ " inner join etablissement e on et.id_niveau_scolaire=e.id"
				+ " inner join niveau_scolaire n on et.id_etablissement=n.id where et.email=?1",nativeQuery = true)
		        public ProfileDataEtudiant profileEtudiant(String email);
	
	 //query pour lister tous les utilisateur(etudiant) avec ses etablissements et niveau pour etudiant,dans espace admin
	 
	 @Query(value="select et.id_utilisateur,et.nom_complet,et.email,et.nom_utilisateur,n.libelle libellen,e.libelle libellee from etudiant et"
     		+ " inner join etablissement e on et.id_etablissement=e.id "
     		+ " inner join niveau_scolaire n on et.id_niveau_scolaire=n.id",nativeQuery = true)
	 public List<ListDataEtudiant> listEtudiant();


	@Query("SELECT e FROM Etudiant e WHERE e.email = :email")
	Etudiant findByEmail(@Param("email") String email);
	 
}
