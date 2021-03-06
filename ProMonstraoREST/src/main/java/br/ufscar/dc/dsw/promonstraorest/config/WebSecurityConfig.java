package br.ufscar.dc.dsw.promonstraorest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    protected BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests();
        http.authorizeRequests()
                .antMatchers("/sites", "/sites/{\\d+}").permitAll()
                .antMatchers("/teatros", "/teatros/{\\d+}", "/teatros/cidades/{\\w+}").permitAll()
                .antMatchers("/promocoes", "/promocoes/{\\d+}",
                        "/promocoes/sites/{\\d+}", "/promocoes/teatros/{\\d+}").permitAll()
                .anyRequest().authenticated();
    }
}
