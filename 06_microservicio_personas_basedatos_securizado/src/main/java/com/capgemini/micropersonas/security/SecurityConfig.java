package com.capgemini.micropersonas.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new PasswordEncoder() {
			@Override
			public String encode(CharSequence rawPassword) {
				return rawPassword.toString();
			}

			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return rawPassword.toString().equals(encodedPassword);
			}
		};
	}

	@Bean
	public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
		UserDetails user1 = User.withUsername("juan")
				.password("user123")
				.roles("USER")
				.build();

		UserDetails user2 = User.withUsername("ana")
				.password("user456")
				.roles("USER")
				.build();

		UserDetails admin = User.withUsername("admin")
				.password("admin789")
				.roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user1, user2, admin);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authorizeHttpRequests(auth -> auth
				.requestMatchers("/login").permitAll()
				.requestMatchers(HttpMethod.POST, "/personas").hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/personas/**").hasRole("ADMIN")
				.requestMatchers("/personas/**").authenticated()
				.anyRequest().authenticated()
			)
			.addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}