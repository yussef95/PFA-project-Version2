package com.eheio.pfa.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
public class Message implements Serializable {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	private String objet;
	@NotEmpty
	@Column(columnDefinition = "TEXT")
	private String description;
	@NotEmpty
	@Email
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "id_conseiller")
	private  Conseiller conseiller;
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(String objet, String description, String email, Conseiller conseiller) {
		super();
		
		this.objet = objet;
		this.description = description;
		this.email = email;
		this.conseiller = conseiller;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}
	
	

}
