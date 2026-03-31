package com.secure.notes.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
// import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  
  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests((req) -> req
                      .anyRequest().authenticated());

    // http.csrf(csrf -> csrf.disable());
    http.csrf(AbstractHttpConfigurer::disable); // this line is the same as the above line.


    // http.formLogin(withDefaults());

    // Due to this line of code, the application will not create a session and will not store any authentication information in the session. 
    // Nothing will be stored in cookies, and the application will not rely on cookies for authentication.
    // http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

    http.httpBasic(withDefaults());

    return http.build();
  }
}
