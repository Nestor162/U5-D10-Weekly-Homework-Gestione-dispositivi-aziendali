package nestorcicardini.D10.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	JWTAuthFilter jwtAuthFilter;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http)
			throws Exception {
		// Disabilito la prottezione CORS (Cross-Origin Resource Sharing)
		http.cors(c -> c.disable());

		// Disabilito la protezione CSRF (Cross-Site Request Forgery)
		http.csrf(c -> c.disable());

		// Imposto su quali endpoint si puo accedere senza autenticazione e dove
		// invece questa è richiesta

		http.authorizeHttpRequests(
				auth -> auth.requestMatchers("/auth/**").permitAll());
		http.authorizeHttpRequests(
				auth -> auth.requestMatchers("/users/**").permitAll()); // authenticated());
		http.authorizeHttpRequests(
				auth -> auth.requestMatchers("/devices/**").authenticated());

//		http.addFilterBefore(jwtAuthFilter,
//				UsernamePasswordAuthenticationFilter.class);

		// Imposto la gestione delle sessioni come "STATELESS". Il token non
		// verrà salvato su backend, verrà soltato inviato a frontend
		http.sessionManagement(session -> session
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		return http.build();
	}

}