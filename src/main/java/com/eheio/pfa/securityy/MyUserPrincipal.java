
package com.eheio.pfa.securityy;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.eheio.pfa.entities.Admin;
import com.eheio.pfa.entities.Utilisateur;

import org.springframework.security.crypto.password.PasswordEncoder;

public class MyUserPrincipal implements UserDetails {


	private Utilisateur utilisateur;
	
	public MyUserPrincipal(Utilisateur utilisateur) {
		// TODO Auto-generated constructor stub
		this.utilisateur=utilisateur;
	}
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(utilisateur.getRole().getName());
        return Arrays.asList(authority);	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return utilisateur.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return utilisateur.getEmail();
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
