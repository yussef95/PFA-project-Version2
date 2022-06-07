package com.eheio.pfa.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;



@Entity
@PrimaryKeyJoinColumn( name = "idUtilisateur" )

public class Etudiant extends Utilisateur {
	
	@NotNull
	private String email;
	@NotNull
	private String password;
	@NotNull
	private String nomUtilisateur;
	@NotNull
	private String nomComplet;
	@ManyToOne
	@JoinColumn(name = "id_niveauScolaire")
	private NiveauScolaire niveauScolaire;
	@ManyToOne
	@JoinColumn(name = "id_etablissement")
	private Etablissement etablissement;

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Etudiant(String email, String password, String nomUtilisateur,String nomComplet,NiveauScolaire niveauScolaire,Etablissement etablissement) {
		// TODO Auto-generated constructor stub
		this.niveauScolaire=niveauScolaire;
		this.etablissement=etablissement;
		this.email = email;
		this.password = password;
		this.nomUtilisateur = nomUtilisateur;
		this.nomComplet = nomComplet;

	}
	public NiveauScolaire getNiveauScolaire() {
		return niveauScolaire;
	}

	public void setNiveauScolaire(NiveauScolaire niveauScolaire) {
		this.niveauScolaire = niveauScolaire;
	}
	public Etablissement getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(Etablissement etablissement) {
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
	public String getNomComplet() {
		return nomComplet;
	}

	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}

}
