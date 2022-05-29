package com.eheio.pfa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn( name = "idPublication" )

public class Evenement extends Publication {
	
	private String titre;
	
	@Column(columnDefinition = "TEXT")
	private String description;

	public Evenement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Evenement(Conseiller conseiller,String titre, String description) {
		super( conseiller);
		// TODO Auto-generated constructor stub
		this.titre = titre;
		this.description = description;
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
	
}
