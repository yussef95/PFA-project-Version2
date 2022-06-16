package com.eheio.pfa.entities;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@PrimaryKeyJoinColumn( name = "idUtilisateur" )

public class Conseiller extends Utilisateur {
	
	private boolean isaprouv;

	
	@OneToMany(mappedBy = "conseiller",fetch = FetchType.LAZY )
	private Collection<Publication>publications;
	
	
	@ManyToOne
	@JoinColumn(name = "id_SecteurOrientation")
	private SecteurOrientation orientation;
	
	@ManyToOne
	@JoinColumn(name = "id_etablissement")
	private Etablissement etablissement;
	
	@OneToMany(mappedBy = "conseiller",fetch = FetchType.LAZY )
	private Collection<Message> messages;
	
	public Conseiller() {
		super();
		// TODO Auto-generated constructor stub
	}

	   public Conseiller(int id, @Email @NotEmpty String email, @NotEmpty String password, @NotEmpty String nomUtilisateur,
			@NotEmpty String nomComplet,boolean isaprouv,Role role, SecteurOrientation orientation, Etablissement etablissement) {
		super(id, email, password, nomUtilisateur, nomComplet,role);
		this.isaprouv = isaprouv;
		this.orientation = orientation;
		this.etablissement = etablissement;
		// TODO Auto-generated constructor stub
	}

	

	public boolean isIsaprouv() {
		return isaprouv;
	}

	public void setIsaprouv(boolean isaprouv) {
		this.isaprouv = isaprouv;
	}

	public Collection<Publication> getPublications() {
		return publications;
	}

	public void setPublications(Collection<Publication> publications) {
		this.publications = publications;
	}

	public SecteurOrientation getOrientation() {
		return orientation;
	}

	public void setOrientation(SecteurOrientation orientation) {
		this.orientation = orientation;
	}

	public Etablissement getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}
	
}
