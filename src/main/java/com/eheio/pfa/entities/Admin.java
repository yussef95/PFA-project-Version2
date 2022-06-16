package com.eheio.pfa.entities;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;



@Entity
@PrimaryKeyJoinColumn( name = "idUtilisateur" )
public class Admin extends Utilisateur {

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int id, @Email @NotNull String email, @NotNull String password, @NotNull String nomUtilisateur,
			@NotNull String nomComplet,Role role) {
		super(id, email, password, nomUtilisateur, nomComplet,role);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
		
}