package com.dcebilingualeducation.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private ImplementsUserDetailsService UserDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/cursos").permitAll()
		.antMatchers("/fazerLogin").permitAll()
		
	
		.antMatchers("/indexAdmin").hasAnyRole("ADMIN") 
		.antMatchers("/cadastrarProfessor").hasAnyRole("ADMIN") 
		.antMatchers("/professores").hasAnyRole("ADMIN") 
		.antMatchers("/cadastrarTurma").hasAnyRole("ADMIN") 
		.antMatchers("/turmas").hasAnyRole("ADMIN")
		
		.antMatchers("/Home_Professor").hasAnyRole("PROF") 
		.antMatchers("/cadastrarBoletim").hasAnyRole("PROF") 
		.antMatchers("/boletins").hasAnyRole("PROF")
		.antMatchers("/turmasp").hasAnyRole("PROF")
		
		.antMatchers("/Home_Aluno").hasAnyRole("ALUNO") 
		.antMatchers("/boletinsA").hasAnyRole("ALUNO") 
		
		
		
		
		.anyRequest().authenticated()
		
		.and().formLogin().permitAll()
		
		.and()
			.logout()
			.logoutSuccessUrl("/")
			.permitAll();
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(UserDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web){
		web.ignoring().antMatchers("/materialize/**", "/style/**", "/img/**");
	}
}
