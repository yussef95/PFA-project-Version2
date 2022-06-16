package com.eheio.pfa.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eheio.pfa.dao.CoursRepository;
import com.eheio.pfa.dao.EtablissementRepository;
import com.eheio.pfa.dao.ProfesseurRepository;
import com.eheio.pfa.dao.SecteurOrientationRepository;
import com.eheio.pfa.dto.ListDataCours;
import com.eheio.pfa.dto.ListDataCoursAll;
import com.eheio.pfa.dto.ListDataEvenementProfile;
import com.eheio.pfa.dto.ProfileDataProf;
import com.eheio.pfa.entities.Conseiller;
import com.eheio.pfa.entities.Cours;
import com.eheio.pfa.entities.Etablissement;
import com.eheio.pfa.entities.Professeur;
import com.eheio.pfa.entities.SecteurOrientation;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class ProfesseurController {
	
	@Autowired
	private CoursRepository coursRepository;
	@Autowired
	private ProfesseurRepository professeurRepository;
	@Autowired
	private EtablissementRepository etablissementRepository;
	@Autowired
	private SecteurOrientationRepository orientationRepository;
	
	//lister tous les cours
	@GetMapping(value="/prof/cours")
    public String cours(Model model) {
	List<Cours> cr= coursRepository.findAll();
	model.addAttribute("listeCours",cr );
	return "cours";
	}
	
	//Ajouter un cours
	@GetMapping(value="/prof/nouveauCours")
	public String nouveauCours(Model model) {
		model.addAttribute("cours", new Cours());
		return "nouveauformeCours";
	}
	@PostMapping(value="/prof/ajouteCours")
	public String ajouterCours(@Valid Cours cr,BindingResult result,Authentication authentication) {
		if(result.hasErrors()) return "nouveauformeCours";
		Professeur p=professeurRepository.findByEmail(authentication.getName());
		cr.setProfesseur(p);
		if(p.isIsaprouv()==true) {
			coursRepository.save(cr);
			return "redirect:/prof/monProfile";
		}
		else {
			return "403";
		}
		
	}
	//supprimer un cours
	@GetMapping(value ="/prof/deleteCours")
	public String deleteCours(@RequestParam int id) {
	    coursRepository.deleteById(id);
		return "redirect:/prof/monProfile";
	}
	
	  //editer un cours
	  @GetMapping(value = "/prof/editeCours/{id}")
	  
	    public String editeeforme(Model model,@PathVariable int id) {
		Optional<Cours> cr=coursRepository.findById(id);
		model.addAttribute("cours", cr.get());
		return "editerCours";	
	    }
	   
	    @PostMapping(value = "/prof/editeCours/{id}")
	    public String editee(@Valid Cours cr,@PathVariable int id,BindingResult result) {
	    	
			Optional<Cours> crbag=coursRepository.findById(id);
			Cours cours=crbag.get();
			cours.setProfesseur(cr.getProfesseur());
			cours.setTitre(cr.getTitre());
			cours.setDescription(cr.getDescription());
			if(result.hasErrors()) return "editerCours";
			coursRepository.save(cours);
			return "redirect:/prof/monProfile";

	    }
	    
	  //afficher mon profile et voir mes publications
	    
	    @GetMapping(value = "/prof/monProfile")
	    public String profile(Model model,Authentication authentication) {
	    ProfileDataProf profilDataProf= professeurRepository.profileProfesseur(authentication.getName());
	    model.addAttribute("profilDataProf", profilDataProf);
	    
	    List<ListDataCoursAll> Cours=
        coursRepository.listDataCoursAlls(authentication.getName());
	    model.addAttribute("listeCours", Cours);
	    
		return "profileProf";
	    }
	     
	    //editer Mon profile
	    
	    @GetMapping(value ="/prof/editepr/{id}")
	    public String editeProfesseur(Model model,@PathVariable int id) {
	    	try {
	    		
	    		Optional<Professeur> p=professeurRepository.findById(id);
	    		List<Etablissement> etablissements = etablissementRepository.findAll();
				model.addAttribute("etablissement",etablissements);
				List<SecteurOrientation> secteurOrientations=orientationRepository.findAll();
				model.addAttribute("secteurOrientations",secteurOrientations);
		    	model.addAttribute("professeur", p.get());
				
			} catch (Exception e) {
				// TODO: handle exception
			}
	    	
	    	return "editProfileProfesseur";
	    }
	    
	    @PostMapping(value = "/prof/editepr/{id}")
	    public String editeProf(@Valid Professeur p, @PathVariable int id,BindingResult result) {
	    	
	    	   Optional<Professeur> pbag=professeurRepository.findById(id);
	    	   Professeur professeur=pbag.get();
	    	   professeur.setNomComplet(p.getNomComplet());
	    	   professeur.setNomUtilisateur(p.getNomUtilisateur());
	    	   professeur.setOrientation(p.getOrientation());
	    	   professeur.setEtablissement(p.getEtablissement());
			   if(result.hasErrors()) return "editProfileProfesseur";
	    	   professeurRepository.save(professeur);
	    	   return "redirect:/prof/monProfile";
	    }
	   
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
