
package com.eheio.pfa.securityy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eheio.pfa.dao.AdminRepository;
import com.eheio.pfa.entities.Admin;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminDetailsService implements UserDetailsService {

	@Autowired
	private AdminRepository adminRepository;
	@Override
	public UserDetails loadUserByUsername(String nomUtilisateur) throws UsernameNotFoundException {
		
		 Admin admin=adminRepository.findByNomUtilisateur(nomUtilisateur);
		 
		 if (admin == null) {
			 
	            throw new UsernameNotFoundException(nomUtilisateur);
	        }
	        return new MyUserPrincipal(admin);
		
		
	}

	
}
