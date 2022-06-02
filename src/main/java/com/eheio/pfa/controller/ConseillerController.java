
package com.eheio.pfa.controller;


import java.util.Collection;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.eheio.pfa.dao.ArticleRepository;
import com.eheio.pfa.dao.ConcoursRepository;
import com.eheio.pfa.dao.ConseillerRepository;
import com.eheio.pfa.dao.EvenementRepository;
import com.eheio.pfa.dao.MessageRepository;
import com.eheio.pfa.dao.PublicationRepository;
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
import com.eheio.pfa.entities.Evenement;
import com.eheio.pfa.entities.Message;
import com.eheio.pfa.entities.Publication;

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
	
	
	//org.slf4j.Logger logger=LoggerFactory.getLogger(ConseillerController.class);
	
	//aficcher tous les publications
	
	//lister tous les  publications(concours,evenements,article) et voir qui est le publicateur.
	
	@GetMapping(value="/conseiller/publications")
	    public String publication(Model model) {
		
		List<Publication> publications=publicationRepository.findAll();
		model.addAttribute("listePublications", publications);
		
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
	public String ajoutere( Evenement e) {
		evenementRepository.save(e);
		return "redirect:/conseiller/publications";
	}
	
	//formulaire d'ajoute de concours
	
	@GetMapping(value="/conseiller/nouveauConcours")
	public String nouveauConcours(Model model) {
		model.addAttribute("concours",new Concours());
		return "nouveauformeConcours";
	}
	
	@PostMapping(value="/conseiller/ajoutec")
	public String ajouterc( Concours c) {
		
		publicationRepository.save(c);
		return "redirect:/conseiller/publications";
	}
	
	//formulaire d'ajoute de l'article
	
	@GetMapping(value="/conseiller/nouveauArticle")
	public String nouveauArticle(Model model) {
	model.addAttribute("article",new Article());
	return "nouveauformeArticle";
		}
	
	@PostMapping(value="/conseiller/ajoutea")
	public String ajoutera( Article a) {
		
		publicationRepository.save(a);
		return "redirect:/conseiller/publications";
	}
	
	   //editer un evenement
	
	   @GetMapping(value = "/conseiller/editee/{idEvenement}")

	    public String editeeforme(Model model,@PathVariable int idEvenement) {
		Optional<Evenement> e=evenementRepository.findById(idEvenement);
		model.addAttribute("evenement", e.get());
		return "editerevenement";	
	    }
	   
	    @PostMapping(value = "/conseiller/edite/{idEvenement}")
	    public String editee(  Evenement e,@PathVariable int idEvenement) {
	    	
			Optional<Evenement> evbag=evenementRepository.findById(idEvenement);
			Evenement evenement=evbag.get();
			evenement.setConseiller(e.getConseiller());
			evenement.setTitre(e.getTitre());
			evenement.setDescription(e.getDescription());
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
		    public String editea( Article a,@PathVariable int id) {
		    	
				Optional<Article> avbag=articleRepository.findById(id);
				Article article=avbag.get();
				article.setConseiller(a.getConseiller());
				article.setTitre(a.getTitre());
				article.setDescription(a.getDescription());
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
		    public String editec( Concours c,@PathVariable int idConcours) {
		    	
				Optional<Concours> cvbag=concoursRepository.findById(idConcours);
				Concours concours=cvbag.get();
				concours.setConseiller(c.getConseiller());
				concours.setTitre(c.getTitre());
				concours.setDescription(c.getDescription());
				concoursRepository.save(concours);
				return "redirect:/conseiller/publications";

		    }
	
		    //Affichage de profile et voir mes publication
		    
		    @GetMapping(value = "/conseiller/monProfile")
		    public String profile(String email,Model model) {
		    ProfilData profilData=conseillerRepository.profileConseiller(email);
		    //logger.info(profilData.getEmail());
		    model.addAttribute("profilData", profilData);
		    
		    //voir mes publication
		    List<ListDataEvenementProfile> dataEvenementProfiles=
		    evenementRepository.listDataEvenementProfiles(email);
		    model.addAttribute("listeEvenements", dataEvenementProfiles);
		    
		    List<ListDataArticleProfile> dataArticleProfiles=
	        articleRepository.listDataArticleProfiles(email);
		    model.addAttribute("listeArticles", dataArticleProfiles);
		    
		    List<ListaDataConcoursProfile> dataConcoursProfiles=
			concoursRepository.listaDataConcoursProfiles(email);
		    model.addAttribute("listeConcours", dataConcoursProfiles);
		
		    return "ProfileConseiller";
		    	
		    }
		    //editer Mon profile
		    
		    @GetMapping(value = "/conseiller/editeProfilec/{id}")
		    public String editeConseiller(Model model,@PathVariable int id) {
		    	Optional<Conseiller> c=conseillerRepository.findById(id);
		    	model.addAttribute("conseiller", c.get());
		    	return "editProfileConseiller";
		    }
		    
		    @PostMapping(value = "/conseiller/editeProfilec/{id}")
		    public String editeConseiller(Conseiller c, @PathVariable int id) {
		    	
		    	   Optional<Conseiller> cbag=conseillerRepository.findById(id);
		    	   Conseiller conseiller=cbag.get();
		    	   conseiller.setNomComplet(c.getNomComplet());
		    	   conseiller.setnomUtilisateur(c.getnomUtilisateur());
		    	   conseiller.setOrientation(c.getOrientation());
		    	   conseiller.setEtablissement(c.getEtablissement());
		    	   conseillerRepository.save(conseiller);
		    	   return "redirect:/conseiller/monProfile";
		    }
		    
		    //lister les messages pour le conseiller
		    @GetMapping(value = "/conseiller/messagerie")
		    public String messagerie (Model model,String email) {
		    	List<Message> messages=messageRepository.messages(email);
		    	model.addAttribute("message",messages );
		    	return "messagerie";
		    }
		    
	
}
