
package com.eheio.pfa.controller;

import java.util.List;

import com.eheio.pfa.dao.*;
import com.eheio.pfa.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    
   
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private EvenementRepository evenementRepository;
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private ConcoursRepository concoursRepository;
	@Autowired
	private NiveauScolaireRepository niveauScolaireRepository;
	@Autowired
	private EtablissementRepository etablissementRepository;
	@Autowired
	private SecteurOrientationRepository secteurOrientationRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	
		
	//Page d'acceuill
	
	@GetMapping(value="/")
	public String index() {
		return "index";
	}
	
	//Page de collège
	
	@GetMapping(value="/college")
	public String college() {
		return "college";
		}
	
	//Page de lycée
	
	@GetMapping(value="/lycee")
	public String lycee() {
		return "lycee";
		}
	
	
	
	//page de contact
	
	@GetMapping(value="/contact")
	public String contact() {
		return "contact";
	}
	    //page d'inscription
	
		@GetMapping(value="/inscreption")
		public String inscreption() {
			return "inscription";
		}
	
	//inscription pour les etudiants
	@GetMapping("/inscreptionEtudiantForm")
	public String FormInscription(Model model) {
		List<NiveauScolaire> niveauScolaires = niveauScolaireRepository.findAll();
		model.addAttribute("niveau",niveauScolaires);
		List<Etablissement> etablissements = etablissementRepository.findAll();
		model.addAttribute("etablissement",etablissements);
		model.addAttribute("etudiant", new Etudiant());
		return "inscription_form_etudiant";
	}
	@PostMapping(value="/inscriptionEtudiantSubmit")
	public String inscriptionEtudiant(Etudiant etudiant, Model model) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(etudiant.getPassword());
		Role role=roleRepository.findByName("ETUDIANT");
		etudiant.setPassword(encodedPassword);
		etudiant.setRole(role);
		utilisateurRepository.save(etudiant);
		return "inscription_success";
		
	}
	//inscription pour les conseillers
	@GetMapping("/inscreptionConseillerForm")
	public String FormInscriptionConseiller(Model model) {
		List<Etablissement> etablissements = etablissementRepository.findAll();
		List<SecteurOrientation> secteurOrientations=secteurOrientationRepository.findAll();
		model.addAttribute("secteurOrientations",secteurOrientations);
		model.addAttribute("etablissement",etablissements);
		model.addAttribute("conseiller", new Conseiller());
		return "inscription_form_conseiller";
	}
	@PostMapping(value="/inscriptionConseillerSubmit")
	public String inscriptionConseiller(Conseiller conseiller) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(conseiller.getPassword());
		Role role=roleRepository.findByName("CONSEILLER");
		conseiller.setPassword(encodedPassword);
		conseiller.setRole(role);
		utilisateurRepository.save(conseiller);
		return "inscription_success";

	}
	//inscription pour les professeurs
		@GetMapping("/inscreptionProfesseurForm")
		public String FormInscriptionProfesseur(Model model) {
			List<Etablissement> etablissements = etablissementRepository.findAll();
			List<SecteurOrientation> secteurOrientations=secteurOrientationRepository.findAll();
			model.addAttribute("secteurOrientations",secteurOrientations);
			model.addAttribute("etablissement",etablissements);
			model.addAttribute("professeur", new Professeur());
			return "inscription_form_professeur";
		}
		@PostMapping(value="/inscriptionProfesseurSubmit")
		public String inscriptionProfesseur( Professeur professeur) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(professeur.getPassword());
			Role role=roleRepository.findByName("PROFESSEUR");
			professeur.setPassword(encodedPassword);
			professeur.setRole(role);
			utilisateurRepository.save(professeur);
			return "inscription_success";

		}
		
}
