package com.eheio.pfa.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy =  InheritanceType.JOINED)
public abstract class Publication implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	
	
	@ManyToOne
	@JoinColumn(name = "id_conseiller")
	private Conseiller conseiller;
	
	

	public Publication() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Publication(Conseiller conseiller) {
		super();
		this.conseiller = conseiller;


	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}
	

}
