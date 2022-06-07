
package com.eheio.pfa.securityy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eheio.pfa.dao.EtudiantRepository;
import com.eheio.pfa.entities.Etudiant;

@Service
public class EtudiantDetailsService implements UserDetailsService {

	@Autowired
	private EtudiantRepository etudiantRepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
        Etudiant etudiant=etudiantRepository.findByEmail(email);
		 
		 if (etudiant == null) {
			 
	            throw new UsernameNotFoundException(email);
	        }
	            return new MyUserPrincipalEtudiant(etudiant);
		
	}

}
