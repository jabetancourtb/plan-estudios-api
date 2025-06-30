package com.udistrital.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import com.udistrital.constants.URIConstants;

import lombok.RequiredArgsConstructor;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
	
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http
	    .csrf(csrf -> csrf.disable())
	    .cors(cors -> cors.disable())
    	.authorizeHttpRequests(requests -> requests
			.requestMatchers(WHITE_LIST_URL)
			.permitAll()
		)
    	.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

	    return http.build();
	}
	
	
	private static final String[] WHITE_LIST_URL = {
		"/swagger-ui.html/**", 
		"/swagger-ui/**",
		"/swagger-resources",
		"/swagger-resources/**",
		"/v2/api-docs",
        "/v3/api-docs",
        "/v3/api-docs/**",
		"/api-docs/**",
		"/css/**",
		"/fonts/**",
		"/img/**",
		"/js/**",
		"/auth/**",
		URIConstants.ASIGNATURAS+"/**",
		URIConstants.CARRERAS+"/**",
		URIConstants.CAMPOS_FORMACION+"/**",
		URIConstants.AREAS_FORMACION+"/**",
		URIConstants.SEMESTRES+"/**",
		URIConstants.PRERREQUISITOS+"/**",
		//actuator/**
	};
	
}
