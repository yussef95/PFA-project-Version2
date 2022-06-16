package com.eheio.pfa.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Cours implements Serializable {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    @NotEmpty
	private String titre;
	@Column(columnDefinition = "TEXT")
	@NotEmpty
	private String description;
	@ManyToOne
	@JoinColumn(name = "id_professeur")
	private Professeur professeur;
	
	public Cours() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cours(String titre, String description,Professeur professeur) {
		super();
		this.titre = titre;
		this.description = description;
		this.professeur = professeur;

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Professeur getProfesseur() {
		return professeur;
	}
	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}
	


}
