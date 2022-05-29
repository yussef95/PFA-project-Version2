
package com.eheio.pfa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.eheio.pfa.dao.AdminRepository;
import com.eheio.pfa.dao.ArticleRepository;
import com.eheio.pfa.dao.ConcoursRepository;
import com.eheio.pfa.dao.ConseillerRepository;
import com.eheio.pfa.dao.EtudiantRepository;
import com.eheio.pfa.dao.EvenementRepository;
import com.eheio.pfa.dao.PublicationRepository;
import com.eheio.pfa.dao.UtilisateurRepository;
import com.eheio.pfa.dto.ListDataAdmin;
import com.eheio.pfa.dto.ListDataArticle;
import com.eheio.pfa.dto.ListDataConcours;
import com.eheio.pfa.dto.ListDataEtudiant;
import com.eheio.pfa.dto.ListDataEvenement;
import com.eheio.pfa.dto.ProfilData;
import com.eheio.pfa.entities.Admin;
import com.eheio.pfa.entities.Article;
import com.eheio.pfa.entities.Concours;
import com.eheio.pfa.entities.Conseiller;
import com.eheio.pfa.entities.Etudiant;
import com.eheio.pfa.entities.Evenement;
import com.eheio.pfa.entities.Publication;
import com.eheio.pfa.entities.Utilisateur;

@Controller
public class AdminController {

 @Autowired
 private AdminRepository adminRepository;
 @Autowired
 private UtilisateurRepository utilisateurRepository;
 @Autowired
 private EtudiantRepository etudiantRepository;
 @Autowired
 private ConseillerRepository conseillerRepository;
 @Autowired
 private PublicationRepository publicationRepository;
 @Autowired
 private ConcoursRepository concoursRepository;
 @Autowired
 private EvenementRepository evenementRepository;
 @Autowired
 private ArticleRepository articleRepository;
 
 //lister tous les utilisateur(conseillers et etudiants) avec ses etablissements et secteur pour conseillers,
 //niveau pour etudiants.
 
    @GetMapping(value="/admin/utilisateur")
	public String utilisateur(Model model) {
    	/*
		List<Utilisateur> utilisateurs=utilisateurRepository.findAll();
		model.addAttribute("listeutilisateurs", utilisateurs);
    	*/
		List<ListDataEtudiant> listEtudiant =etudiantRepository.listEtudiant();
		model.addAttribute("listEtudiant", listEtudiant);
		
		List<ListDataAdmin> listConseiller =conseillerRepository.listConseiller();
	    model.addAttribute("listConseiller", listConseiller);
		 
		return "utilisateurs";
	}
 
 //supprimer un  utilisateur
 /*
 @GetMapping(value ="/deleteu")
	public String deleteu(int id) {
	    utilisateurRepository.deleteById(id);
		return "redirect:/utilisateur";
	}
 */
//supprimer un  etudiant
 
@GetMapping(value ="/admin/deletee/{idEtudiant}")
	public String deletee(@PathVariable int idEtudiant) {
	    etudiantRepository.deleteById(idEtudiant);
		return "redirect:/admin/utilisateur";
	}

//supprimer un  conseiller

@GetMapping(value ="/admin/deletec/{idConseiller}")
	public String deletec(@PathVariable int idConseiller) {
	conseillerRepository.deleteById(idConseiller);
		return "redirect:/admin/utilisateur";
	}

    //lister les publications pour l admin et voir le nom complet de publicateur

    @GetMapping(value="/admin/publication")
    public String publication(Model model) {
    /*	
	List<Publication> publications=publicationRepository.findAll();
	model.addAttribute("listePublications", publications);
	*/
	List<ListDataConcours> concours=concoursRepository.listDataConcours();
	model.addAttribute("listeconcours", concours);
	
	List<ListDataEvenement> evenements=evenementRepository.ListDataEvenement();
	model.addAttribute("listeevenements", evenements);
	
	List<ListDataArticle> articles=articleRepository.ListDataArticle();
	model.addAttribute("listearticles",articles );
	
	return "publicationa";
    }
    
		//supprimer un  Publication
		 
		    @GetMapping(value ="/admin/deletep")
			public String deletep(int id) {
			publicationRepository.deleteById(id);
	        return "redirect:/admin/publication";
			}
		 
		//supprimer un  article
		 
		    @GetMapping(value ="/admin/deletea")
			public String deletea(int id) {
			articleRepository.deleteById(id);
		    return "redirect:/admin/publication";
			}

		//supprimer un  evenement

		    @GetMapping(value ="/admin/deleteev")
			public String deleteev(int id) {
			evenementRepository.deleteById(id);
			return "redirect:/admin/publication";
			}

		//supprimer un  concours

		    @GetMapping(value ="/admin/deletecn")
			public String deletecn(int id) {
			concoursRepository.deleteById(id);
			return "redirect:/admin/publication";
			}
	
		   //Approuver un conseiller
		   @GetMapping(value = "/admin/approuv/{idConseiller}")
			public String approuver(@PathVariable int idConseiller ) {
		    Optional<Conseiller> c=conseillerRepository.findById(idConseiller);
		    if(!c.isEmpty()) {
		    	Conseiller conseiller=c.get();
		    	conseiller.setIsaprouv(true);
		    	conseillerRepository.save(conseiller);
		    	return "redirect:/admin/utilisateur";
		    	//il faut mettre une page 404...
		    }
		    return "404";
			
		}
		   
		    //Affichage de profile
		    
		    @GetMapping(value = "/admin/ProfileAdmin")
		    public String profile(Model model) {
		    
		    List<Admin> admins=adminRepository.findAll();
		    model.addAttribute("profileAdmin", admins);
		    return "ProfileAdmin";
		    	
		    }
		    
		    //editer le profile
		    @GetMapping(value = "/admin/editeProfileA/{id}")
		    public String editeAdmin(Model model,@PathVariable int id) {
			Optional<Admin> a =adminRepository.findById(id);
			model.addAttribute("admin", a.get());
			return "editeProfileAdmin";	
		    }
		    
		    @PostMapping(value = "/admin/editeProfileA/{id}")
		    public String editeAdmin( Admin a,@PathVariable int id) {
				Optional<Admin> adbag=adminRepository.findById(id);
				Admin admin=adbag.get();
				admin.setEmail(a.getEmail());
				admin.setnomUtilisateur(a.getnomUtilisateur());
				adminRepository.save(admin);
				return "redirect:/admin/ProfileAdmin";

		    }
		    
    }


