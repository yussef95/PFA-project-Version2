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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Utilisateur implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	@Email
	@NotEmpty
	protected String email;
	@NotEmpty
	protected String password;
	@NotEmpty
	protected String nomUtilisateur;
	@NotEmpty
	protected String nomComplet;
	@ManyToOne
	@JoinColumn(name = "role_id")
	protected Role role;

	

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(int id, @Email @NotEmpty String email, @NotEmpty String password, @NotEmpty String nomUtilisateur,
			@NotEmpty String nomComplet,Role role) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.nomUtilisateur = nomUtilisateur;
		this.nomComplet = nomComplet;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getNomComplet() {
		return nomComplet;
	}

	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	

	
}
