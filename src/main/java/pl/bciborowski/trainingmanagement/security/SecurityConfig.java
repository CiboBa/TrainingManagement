package pl.bciborowski.trainingmanagement.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/templates/**", "/static/**", "/webjars/**", "/", "/login*", "/customerForm*", "/customer/new").permitAll()
                .antMatchers("/customers/**", "/customer/**","/customerPanel/**" +
                                "/courses/**", "/course/**", "/courseForm/**",
                        "/lectures/**", "/lecture/**", "/lectureForm/**"
                ).hasAnyRole("CUSTOMER_ROLE", "ADMIN_ROLE")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login-process")
                .defaultSuccessUrl("/customer/panel", true)
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("{noop}a").roles("ADMIN_ROLE")
                .and()
                .withUser("customer").password("{noop}c").roles("CUSTOMER_ROLE")
                .and()
                .withUser("trainer").password("{noop}t").roles("TRAINER_ROLE");
    }

}
