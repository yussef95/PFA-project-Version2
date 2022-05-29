package com.eheio.pfa.securityy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@Order(2)
public class EtudiantConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	EtudiantDetailsService service;
	
	protected void configure(HttpSecurity http) throws Exception {
		 /*
	     http
	    .formLogin()
		.loginPage("/loginEtudiant")
		.usernameParameter("email");
	     		
		  http
		 .authorizeRequests()
		 .antMatchers("/etudiant/**")
		 .authenticated()
         ;
	     */
		
		 http
	        .authorizeRequests()
	        .antMatchers("/","/college","/lycee","contact").permitAll() 
	        .antMatchers("/etudiant/**")
	        .authenticated() 
	        .and()
	        .formLogin()  
	        .loginPage("/loginEtudiant") 
	        .permitAll(); 
		 
		 http
		.exceptionHandling()
		.accessDeniedPage("/403");
}
	@Override
	protected void configure(AuthenticationManagerBuilder auth)  {
		auth.authenticationProvider(authenticationProvider());
		
	}
	
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoauthenticationProvider=new DaoAuthenticationProvider();
		daoauthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoauthenticationProvider.setUserDetailsService(service);
		return daoauthenticationProvider;
	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
}

