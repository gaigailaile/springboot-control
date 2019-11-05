package com.gai.springsecuritydba;

import com.gai.springsecuritydba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by gaigaicoming on 2019/10/28.
 */
@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    UserService userService;
    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
            .antMatchers("/book/admin/**").hasRole("admin")
            .antMatchers("/book/user/**").access("hasAnyRole('admin','user')")
            .antMatchers("/book/db/**").access("hasRole('admin') and hasRole('dba')")
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .loginProcessingUrl("/login")
            .permitAll()
            .and()
            .csrf()
            .disable();
    }
}
