
package com.cs499.organizer.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import javax.sql.DataSource;

//Configures application security.
//Includes:
//- login rules
//- access rules
//- logout behavior

@Configuration
public class SecurityConfig {

	// Sets up the database backed user details service.
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

	return new JdbcUserDetailsManager(dataSource);
    }

	 // Sets security rules for the application.
	 // Includes:
	 // - public pages
	 // - role based access
	 // - login and logout setup
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	http.authorizeHttpRequests(auth -> auth.requestMatchers("/login", "/non-auth", "/css/**", "/js/**", "/landing").permitAll()
		
		.requestMatchers("/task/**").hasAnyRole("TASK", "MANAGER")
		
		.requestMatchers("/contact", "/contact/**").hasAnyRole("CONTACT", "MANAGER")
		
		.requestMatchers("/appointment/**").hasAnyRole("APPOINTMENT", "MANAGER")
		
		.anyRequest().authenticated())
		.formLogin(form -> form.loginPage("/login").loginProcessingUrl("/authentication").permitAll())
		.exceptionHandling(ex -> ex.accessDeniedPage("/non-auth"))
		.logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login?logout").permitAll());
	return http.build();
    }
}