package com.eheio.pfa.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SecteurOrientation implements Serializable{
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String libelle;
	@OneToMany(mappedBy = "orientation",fetch = FetchType.LAZY )
    private Collection<Conseiller>conseillers;
	
	@OneToMany(mappedBy = "orientation",fetch = FetchType.LAZY )
    private Collection<Professeur> professeurs;
	
	
	public SecteurOrientation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SecteurOrientation(String libelle) {
		super();
		this.libelle = libelle;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Collection<Conseiller> getConseillers() {
		return conseillers;
	}
	public void setConseillers(Collection<Conseiller> conseillers) {
		this.conseillers = conseillers;
	}
	public Collection<Professeur> getProfesseurs() {
		return professeurs;
	}
	public void setProfesseurs(Collection<Professeur> professeurs) {
		this.professeurs = professeurs;
	}

	
}
