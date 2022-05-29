package com.eheio.pfa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eheio.pfa.dto.ListDataArticle;
import com.eheio.pfa.dto.ListDataArticleProfile;
import com.eheio.pfa.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
	
	@Query(value="  select ar.id_publication,ar.titre,ar.description,c.nom_complet,c.id_utilisateur from conseiller c "
    		+ "     inner join publication p on p.id_conseiller=c.id_utilisateur "
    		+ "     inner join article ar on ar.id_publication=p.id ",nativeQuery = true)
	        public List<ListDataArticle> ListDataArticle();
	
	//query pour lister les article de le publicateur courant dans espace conseiller.
    @Query(value="     select ar.id_publication,ar.titre,ar.description,c.id_utilisateur from conseiller c "
    		+    "     inner join publication p on p.id_conseiller=c.id_utilisateur "
    		+    "     inner join article ar on ar.id_publication=p.id where c.email=?1 ",nativeQuery = true)
	        public List<ListDataArticleProfile> listDataArticleProfiles (String email);

}
