
package com.eheio.pfa.securityy;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.eheio.pfa.entities.Etudiant;


public class MyUserPrincipalEtudiant implements UserDetails {

	private Etudiant etudiant;
	
	public MyUserPrincipalEtudiant(Etudiant etudiant) {
		this.etudiant=etudiant;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.etudiant.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.etudiant.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
