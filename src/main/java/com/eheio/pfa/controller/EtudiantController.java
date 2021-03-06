package com.eheio.pfa.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;



//import com.eheio.pfa.service.CurrentUserEtudiant;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.eheio.pfa.dao.ConseillerRepository;
import com.eheio.pfa.dao.CoursRepository;
import com.eheio.pfa.dao.EtablissementRepository;
import com.eheio.pfa.dao.EtudiantRepository;
import com.eheio.pfa.dao.MessageRepository;
import com.eheio.pfa.dao.NiveauScolaireRepository;
import com.eheio.pfa.dao.SecteurOrientationRepository;
import com.eheio.pfa.dto.ListDataCours;
import com.eheio.pfa.dto.ProfilData;
import com.eheio.pfa.dto.ProfilDataConseillerPourEtudiant;
import com.eheio.pfa.dto.ProfileDataEtudiant;
import com.eheio.pfa.entities.Conseiller;
import com.eheio.pfa.entities.Etablissement;
import com.eheio.pfa.entities.Etudiant;
import com.eheio.pfa.entities.Message;
import com.eheio.pfa.entities.NiveauScolaire;
import com.eheio.pfa.entities.SecteurOrientation;

import groovyjarjarantlr4.v4.parse.GrammarTreeVisitor.mode_return;

@Controller
public class EtudiantController {
	
	@Autowired
	private ConseillerRepository conseillerRepository;
	@Autowired
	private SecteurOrientationRepository secteurOrientationRepository;
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private EtablissementRepository etablissementRepository;
	@Autowired
	private NiveauScolaireRepository niveauScolaireRepository;
	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private CoursRepository coursRepository;
	
	//org.slf4j.Logger logger=LoggerFactory.getLogger(EtudiantController.class);

	
	       //afficher les conseillers qui ont le meme etablissement de l'etudiant conn??ct?? avec ses secteurs d'orientation
	
	       
	       @GetMapping(value = "/etudiant/Conseillers")
	       public String listConseillers(Model model,Authentication authentication) {
		
	         List<ProfilDataConseillerPourEtudiant>	 ProfilDataCE=
	         conseillerRepository.profileConseillerEtudiant(authentication.getName());
	         model.addAttribute("ProfilDataCE", ProfilDataCE);	
		     return "listConseillers";
		 }
	
	       
	       //Affichage de profile
		    
		    @GetMapping(value = "/etudiant/ProfileEtudiant")
		    public String profile(Model model,Authentication authentication) {

		     ProfileDataEtudiant profilData=etudiantRepository.profileEtudiant(authentication.getName());
		     model.addAttribute("profilData", profilData);
		     return "profileEtudiant";
		    	
		    }
		    
		    //editer mon profile
		   
		    @GetMapping(value = "/etudiant/editeProfileEt/{id}")
		    public String editeEtudiant(Model model,@PathVariable int id) {
		    	Optional<Etudiant> e=etudiantRepository.findById(id);
		    	List<Etablissement> etablissements = etablissementRepository.findAll();
				List<NiveauScolaire> niveauScolaires = niveauScolaireRepository.findAll();
				model.addAttribute("niveau",niveauScolaires);
				model.addAttribute("etablissement",etablissements);
		    	model.addAttribute("etudiant", e.get());
		    	return "editProfileEtudiant";
		    	
		    }
		    
		    @PostMapping(value = "/etudiant/editeProfileEt/{id}")
		    public String editeEtudiantPost(@Valid Etudiant e, @PathVariable int id,BindingResult result) {
		    	
		    	   Optional<Etudiant> ebag=etudiantRepository.findById(id);
		    	   Etudiant etudiant= ebag.get();
		    	   etudiant.setEmail(e.getEmail());
		    	   etudiant.setNomComplet(e.getNomComplet());
		    	   etudiant.setNomUtilisateur(e.getNomUtilisateur());
		    	   
		    	   etudiant.setEtablissement(e.getEtablissement());
		    	   etudiant.setNiveauScolaire(e.getNiveauScolaire());
		    	   
				   if(result.hasErrors()) return "editProfileEtudiant";		
		    	   etudiantRepository.save(etudiant);
		    	   return "redirect:/etudiant/ProfileEtudiant";
		    }

		    //contacter avec le conseiller
		    
		    @GetMapping(value ="/etudiant/contacter/{id}")
		    public String contacterGet(Model model,@PathVariable int id) {
		    	   Optional<Conseiller> c=conseillerRepository.findById(id);
		    	   model.addAttribute("conseiller", c.get());
		    	   model.addAttribute("message",new Message());
		    	   return "contacter";
		    }
		    
		    @PostMapping(value = "/etudiant/contacter/{id}")
		    public String contacterPost(@Valid Message message,Conseiller conseiller,@PathVariable int id,BindingResult result) {
		    	
		    Optional<Conseiller> c=conseillerRepository.findById(id);
	    	message.setConseiller(conseiller);
	    	if(result.hasErrors()) return "contacter";
		    messageRepository.save(message);
		    return "redirect:/etudiant/Conseillers";
		    }
		    
 
		    //afiicher les cours pour l'etudiant publi?? par le professeur (etabllissement prof=etabllissement etud)
		    
		    @GetMapping(value = "/etudiant/cours")
		    public String cours( Model model,Authentication authentication) {
		    	
		    	List<ListDataCours> listDataCours=coursRepository.listDataCours(authentication.getName());
		    	model.addAttribute("cours", listDataCours);
		    
		        return "coursEt";
		    }
		    
		     
	
}
