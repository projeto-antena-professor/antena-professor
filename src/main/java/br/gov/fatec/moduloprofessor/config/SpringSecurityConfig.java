package br.gov.fatec.moduloprofessor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.gov.fatec.moduloprofessor.service.MongoUserDetailService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter
{

	@Autowired
	MongoUserDetailService userDetailsService;
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("password")).roles("PROFESSOR")
                .and()
                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
        
        //auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
    	.csrf().disable()
        .authorizeRequests()
        //.antMatchers("/admin/**").hasRole("ADMIN")
        //.antMatchers("/anonymous*").anonymous()
        //.antMatchers("/login*").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        //.loginPage("/login.html")
        //.loginProcessingUrl("/perform_login")
        //.defaultSuccessUrl("/index.html", true)
        //.failureUrl("/login.html?error=true")
        //.failureHandler(authenticationFailureHandler())
        .and()
        .logout()
        .logoutSuccessUrl("/logout.html")
        .deleteCookies("JSESSIONID");
        //.logoutSuccessHandler(logoutSuccessHandler());
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

    
