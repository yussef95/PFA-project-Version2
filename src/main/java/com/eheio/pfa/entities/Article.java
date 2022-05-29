package com.eheio.pfa.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;



@Entity
@PrimaryKeyJoinColumn( name = "idPublication" )

public class Article extends Publication{
	
	private String titre;
	@Column(columnDefinition = "TEXT")
	private String description;

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(Conseiller conseiller,String titre, String description) {
		super(conseiller);
		// TODO Auto-generated constructor stub
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
