package com.eheio.pfa.entities;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;



@Entity
public class Admin implements Serializable {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String password;
	public String nomUtilisateur;
	
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String email, String password, String nomUtilisateur) {
		super();
		this.email = email;
		this.password = password;
		this.nomUtilisateur = nomUtilisateur;
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
	public String getnomUtilisateur() {
		return nomUtilisateur;
	}
	public void setnomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	
}