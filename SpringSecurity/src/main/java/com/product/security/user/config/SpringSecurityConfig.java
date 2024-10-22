package com.product.security.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SpringSecurityConfig {

	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
			
		return http.authorizeHttpRequests(registry ->{
				registry.requestMatchers("/").permitAll();
				registry.requestMatchers("/admin/**").hasRole("ROLE_ADMIN");
				registry.requestMatchers("/user/**").hasRole("ROLE_USER");
				registry.anyRequest().authenticated();
			}).formLogin(AbstractAuthenticationFilterConfigurer::permitAll).build();
	}
		
//	@Bean
//	DaoAuthenticationConfigurer userDetailsService() {
//			UserDetails userDetails = User.builder()
//										.username("james")
//										.password(passwordEncoder().encode("bond"))
//										.roles("USER").build();
//			
//			UserDetails adminDetails = User.builder()
//										.username("Po")
//										.password(passwordEncoder().encode("panda"))
//										.roles("ADMIN").build();
//			
//			return new DaoAuthenticationConfigurer(userDetails,adminDetails);
//	}
		
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		
//		auth
//			.inMemoryAuthentication()
//			.withUser("james")
//			.password("bond")
//			.roles("USER")
//			.and()
//			.withUser("po")
//			.password("panda")
//			.roles("ADMIN");
//		
//	}
//	
	
}
