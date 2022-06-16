package com.eheio.pfa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eheio.pfa.dto.ListDataArticle;
import com.eheio.pfa.dto.ListDataConcours;
import com.eheio.pfa.dto.ListaDataConcoursProfile;
import com.eheio.pfa.entities.Concours;
import com.eheio.pfa.entities.Conseiller;

public interface ConcoursRepository extends JpaRepository<Concours, Integer> {
	
	@Query(value="           select cc.id_publication,cc.titre,cc.description,u.nom_complet from utilisateur u  "
			+ "              INNER JOIN conseiller con on u.id=con.id_utilisateur"
			+ "    		     inner join publication p on p.id_conseiller=con.id_utilisateur "
			+ "    		     inner join concours cc on cc.id_publication=p.id ",nativeQuery = true)
	        public List<ListDataConcours> listDataConcours();
	
	 //query pour lister les concours de le publicateur courant dans espace conseiller.
    @Query(value="          select cc.id_publication,cc.titre,cc.description,u.id FROM utilisateur u "
    		+ "             inner join  Conseiller c on u.id=c.id_utilisateur"
    		+ "    		    inner join publication p on p.id_conseiller=c.id_utilisateur "
    		+ "    		    inner join concours cc on cc.id_publication=p.id where u.email=?1",nativeQuery = true)
	        public List<ListaDataConcoursProfile> listaDataConcoursProfiles (String email);
}
