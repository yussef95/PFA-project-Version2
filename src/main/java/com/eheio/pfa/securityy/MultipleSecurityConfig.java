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
public class MultipleSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Configuration
	@EnableWebSecurity
	@Order(1)
	public static class AdminConfiguration extends WebSecurityConfigurerAdapter{
		@Autowired
		AdminDetailsService adminDetailsService;
		
		protected void configure(HttpSecurity http) throws Exception {
			     
			http.csrf().disable();
			
			http
			.formLogin()
			.loginPage("/loginAdmin")
			.usernameParameter("email")
			.permitAll();
			
			http
			.antMatcher("/admin/*")
			.authorizeRequests()
			.anyRequest()
			.authenticated();
			
		}
		@Override
		
		protected void configure(AuthenticationManagerBuilder auth)  {
			auth.authenticationProvider(authenticationProvider());	
		}
		
		@Bean
		DaoAuthenticationProvider authenticationProvider() {
			DaoAuthenticationProvider daoauthenticationProvider=new DaoAuthenticationProvider();
			daoauthenticationProvider.setPasswordEncoder(passwordEncoder());
			daoauthenticationProvider.setUserDetailsService(adminDetailsService);
			return daoauthenticationProvider;
		}
		@Bean
		PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
			
		}
	}
	@Configuration
	@Order(2)
	public class EtudiantConfiguration extends WebSecurityConfigurerAdapter {
		
		@Autowired
		EtudiantDetailsService service;
		
		protected void configure(HttpSecurity http) throws Exception {
			 
			
			http.csrf().disable();
			
			     http
				.formLogin()
				.loginPage("/loginEtudiant")
				.usernameParameter("email")
				.permitAll();
			
			        http
					.antMatcher("/etudiant/*")
					.authorizeRequests()
					.anyRequest()
					.authenticated();
					

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
}