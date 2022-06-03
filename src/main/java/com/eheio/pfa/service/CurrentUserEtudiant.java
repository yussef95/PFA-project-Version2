package com.eheio.pfa.service;

import com.eheio.pfa.securityy.MyUserPrincipalEtudiant;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserEtudiant {

    public String  CurrentUserEt(MyUserPrincipalEtudiant principal){

             Object MyUserPrincipalEtudiant = SecurityContextHolder.getContext()
            .getAuthentication()
            .getPrincipal();


      if (MyUserPrincipalEtudiant instanceof UserDetails)
      {
        String email = ((UserDetails)MyUserPrincipalEtudiant).getUsername();
      }

      else
      {
        String email = MyUserPrincipalEtudiant.toString();
      }
        return principal.getUsername();
    }

}
