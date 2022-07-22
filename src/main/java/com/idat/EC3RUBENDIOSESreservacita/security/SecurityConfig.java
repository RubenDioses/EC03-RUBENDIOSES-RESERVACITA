package com.idat.EC3RUBENDIOSESreservacita.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("profesor").password(encriptado().encode("123456")).roles("user");
		auth.inMemoryAuthentication().withUser("alumno").password(encriptado().encode("123456")).roles("user");
		auth.inMemoryAuthentication().withUser("tutor").password(encriptado().encode("123456")).roles("user");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/cliente/c1/*").access("hasRole('user')").and().httpBasic().and().csrf().disable();
		http.authorizeRequests().antMatchers("/hospital/h1/*").access("hasRole('user')").and().httpBasic().and().csrf().disable();
		http.authorizeRequests().antMatchers("/usuariocliente/uc1/*").access("hasRole('user')").and().httpBasic().and().csrf().disable();
	}
	
	@Bean
	public PasswordEncoder encriptado() {
		return new BCryptPasswordEncoder();
	}
	
	

	
}
