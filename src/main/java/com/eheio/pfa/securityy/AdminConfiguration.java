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
@Order(1)
public class AdminConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	AdminDetailsService adminDetailsService;
	
	protected void configure(HttpSecurity http) throws Exception {
		      /*
		      http
		     .formLogin()
			 .loginPage("/loginAdmin")
			 .usernameParameter("email");
		     		
			  http
			 .authorizeRequests()
			 .antMatchers("/admin/**")
			 .authenticated()
	         ;
		     */
		 http
	      .authorizeRequests()
	        .antMatchers("/admin/**")
	        .authenticated() 
	        .and()
	        .formLogin()  
	        .loginPage("/loginAdmin") 
	        .usernameParameter("email")
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
		daoauthenticationProvider.setUserDetailsService(adminDetailsService);
		return daoauthenticationProvider;
	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
}
	
	
	
	


