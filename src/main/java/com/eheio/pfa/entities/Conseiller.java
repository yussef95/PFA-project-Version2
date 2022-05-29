package com.eheio.pfa.entities;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn( name = "idUtilisateur" )

public class Conseiller extends Utilisateur {
	
	private String email;
	private String password;
	public String nomUtilisateur;
	private boolean isaprouv;
	private String nomComplet;
	
	@OneToMany(mappedBy = "conseiller",fetch = FetchType.LAZY )
	private Collection<Publication>publications;
	
	
	@ManyToOne
	@JoinColumn(name = "id_SecteurOrientation")
	private SecteurOrientation orientation;
	
	@ManyToOne
	@JoinColumn(name = "id_etablissement")
	private Etablissement etablissement;
	
	@OneToMany(mappedBy = "conseiller",fetch = FetchType.LAZY )
	private Collection<Message> messages;
	
	

	

	public Conseiller() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Conseiller(String email, String password, String nomUtilisateur,boolean isaprouv,String nomComplet,SecteurOrientation orientation,Etablissement etablissement) {
		// TODO Auto-generated constructor stub
		this.email = email;
		this.password = password;
		this.nomUtilisateur = nomUtilisateur;
		this.isaprouv = isaprouv;
		this.nomComplet = nomComplet;
		this.orientation = orientation;
		this.etablissement = etablissement;


	}

	public boolean isIsaprouv() {
		return isaprouv;
	}

	public void setIsaprouv(boolean isaprouv) {
		this.isaprouv = isaprouv;
	}

	public Collection<Publication> getPublications() {
		return publications;
	}

	public void setPublications(Collection<Publication> publications) {
		this.publications = publications;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getnomUtilisateur() {
		return nomUtilisateur;
	}

	public void setnomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getNomComplet() {
		return nomComplet;
	}

	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}

	public SecteurOrientation getOrientation() {
		return orientation;
	}

	public void setOrientation(SecteurOrientation orientation) {
		this.orientation = orientation;
	}

	public Etablissement getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}
	
}
