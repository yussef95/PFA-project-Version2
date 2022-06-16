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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@PrimaryKeyJoinColumn( name = "idUtilisateur" )

public class Professeur extends Utilisateur{
	
	@NotNull
	private boolean isaprouv;
	
	
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

	public Professeur(int id, @Email @NotEmpty String email, @NotEmpty String password, @NotEmpty String nomUtilisateur,
			         @NotEmpty String nomComplet,@NotEmpty boolean isaprouv,Role role, Etablissement etablissement, SecteurOrientation orientation) {
		super(id, email, password, nomUtilisateur, nomComplet,role);
		// TODO Auto-generated constructor stub
		this.isaprouv = isaprouv;
		this.etablissement = etablissement;
		this.orientation = orientation;
	}
	
	

	

	public boolean isIsaprouv() {
		return isaprouv;
	}

	public void setIsaprouv(boolean isaprouv) {
		this.isaprouv = isaprouv;
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
