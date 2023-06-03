package br.com.fiap.foodflow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.cors(Customizer.withDefaults()).csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(auth -> {
            auth.requestMatchers("/drone/**").hasRole("drone-admin");
            auth.requestMatchers(HttpMethod.GET, "/telemetria/**").hasRole("telemetria-reader");
            auth.requestMatchers(HttpMethod.POST, "/telemetria/**").hasRole("drone-seed");
            auth.requestMatchers("tela/drone/**").hasRole("drone-admin");
            auth.requestMatchers("tela/telemetria/**").hasRole("telemetria-reader");
            auth.anyRequest().denyAll();
        }).formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults()).build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("drone-admin").password("1234").roles("drone-admin").build());
        manager.createUser(users.username("drone-seed").password("1234").roles("drone-seed").build());
        manager.createUser(users.username("telemetria-reader").password("1234").roles("telemetria-reader").build());
        return manager;
    }

}
