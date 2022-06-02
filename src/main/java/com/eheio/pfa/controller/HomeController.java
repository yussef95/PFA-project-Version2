
package com.eheio.pfa.controller;

import java.util.List;

import com.eheio.pfa.dao.*;
import com.eheio.pfa.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {


	@Autowired
	UtilisateurRepository utilisateurRepository;
	@Autowired
	EvenementRepository evenementRepository;
	@Autowired
	ArticleRepository articleRepository;
	@Autowired
	ConcoursRepository concoursRepository;
	@Autowired
	NiveauScolaireRepository niveauScolaireRepository;
	@Autowired
	EtablissementRepository etablissementRepository;
	@Autowired
	SecteurOrientationRepository secteurOrientationRepository;
	
	//page des evenements
	@GetMapping(value="/evenement")
	public String evenement(Model model) {
		List<Evenement>evenements =evenementRepository.findAll();
		model.addAttribute("listeEvenement", evenements);
		return "evenement";
		}
	
	//page des article
		@GetMapping(value="/article")
		public String article(Model model) {
			List<Article>articles =articleRepository.findAll();
			model.addAttribute("listeArticle", articles);
			return "article";
			}
		
		//page des concours
		@GetMapping(value="/concoursh")
		public String concours(Model model) {
			List<Concours>concours =concoursRepository.findAll();
			model.addAttribute("listeConcours", concours);
			return "concours";
			}
		
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
	
	//inscription pour les etudeiants
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
		etudiant.setPassword(encodedPassword);
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
		conseiller.setPassword(encodedPassword);
		utilisateurRepository.save(conseiller);
		return "inscription_success_conseiller";

	}
		
}
