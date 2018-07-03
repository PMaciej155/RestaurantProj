/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.restaurantProj.Configuration;

import com.example.restaurantProj.security.CustomBasicAuthenticationEntryPoint;
import com.example.restaurantProj.security.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Maciej
 */
@Configuration
@EnableWebSecurity
public class MultiHttpSecurityConfig {

    @Configuration
    @EnableGlobalMethodSecurity(securedEnabled = true,
            prePostEnabled = true)
    @Order(1)
    public class RestSecurityConfiguration extends WebSecurityConfigurerAdapter {
        private static final String REALM="restaurantProj";
        @Autowired
        private MyUserDetailsService userDetailsService;

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth)
                throws Exception {

            auth.userDetailsService(userDetailsService);
        }

        @Bean
        public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint() {
            return new CustomBasicAuthenticationEntryPoint();
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable();
            http
                    .antMatcher("/api/**")
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .authorizeRequests()
                    .antMatchers("/api/**")
                    .authenticated()
                .and()
                    .httpBasic()
                    .realmName(REALM)
                    .authenticationEntryPoint(getBasicAuthEntryPoint());
        }

    }

    @Configuration
    @EnableGlobalMethodSecurity(securedEnabled = true,
            prePostEnabled = true)
    public static class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Autowired
        private MyUserDetailsService userDetailsService;

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth)
                throws Exception {

            auth.userDetailsService(userDetailsService);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.headers().frameOptions().disable();
            http.csrf().disable();
            http.authorizeRequests()
                    .antMatchers("/login").permitAll()
                    .antMatchers("/home").authenticated();
            
            http.authorizeRequests()
                    .antMatchers("/console/**").hasRole("ADMIN");
            http
                    .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/login")
                    .defaultSuccessUrl("/home")
                    .failureUrl("/login")
                .and()
                    .logout()
                    .logoutUrl("/logout")
                    .deleteCookies("my-remember-me")
                    .logoutSuccessUrl("/login")
                .and()
                    .rememberMe()
                    .key("rem-me-key")
                    .rememberMeParameter("remember")
                    .rememberMeCookieName("my-remember-me")
                    .tokenValiditySeconds(1209600);
        }

    }
}
