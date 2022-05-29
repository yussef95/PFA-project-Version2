
package com.eheio.pfa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.eheio.pfa.dao.ArticleRepository;
import com.eheio.pfa.dao.ConcoursRepository;
import com.eheio.pfa.dao.EvenementRepository;
import com.eheio.pfa.dao.UtilisateurRepository;
import com.eheio.pfa.entities.Article;
import com.eheio.pfa.entities.Concours;
import com.eheio.pfa.entities.Conseiller;
import com.eheio.pfa.entities.Etudiant;
import com.eheio.pfa.entities.Evenement;

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
	
	@PostMapping(value="/inscriptione")
	public String inscriptione(Etudiant e) {
		utilisateurRepository.save(e);
		return "index";
		
	}
	//inscription pour les conseillers
	
	@PostMapping(value="/inscriptionc")
	 
	public String inscriptionc(Conseiller c) {
		utilisateurRepository.save(c);               
		return "index";		
	}
		
}
