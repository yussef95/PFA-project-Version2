
package com.eheio.pfa.securityy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

		@Autowired
		private UserDetailsService adminDetailsService;
        
		@Bean
		PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		}
		
		protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authenticationProvider());
		}

		    @Bean
		    DaoAuthenticationProvider authenticationProvider() {
			DaoAuthenticationProvider daoauthenticationProvider = new DaoAuthenticationProvider();
			daoauthenticationProvider.setPasswordEncoder(passwordEncoder());
			daoauthenticationProvider.setUserDetailsService(adminDetailsService);
			return daoauthenticationProvider;
		}
		
		protected void configure(HttpSecurity http) throws Exception {

			        
			        http.csrf().disable();

			          http
			         .authorizeRequests()
					 .antMatchers("/admin/**")
					 .hasAuthority("ADMIN")
					 
					   .and()
			           
				         .authorizeRequests()
						 .antMatchers("/conseiller/**")
						 .hasAuthority("CONSEILLER")
			              
						 .and() 
					         .authorizeRequests()
							 .antMatchers("/etudiant/**")
							 .hasAuthority("ETUDIANT")
			                     
							 .and()
						         .authorizeRequests()
								 .antMatchers("/prof/**")
								 .hasAuthority("PROFESSEUR")
			         
			                      .and()
			                       
			                       .formLogin()
					               .loginPage("/user/login")
					               .usernameParameter("email")
					                .permitAll();
					                  
					                   http
					                   .authorizeRequests()
					                   .antMatchers("/","/college","/lycee","/contact")
					                   .permitAll();
					                   
					                  
					                    http
					                   .exceptionHandling()
					                   .accessDeniedPage("/403");
					                     
					                    
					                    http
					                       .authorizeRequests()
					                       .antMatchers("/resources/**")
					                       .permitAll(); 
                                         
			        
		}
		
	}

	

		
		
	

	
		   
		

	




	
	


	