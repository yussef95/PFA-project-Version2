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
import com.eheio.pfa.entities.Utilisateur;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
	
	//query pour edit et afficher de le profile avec mon etablissements et niveaux scolaire.
	 @Query(value="         select u.id,u.nom_complet,u.email,u.nom_utilisateur,n.libelle libellen,et.libelle libellee"
	 		+ "	 			from utilisateur u inner join etudiant etud on u.id=etud.id_utilisateur"
	 		+ "	 		    inner join etablissement et on  et.id = etud.id_etablissement"
	 		+ "             Inner join  niveau_scolaire n On"
	 		+ "	 	        n.id=etud.id_niveau_scolaire WHERE email=?1",nativeQuery = true)
		        public ProfileDataEtudiant profileEtudiant(String email);
	
	 //query pour lister tous les utilisateur(etudiant) avec ses etablissements et niveau pour etudiant,dans espace admin
	 
	 @Query(value=" select u.id,u.nom_complet,u.email,u.nom_utilisateur,n.libelle libellen,et.libelle libellee"
	 		+     "	from utilisateur u inner join etudiant etud on u.id=etud.id_utilisateur"
	 		+     "	inner join etablissement et on  et.id = etud.id_etablissement Inner join  niveau_scolaire n On"
	 		+     " n.id=etud.id_niveau_scolaire",nativeQuery = true)
	 public List<ListDataEtudiant> listEtudiant();
	 
		Etudiant findByEmail(/*@Param("email")*/ String email);



	
	 
}
