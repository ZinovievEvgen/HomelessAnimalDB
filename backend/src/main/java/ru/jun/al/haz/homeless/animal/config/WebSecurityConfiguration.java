package ru.jun.al.haz.homeless.animal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import ru.jun.al.haz.homeless.animal.security.jwt.JwtTokenProvider;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;

    private static final String[] ADMIN_ENDPOINTS = new String[] {
            "/api/user/create",
            "/api/user/all"
    };
    private static final String LOGIN_ENDPOINT = "/api/auth/login";

    @Autowired
    public WebSecurityConfiguration(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web)  {
        web.ignoring().antMatchers("/v2/api-docs",
                "/swagger-ui.html",
                "/swagger-ui/**",
                "http://localhost:8082/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/",
                "/v3/api-docs/**");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(LOGIN_ENDPOINT).permitAll()
                .antMatchers("/v3/api-docs/**").permitAll()
                .antMatchers(HttpMethod.POST, ADMIN_ENDPOINTS).hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider));
        //http.cors().and().csrf().disable().authorizeRequests().antMatchers("/").permitAll();
    }
}
