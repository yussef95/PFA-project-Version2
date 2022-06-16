package com.eheio.pfa;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.eheio.pfa.dao.AdminRepository;
import com.eheio.pfa.dao.ArticleRepository;
import com.eheio.pfa.dao.ConcoursRepository;
import com.eheio.pfa.dao.ConseillerRepository;
import com.eheio.pfa.dao.EtablissementRepository;
import com.eheio.pfa.dao.EtudiantRepository;
import com.eheio.pfa.dao.EvenementRepository;
import com.eheio.pfa.dao.NiveauScolaireRepository;
import com.eheio.pfa.dao.PublicationRepository;
import com.eheio.pfa.dao.SecteurOrientationRepository;
import com.eheio.pfa.dao.UtilisateurRepository;
import com.eheio.pfa.entities.Admin;
import com.eheio.pfa.entities.Article;
import com.eheio.pfa.entities.Concours;
import com.eheio.pfa.entities.Conseiller;
import com.eheio.pfa.entities.Etablissement;
import com.eheio.pfa.entities.Etudiant;
import com.eheio.pfa.entities.Evenement;
import com.eheio.pfa.entities.NiveauScolaire;
import com.eheio.pfa.entities.Professeur;
import com.eheio.pfa.entities.Publication;
import com.eheio.pfa.entities.SecteurOrientation;
import com.eheio.pfa.entities.Utilisateur;



@SpringBootApplication
public class OrientSuApplication  implements CommandLineRunner {


	 /*
	 @Autowired
	 private PasswordEncoder passwordEncoder;
     */
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
	 @Autowired
	 private AdminRepository adminRepository;
	 @Autowired
	 private SecteurOrientationRepository orientationRepository;
	 @Autowired
	 private NiveauScolaireRepository niveauScolaireRepository;
	 @Autowired
	 private EtablissementRepository etablissementRepository;
	 
	public static void main(String[] args) {
		SpringApplication.run(OrientSuApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
        
		/*
		Etablissement et1=etablissementRepository.save(new Etablissement("ziri"));
		Etablissement et2=etablissementRepository.save(new Etablissement("abdelmoumen"));
		Etablissement et3=etablissementRepository.save(new Etablissement("med6"));
		NiveauScolaire college1=niveauScolaireRepository.save(new NiveauScolaire("1ére année collège"));
		NiveauScolaire college2=niveauScolaireRepository.save(new NiveauScolaire("2éme année collège"));
		NiveauScolaire college3=niveauScolaireRepository.save(new NiveauScolaire("3éme année collège"));
        SecteurOrientation s1=orientationRepository.save(new SecteurOrientation("science"));
        SecteurOrientation s2=orientationRepository.save(new SecteurOrientation("lettre"));
        SecteurOrientation s3=orientationRepository.save(new SecteurOrientation("technique"));
        SecteurOrientation s4=orientationRepository.save(new SecteurOrientation("economique"));
        Utilisateur c1=utilisateurRepository.save(new Conseiller(1, "conseiller1@gmail.com", passwordEncoder.encode("123"), "cons1", "salhi yassen", false, s1, et1));
        Utilisateur c2=utilisateurRepository.save(new Conseiller(2, "conseiller2@gmail.com", passwordEncoder.encode("123"), "cons2", "oufkir youssef", false, s2, et2));
        Utilisateur c3=utilisateurRepository.save(new Conseiller(3, "conseiller3@gmail.com", passwordEncoder.encode("123"), "cons3", "mhada med", false, s3, et3));
        Utilisateur e1=utilisateurRepository.save(new Etudiant(4, "etudiant1@gmail.com", passwordEncoder.encode("123"), "etud1", "tahri mastafa", college1, et1));
        Utilisateur e2=utilisateurRepository.save(new Etudiant(5, "etudiant1@gmail.com", passwordEncoder.encode("123"), "etud1", "tahri mastafa", college1, et2));
        Utilisateur e3=utilisateurRepository.save(new Etudiant(6, "etudiant1@gmail.com", passwordEncoder.encode("123"), "etud1", "tahri mastafa", college1, et3));
        Utilisateur a=utilisateurRepository.save(new Admin(7, "etudiant1@gmail.com", passwordEncoder.encode("123"), "admin", "kasmi ayoub"));
        Utilisateur pr=utilisateurRepository.save(new Professeur(0, null, null, null, null, false, et3, s4))
        Utilisateur p1=utilisateurRepository.save(new Professeur(8, "professeur1@gmail.com", "123", "prof1", "abad med", false, null,null ));

        */




	}

}

