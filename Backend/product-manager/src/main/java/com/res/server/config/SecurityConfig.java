package com.res.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain SFC(HttpSecurity security) throws Exception {
		
		security.cors(Customizer.withDefaults());
		security.csrf(csrf->csrf.disable());
		
		security.authorizeRequests()
		.requestMatchers("/api/v1/**").authenticated()
		.anyRequest()
		.permitAll();
		
		security.oauth2ResourceServer(authServer->authServer.jwt(Customizer.withDefaults()));
		
		
		return security.build();
	}
}
