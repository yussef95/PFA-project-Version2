package com.eheio.pfa.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Entity
@PrimaryKeyJoinColumn( name = "idUtilisateur" )

public class Etudiant extends Utilisateur {
	
	@ManyToOne
	@JoinColumn(name = "id_niveauScolaire")
	private NiveauScolaire niveauScolaire;
	@ManyToOne
	@JoinColumn(name = "id_etablissement")
	private Etablissement etablissement;
	
	

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Etudiant(int id, @Email @NotEmpty String email, @NotEmpty String password, @NotEmpty String nomUtilisateur,
			@NotEmpty String nomComplet,Role role,NiveauScolaire niveauScolaire, Etablissement etablissement) {
		super(id, email, password, nomUtilisateur, nomComplet,role);
		this.niveauScolaire = niveauScolaire;
		this.etablissement = etablissement;
		// TODO Auto-generated constructor stub
	}
	
	

	public NiveauScolaire getNiveauScolaire() {
		return niveauScolaire;
	}

	public void setNiveauScolaire(NiveauScolaire niveauScolaire) {
		this.niveauScolaire = niveauScolaire;
	}
	public Etablissement getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}
	


}
