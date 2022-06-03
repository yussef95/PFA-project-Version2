package com.eheio.pfa.service;

import com.eheio.pfa.securityy.MyUserPrincipalConseiller;
import com.eheio.pfa.securityy.MyUserPrincipalEtudiant;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserConseiller {
    public String CurrentUserCn(MyUserPrincipalConseiller principal) {

                 Object MyUserPrincipalConseiller = SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
                 
        if (MyUserPrincipalConseiller instanceof UserDetails) {
            String email = ((UserDetails) MyUserPrincipalConseiller).getUsername();
        } else {
            String email = MyUserPrincipalConseiller.toString();
        }

        return principal.getUsername();

    }
}
