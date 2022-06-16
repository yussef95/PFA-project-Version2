package com.eheio.pfa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eheio.pfa.dto.ListDataArticle;
import com.eheio.pfa.dto.ListDataArticleProfile;
import com.eheio.pfa.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
	
	@Query(value="           select ar.id_publication,ar.titre,ar.description,u.nom_complet from utilisateur u  "
			+ "              INNER JOIN conseiller con on u.id=con.id_utilisateur"
			+ "    		     inner join publication p on p.id_conseiller=con.id_utilisateur "
			+ "    		     inner join article ar on ar.id_publication=p.id ",nativeQuery = true)
	        public List<ListDataArticle> ListDataArticle();
	
	//query pour lister les article de le publicateur courant dans espace conseiller.
    @Query(value="          select ar.id_publication,ar.titre,ar.description,u.id FROM utilisateur u \r\n"
    		+ "             inner join  Conseiller c on u.id=c.id_utilisateur\r\n"
    		+ "    		    inner join publication p on p.id_conseiller=c.id_utilisateur \r\n"
    		+ "    		    inner join article ar on ar.id_publication=p.id where u.email=?1 ",nativeQuery = true)
	        public List<ListDataArticleProfile> listDataArticleProfiles (String email);

}
