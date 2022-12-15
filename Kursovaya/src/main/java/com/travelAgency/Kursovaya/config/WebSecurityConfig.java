package com.travelAgency.Kursovaya.config;

import com.travelAgency.Kursovaya.service.UserDetailServiceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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
                        .antMatchers( "/admin/**").hasAuthority("admin")
                        .antMatchers("/test/**").hasAuthority("patient")
                        .antMatchers("/expert/**").hasAuthority("expert")
                )
               .formLogin((form) -> form
                        .loginPage("/sign_in")
                        .defaultSuccessUrl("/")
                        .permitAll())
                .logout((logout) -> logout
                        .permitAll()
                        .logoutSuccessUrl("/sign_in")
                );
    }
    /*@Configuration
    @Order(1)
    public static class App1ConfigurationAdapter {

        @Bean
        public SecurityFilterChain filterChainApp1(HttpSecurity http) throws Exception {
            http.antMatcher("/admin*")
                    .authorizeRequests()
                    .anyRequest()
                    .hasRole("admin")

                    .and()
                    .formLogin()
                    .loginPage("/loginAdmin")
                    .loginProcessingUrl("/admin_login")
                    .failureUrl("/loginAdmin?error=loginError")
                    .defaultSuccessUrl("/admin")

                    .and()
                    .logout()
                    .logoutUrl("/admin_logout")
                    .logoutSuccessUrl("/")

                    .and()
                    .csrf().disable();
            return http.build();
        }
    }

    @Configuration
    @Order(2)
    public static class App2ConfigurationAdapter {

        @Bean
        public SecurityFilterChain filterChainApp2(HttpSecurity http) throws Exception {
            http.antMatcher("/user*")
                    .authorizeRequests()
                    .anyRequest()
                    .hasRole("user")

                    .and()
                    .formLogin()
                    .loginPage("/loginUser")
                    .loginProcessingUrl("/user_login")
                    .failureUrl("/loginUser?error=loginError")
                    .defaultSuccessUrl("/userPage")

                    .and()
                    .logout()
                    .logoutUrl("/user_logout")
                    .logoutSuccessUrl("/")


                    .and()
                    .csrf().disable();
            return http.build();
        }
    }

    @Configuration
    @Order(3)
    public static class App3ConfigurationAdapter {

        @Bean
        public SecurityFilterChain filterChainApp2(HttpSecurity http) throws Exception {
            http.antMatcher("/patient*")
                    .authorizeRequests()
                    .anyRequest()
                    .hasRole("patient")

                    .and()
                    .formLogin()
                    .loginPage("/loginPatient")
                    .loginProcessingUrl("/patient_login")
                    .failureUrl("/loginPatient?error=loginError")
                    .defaultSuccessUrl("/patientPage")

                    .and()
                    .logout()
                    .logoutUrl("/patient_logout")
                    .logoutSuccessUrl("/")


                    .and()
                    .csrf().disable();
            return http.build();
        }
    }

    @Configuration
    @Order(4)
    public static class App4ConfigurationAdapter {

        @Bean
        public SecurityFilterChain filterChainApp2(HttpSecurity http) throws Exception {
            http.antMatcher("/expert*")
                    .authorizeRequests()
                    .anyRequest()
                    .hasRole("expert")

                    .and()
                    .formLogin()
                    .loginPage("/loginExpert")
                    .loginProcessingUrl("/expert_login")
                    .failureUrl("/loginExpert?error=loginError")
                    .defaultSuccessUrl("/expertPage")

                    .and()
                    .logout()
                    .logoutUrl("/expert_logout")
                    .logoutSuccessUrl("/")

                    .and()
                    .csrf().disable();
            return http.build();
        }
    }*/

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth
                .userDetailsService(userService)
                .passwordEncoder(passwordEncoder);
    }



}
