package com.eheio.pfa.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn( name = "idUtilisateur" )

public class Professeur extends Utilisateur{
	
	private String email;
	private String password;
	public String nomUtilisateur;
	private boolean isaprouv;
	private String nomComplet;
	
	@ManyToOne
	@JoinColumn(name = "id_etablissement")
	private Etablissement etablissement;

	public Professeur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Professeur(String email, String password, String nomUtilisateur, boolean isaprouv, String nomComplet,
			Etablissement etablissement) {
		super();
		this.email = email;
		this.password = password;
		this.nomUtilisateur = nomUtilisateur;
		this.isaprouv = isaprouv;
		this.nomComplet = nomComplet;
		this.etablissement = etablissement;
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
	

}