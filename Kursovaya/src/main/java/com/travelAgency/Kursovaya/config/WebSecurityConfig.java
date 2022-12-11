package com.travelAgency.Kursovaya.config;

import com.travelAgency.Kursovaya.service.UserDetailServiceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Autowired
    UserDetailServiceConfig userService;

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .cors().disable()
                .csrf()
                .disable()
                .authorizeHttpRequests((requests) -> requests
                        .antMatchers( "/","/sign_in", "/sign_up","/articles/**","/contacts","/index").permitAll()
                        .antMatchers( "/admin/**", "/index_auth").hasAuthority("admin")
                        .antMatchers("/survey/**", "/index_auth").hasAuthority("patient")
                        .antMatchers("/expert/**", "/index_auth").hasAuthority("expert")
                        .antMatchers("/index_auth").hasAuthority("user")
                )
                .formLogin((form) -> form
                        .loginPage("/sign_in")
                        .defaultSuccessUrl("/index_auth")
                        .permitAll())
                .logout((logout) -> logout
                        .permitAll()
                        .logoutSuccessUrl("/sign_in")
                );

    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth
                .userDetailsService(userService)
                .passwordEncoder(passwordEncoder);
    }

}
