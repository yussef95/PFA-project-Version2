package com.eheio.pfa.securityy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eheio.pfa.dao.AdminRepository;
import com.eheio.pfa.entities.Admin;

@Service
public class AdminDetailsService implements UserDetailsService {

	@Autowired
	private AdminRepository adminRepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		 Admin admin=adminRepository.findByEmail(email);
		 
		 if (admin == null) {
			 
	            throw new UsernameNotFoundException(email);
	        }
	        return new MyUserPrincipal(admin);
		
		
	}

	
}
