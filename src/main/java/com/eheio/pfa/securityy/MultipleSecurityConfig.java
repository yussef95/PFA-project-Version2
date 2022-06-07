
package com.eheio.pfa.securityy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class MultipleSecurityConfig {

	@Configuration
	@Order(1)
	public static class AdminConfiguration extends WebSecurityConfigurerAdapter {

		@Autowired
		private AdminDetailsService adminDetailsService;

		protected void configure(HttpSecurity http) throws Exception {

			        /*
			        http.csrf().disable();

			         http
					.antMatcher("/admin/**")
					.authorizeRequests()
					.anyRequest()
					.authenticated()
					.and()
			        .formLogin()
					.loginPage("/admin/login")
					.usernameParameter("nomUtilisateur")
					.defaultSuccessUrl("/admin/ProfileAdmin")
					.permitAll();
                     */

			         http.requestMatcher(new AntPathRequestMatcher("/admin/**"))
					.csrf().disable()
					.authorizeRequests()
					.antMatchers("/admin/**").authenticated()
					.and().formLogin()
					.loginPage("/admin/login").permitAll().usernameParameter("nomUtilisateur")
					.passwordParameter("password").defaultSuccessUrl("/admin/ProfileAdmin");

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

		@Bean
		PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();

		}
	}

	@Configuration
	@Order(2)

	public static class ConseillerConfiguration extends WebSecurityConfigurerAdapter {

		@Autowired
		private ConseillerDetailsService conseillerDetailsServiceservice;

		protected void configure(HttpSecurity http) throws Exception {


			http.csrf().disable();

			http
					.antMatcher("/conseiller/**")
					.authorizeRequests()
					.anyRequest()
					.authenticated()

					.and()
					.formLogin()
					.loginPage("/conseiller/loginConseiller")
					.usernameParameter("email")
					.defaultSuccessUrl("/conseiller/monProfile")
					.permitAll();


		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) {
			auth.authenticationProvider(authenticationProvider());

		}

		@Bean
		DaoAuthenticationProvider authenticationProvider() {
			DaoAuthenticationProvider daoauthenticationProvider = new DaoAuthenticationProvider();
			daoauthenticationProvider.setPasswordEncoder(passwordEncoder());
			daoauthenticationProvider.setUserDetailsService(conseillerDetailsServiceservice);
			return daoauthenticationProvider;
		}

		@Bean
		PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();

		}
	}

	@Configuration
	@Order(3)
	public static class EtudianConfiguration extends WebSecurityConfigurerAdapter{

		@Autowired
		private EtudiantDetailsService service;
		protected void Configure(HttpSecurity http) throws Exception{
			      http.csrf().disable();

			         http
					.antMatcher("/etudiant/**")
					.authorizeRequests()
					.anyRequest()
					.authenticated()

					.and()
					.formLogin()
					.loginPage("/etudiant/loginEtudiant")
					.usernameParameter("email")
					.defaultSuccessUrl("/etudiant/ProfileEtudiant")
					.permitAll();
		}
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


	
	


	