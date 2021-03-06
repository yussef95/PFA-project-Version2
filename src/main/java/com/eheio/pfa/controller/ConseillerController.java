
package com.eheio.pfa.controller;


import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.eheio.pfa.dao.ArticleRepository;
import com.eheio.pfa.dao.ConcoursRepository;
import com.eheio.pfa.dao.ConseillerRepository;
import com.eheio.pfa.dao.EtablissementRepository;
import com.eheio.pfa.dao.EvenementRepository;
import com.eheio.pfa.dao.MessageRepository;
import com.eheio.pfa.dao.PublicationRepository;
import com.eheio.pfa.dao.SecteurOrientationRepository;
import com.eheio.pfa.dto.ListDataArticle;
import com.eheio.pfa.dto.ListDataArticleProfile;
import com.eheio.pfa.dto.ListDataConcours;
import com.eheio.pfa.dto.ListDataEvenement;
import com.eheio.pfa.dto.ListDataEvenementProfile;
import com.eheio.pfa.dto.ListaDataConcoursProfile;
import com.eheio.pfa.dto.ProfilData;
import com.eheio.pfa.entities.Article;
import com.eheio.pfa.entities.Concours;
import com.eheio.pfa.entities.Conseiller;
import com.eheio.pfa.entities.Etablissement;
import com.eheio.pfa.entities.Evenement;
import com.eheio.pfa.entities.Message;
import com.eheio.pfa.entities.Publication;
import com.eheio.pfa.entities.SecteurOrientation;


@Controller
public class ConseillerController {
	
	@Autowired
	private ConseillerRepository conseillerRepository;

	@Autowired
	private PublicationRepository publicationRepository;
	@Autowired
	private EvenementRepository evenementRepository;
	@Autowired
	private ConcoursRepository concoursRepository;
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private EtablissementRepository etablissementRepository;
	@Autowired
	private SecteurOrientationRepository orientationRepository;
	
	
	//org.slf4j.Logger logger=LoggerFactory.getLogger(ConseillerController.class);
	
	//aficcher tous les publications
	
	//lister tous les  publications(concours,evenements,article) et voir qui est le publicateur.
	
	    
	    @GetMapping(value="/conseiller/publications")
	    public String publication(Model model) {
		/*
		List<Publication> publications=publicationRepository.findAll();
		model.addAttribute("listePublications", publications);
		*/

		List<ListDataEvenement> evenements=evenementRepository.ListDataEvenement();
		model.addAttribute("listeEvenements", evenements);
		
		List<ListDataConcours> concours=concoursRepository.listDataConcours();
		model.addAttribute("listeConcours", concours);
		
		List<ListDataArticle> articles=articleRepository.ListDataArticle();
		model.addAttribute("listeArticles", articles);
		return "publicationc";
	}
	
	//supprimer un publication
	
	    
	    @GetMapping(value ="/conseiller/deletepc")
	    public String deletep(int id) {
		publicationRepository.deleteById(id);
		return "redirect:/conseiller/monProfile";
	}
	    
	
	
	//supprimer un  article
	 
	    @GetMapping(value ="/conseiller/deleteac")
		public String deletea(int id) {
		articleRepository.deleteById(id);
		return "redirect:/conseiller/monProfile";
		}

	//supprimer un  evenement

	    @GetMapping(value ="/conseiller/deleteevc")
		public String deleteev(int id) {
		evenementRepository.deleteById(id);
		return "redirect:/conseiller/monProfile";
		}

	//supprimer un  concours

	   @GetMapping(value ="/conseiller/deletecnc")
		public String deletecn(int id) {
		concoursRepository.deleteById(id);
		return "redirect:/conseiller/monProfile";
		}
	
	//ajouter un publication(Evenement,Concours,Article)
	
	@GetMapping(value="/conseiller/nouveauEvenement")
	public String nouveauEvenement(Model model) {
	model.addAttribute("evenement",new Evenement());
	return "nouveauformeEvenement";
	}
	@PostMapping(value="/conseiller/ajoutee")
	public String ajoutere(@Valid Evenement e,BindingResult result,Authentication authentication) {
	if(result.hasErrors()) return "nouveauformeEvenement";
	Conseiller c=conseillerRepository.findByEmail(authentication.getName());
	e.setConseiller(c);
	if(c.isIsaprouv()==true) {
	publicationRepository.save(e);
	return "redirect:/conseiller/publications";
	}
	else 
	{
	return "403";
	}
	
	}
	
	
	
	//formulaire d'ajoute de concours
	
	@GetMapping(value="/conseiller/nouveauConcours")
	public String nouveauConcours(Model model) {
	model.addAttribute("concours",new Concours());
	return "nouveauformeConcours";
	}
	
	@PostMapping(value="/conseiller/ajoutec")
	public String ajouterc(@Valid Concours cn,BindingResult result,Authentication authentication) {
	if(result.hasErrors()) return "nouveauformeConcours";
	Conseiller c=conseillerRepository.findByEmail(authentication.getName());
	cn.setConseiller(c);
	if(c.isIsaprouv()==true) {
		publicationRepository.save(cn);
		return "redirect:/conseiller/publications";
		}
		else 
		{
		return "403";
		}
	}
	
	//formulaire d'ajoute de l'article
	
	@GetMapping(value="/conseiller/nouveauArticle")
	public String nouveauArticle(Model model) {
	model.addAttribute("article",new Article());
	return "nouveauformeArticle";
		}
	
	@PostMapping(value="/conseiller/ajoutea")
	public String ajoutera(@Valid Article a,BindingResult result,Authentication authentication) {
	if(result.hasErrors()) return "nouveauformeArticle";
	Conseiller c=conseillerRepository.findByEmail(authentication.getName());
	a.setConseiller(c);
	if(c.isIsaprouv()==true) {
		publicationRepository.save(a);
		return "redirect:/conseiller/publications";
		}
		else 
		{
		return "403";
		}
	}
	
	//editer un evenement
	
	    @GetMapping(value = "/conseiller/editee/{idEvenement}")
	    public String editeeforme(Model model,@PathVariable int idEvenement) {
		Optional<Evenement> e=evenementRepository.findById(idEvenement);
		model.addAttribute("evenement", e.get());
		return "editerevenement";	
	    }
	   
	        @PostMapping(value = "/conseiller/edite/{idEvenement}")
	        public String editee( @Valid Evenement e,@PathVariable int idEvenement,BindingResult result) {
			Optional<Evenement> evbag=evenementRepository.findById(idEvenement);
			Evenement evenement=evbag.get();
			evenement.setConseiller(e.getConseiller());
			evenement.setTitre(e.getTitre());
			evenement.setDescription(e.getDescription());
			if(result.hasErrors()) return "editerevenement";		
			evenementRepository.save(evenement);
			return "redirect:/conseiller/publications";

	    }
	
	        //editer un article

		    @GetMapping(value = "/conseiller/editea/{id}")
		    public String editeaforme(Model model,@PathVariable int id) {
			Optional<Article> a=articleRepository.findById(id);
			model.addAttribute("article", a.get());
			return "editerarticle";	
		    }
		    
		    @PostMapping(value = "/conseiller/edita/{id}")
		    public String editea(@Valid Article a,@PathVariable int id,BindingResult result) {
		    	
			Optional<Article> avbag=articleRepository.findById(id);
			Article article=avbag.get();
            article.setConseiller(a.getConseiller());
			article.setTitre(a.getTitre());
			article.setDescription(a.getDescription());
			if(result.hasErrors()) return "editerarticle";		
			articleRepository.save(article);
			return "redirect:/conseiller/publications";

		    }
		  
		   //editer un concours
			
		    @GetMapping(value = "/conseiller/editec/{idConcours}")
		    public String editecforme(Model model,@PathVariable int idConcours) {
			Optional<Concours> c =concoursRepository.findById(idConcours);
			model.addAttribute("concours", c.get());
			return "editerconcours";	
		    }
		    
		        @PostMapping(value = "/conseiller/editc/{idConcours}")
		        public String editec(@Valid Concours c,@PathVariable int idConcours,BindingResult result) {
		    	
				Optional<Concours> cvbag=concoursRepository.findById(idConcours);
				Concours concours=cvbag.get();
				concours.setConseiller(c.getConseiller());
				concours.setTitre(c.getTitre());
				concours.setDescription(c.getDescription());
				if(result.hasErrors()) return "editerconcours";		
				concoursRepository.save(concours);
				return "redirect:/conseiller/publications";

		    }
	
		    //Affichage de profile et voir mes publication
		    /*
		        Authentication authentication    
		        authentication.getName()
		    */
		        
		    @GetMapping(value = "/conseiller/monProfile")
		    public String profile(Model model,Authentication authentication) {
		    ProfilData profilData=conseillerRepository.profileConseiller(authentication.getName());
		    //logger.info(profilData.getEmail());
		    model.addAttribute("profilData", profilData);
		    
		    //voir mes publication
		    List<ListDataEvenementProfile> dataEvenementProfiles=
		    evenementRepository.listDataEvenementProfiles(authentication.getName());
		    model.addAttribute("listeEvenements", dataEvenementProfiles);
		    
		    List<ListDataArticleProfile> dataArticleProfiles=
	        articleRepository.listDataArticleProfiles(authentication.getName());
		    model.addAttribute("listeArticles", dataArticleProfiles);
		    
		    List<ListaDataConcoursProfile> dataConcoursProfiles=
			concoursRepository.listaDataConcoursProfiles(authentication.getName());
		    model.addAttribute("listeConcours", dataConcoursProfiles);
		
		    return "ProfileConseiller";
		    	
		    }
		    //editer Mon profile
		    
		    @GetMapping(value = "/conseiller/editeProfilec/{id}")
		    public String editeConseiller(Model model,@PathVariable int id) {
		    Optional<Conseiller> c=conseillerRepository.findById(id);
	    	List<Etablissement> etablissements = etablissementRepository.findAll();
			List<SecteurOrientation> secteurOrientations=orientationRepository.findAll();
			model.addAttribute("etablissement",etablissements);
			model.addAttribute("secteurOrientations",secteurOrientations);
		    model.addAttribute("conseiller", c.get());
		    return "editProfileConseiller";
		    }
		    
		          @PostMapping(value = "/conseiller/editeProfilec/{id}")
		           public String editeConseiller(@Valid Conseiller c, @PathVariable int id,BindingResult result) {
		    	
		           Optional<Conseiller> cbag=conseillerRepository.findById(id);
		     	   Conseiller conseiller=cbag.get();
		    	   conseiller.setNomComplet(c.getNomComplet());
		    	   conseiller.setNomUtilisateur(c.getNomUtilisateur());
		    	   conseiller.setOrientation(c.getOrientation());
		    	   conseiller.setEtablissement(c.getEtablissement());
				   if(result.hasErrors()) return "editProfileConseiller";		
		    	   conseillerRepository.save(conseiller);
		    	   return "redirect:/conseiller/monProfile";
		    }
		    
		    //lister les messages pour le conseiller
		    @GetMapping(value = "/conseiller/messagerie")
		    public String messagerie (Model model,Authentication authentication) {
		    List<Message> messages=messageRepository.messages(authentication.getName());
		    model.addAttribute("message",messages );
		    return "messagerie";
		    }
		    
	
}
