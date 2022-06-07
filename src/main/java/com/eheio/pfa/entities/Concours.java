package com.eheio.pfa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;



@Entity
@PrimaryKeyJoinColumn( name = "idPublication" )

public class Concours extends Publication {
	
	@NotNull
	private String titre;
	@NotNull
	@Column(columnDefinition = "TEXT")
	private String description;

	public Concours() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Concours(Conseiller conseiller,String titre, String description) {
		super(conseiller);
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
