package project.example.studentManagementSystem.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityConfig {

    @Bean
    public SecurityFilterChain custom_security(HttpSecurity http){

        return http.csrf(customizer-> customizer.disable()).
                authorizeHttpRequests(request -> request.anyRequest().authenticated()).
                httpBasic(Customizer.withDefaults()).build();

    }

    @Bean
    public UserDetailsService userDetails(){

        UserDetails user1= User.withDefaultPasswordEncoder().
                            username("birender").
                            password("111").
                            build();

        UserDetails user2= User.withDefaultPasswordEncoder().
                           username("singh").
                           password("222").
                           build();


        return new InMemoryUserDetailsManager(user1, user2);

    }




}