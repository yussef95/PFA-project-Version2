package com.eheio.pfa.securityy;

import com.eheio.pfa.entities.Conseiller;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class MyUserPrincipalConseiller implements UserDetails {
    private  Conseiller conseiller;
    public MyUserPrincipalConseiller(Conseiller conseiller) {

        this.conseiller=conseiller;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return conseiller.getPassword();
    }

    @Override
    public String getUsername() {
        return conseiller.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
