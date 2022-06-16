
package com.eheio.pfa.securityy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eheio.pfa.dao.AdminRepository;
import com.eheio.pfa.dao.UtilisateurRepository;
import com.eheio.pfa.entities.Admin;
import com.eheio.pfa.entities.Utilisateur;

import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminDetailsService implements UserDetailsService {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		 Utilisateur utilisateur=utilisateurRepository.findByEmail(email);
		 
		 if (utilisateur == null) {
			 
	            throw new UsernameNotFoundException(email);
	        }
	        return new MyUserPrincipal(utilisateur);
		
		
	}

	
}
