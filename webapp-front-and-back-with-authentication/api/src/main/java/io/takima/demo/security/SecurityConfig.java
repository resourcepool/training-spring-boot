package io.takima.demo.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private FirebaseProperties firebaseProperties;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Bean
    public FirebaseApp firebaseInit() throws IOException {
        Resource resource = new ClassPathResource("firebase-service-account.json");

        if (!resource.exists()) {
            throw new IllegalStateException("Firebase service key file not found");
        }
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(resource.getInputStream()))
                .setDatabaseUrl(firebaseProperties.getDatabaseUrl())
                .build();
        if (!FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.getInstance().delete();
        }
        return FirebaseApp.initializeApp(options);
    }

    @Bean
    public AuthenticationEntryPoint restAuthenticationEntryPoint() {
        return (httpServletRequest, httpServletResponse, e) -> {
            Map<String, Object> errorObject = new HashMap<String, Object>();
            int errorCode = 401;
            errorObject.put("message", "Unauthorized access of protected resource, invalid credentials");
            errorObject.put("error", HttpStatus.UNAUTHORIZED);
            errorObject.put("code", errorCode);
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.setStatus(errorCode);
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(errorObject));
        };
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        AuthenticationFilter firebaseAuthenticationFilter = new AuthenticationFilter(new FirebaseAuthenticationManager(), new FirebaseAuthenticationConverter());
        firebaseAuthenticationFilter.setSuccessHandler(new FirebaseAuthenticationSuccessHandler());
        firebaseAuthenticationFilter.setRequestMatcher(request -> {
            if (request.getMethod().equals(HttpMethod.OPTIONS.name())) {
                return false;
            }
            // NB: ALL uris will be processed by this filter. NOTHING is public here.
            // All non-authenticated requests will be considered "anonymous" with authority "role_anonymous"
            return true;
        });

        http.cors()
                .and()
                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint())
                .and()
                .addFilterAfter(firebaseAuthenticationFilter, CorsFilter.class)
                .authorizeRequests()
                .antMatchers("/books").permitAll()
                .antMatchers("/books/user/**").authenticated();
    }

}
