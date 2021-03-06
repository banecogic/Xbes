package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AndRequestMatcher;


/**
 * Created by aloha on 28-May-16.
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    public void configure(HttpSecurity http) throws Exception {

/*        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
               // .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();*/


        http.formLogin().disable();
        http.httpBasic().disable();
        //http.logout().logoutUrl(LOGOUT_URL).deleteCookies(SESSION_COOKIE);
        http.rememberMe();
        http.csrf().disable();

       // DODAJE TOKEN http.csrf().csrfTokenRepository(new CookieCsrfTokenRepository());


       /* dr.
        http.formLogin().disable();
        http.httpBasic().disable();
        http.logout().logoutUrl(LOGOUT_URL).deleteCookies(SESSION_COOKIE);
        http.rememberMe();
        http.csrf().disable();
        */

    }

 /*   @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }*/


}
