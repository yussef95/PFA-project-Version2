
package com.eheio.pfa.securityy;

import com.eheio.pfa.dao.ConseillerRepository;
import com.eheio.pfa.entities.Conseiller;
import com.eheio.pfa.entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ConseillerDetailsService implements UserDetailsService {
    @Autowired
    ConseillerRepository conseillerRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Conseiller conseiller=conseillerRepository.findByEmail(email);

        if (conseiller == null) {

            throw new UsernameNotFoundException(email);
        }
        return new MyUserPrincipalConseiller(conseiller);
    }
}
