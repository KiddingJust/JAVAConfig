package org.kidding.config;

import org.kidding.security.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j;

@Configuration
@EnableWebSecurity
@Log4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//		auth.inMemoryAuthentication()
//		.withUser("admin").password("{noop}admin").roles("ADMIN", "MEMBER");
//		
//		auth.inMemoryAuthentication()
//		.withUser("member").password("{noop}member").roles("MEMBER");
//		
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		log.warn("-------------------------------------------");
		log.warn("security configure");
		log.warn("-------------------------------------------");

		http.authorizeRequests().antMatchers("/sample/member").access("hasRole('ROLE_MEMBER')")
				.antMatchers("/sample/admin").access("hasRole('ROLE_ADMIN')");

		// 로그인 페이지 기본 제공 여부?
		http.formLogin();
		http.rememberMe().tokenValiditySeconds(604800);	}

}
