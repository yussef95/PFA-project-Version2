package com.eheio.pfa.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


@Entity
@PrimaryKeyJoinColumn( name = "idUtilisateur" )

public class Professeur extends Utilisateur{
	@NotNull
	@Email
	private String email;
	@NotNull
	private String password;
	@NotNull
	public String nomUtilisateur;
	@NotNull
	private boolean isaprouv;
	@NotNull
	private String nomComplet;
	
	@ManyToOne
	@JoinColumn(name = "id_etablissement")
	private Etablissement etablissement;
	
	@ManyToOne
	@JoinColumn(name = "id_SecteurOrientation")
	private SecteurOrientation orientation;

	@OneToMany(mappedBy = "professeur",fetch = FetchType.LAZY )

	private Collection<Cours> cours;
	
	

	public Professeur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Professeur(String email, String password, String nomUtilisateur, boolean isaprouv, String nomComplet,
			Etablissement etablissement,SecteurOrientation orientation) {
		super();
		this.email = email;
		this.password = password;
		this.nomUtilisateur = nomUtilisateur;
		this.isaprouv = isaprouv;
		this.nomComplet = nomComplet;
		this.etablissement = etablissement;
		this.orientation = orientation;

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

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public boolean isIsaprouv() {
		return isaprouv;
	}

	public void setIsaprouv(boolean isaprouv) {
		this.isaprouv = isaprouv;
	}

	public String getNomComplet() {
		return nomComplet;
	}

	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}

	public Etablissement getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}
	public SecteurOrientation getOrientation() {
		return orientation;
	}

	public void setOrientation(SecteurOrientation orientation) {
		this.orientation = orientation;
	}
	
	public Collection<Cours> getCours() {
		return cours;
	}

	public void setCours(Collection<Cours> cours) {
		this.cours = cours;
	}

	

}
