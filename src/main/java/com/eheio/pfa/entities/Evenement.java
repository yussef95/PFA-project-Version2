package com.eheio.pfa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@PrimaryKeyJoinColumn( name = "idPublication" )

public class Evenement extends Publication {
	
	@NotEmpty
	private String titre;
	@NotEmpty
	@Column(columnDefinition = "TEXT")
	private String description;

	public Evenement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Evenement(Professeur professeur,Conseiller conseiller,String titre, String description) {
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
