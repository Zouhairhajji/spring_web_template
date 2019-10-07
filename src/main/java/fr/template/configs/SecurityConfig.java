package fr.template.configs;

import fr.template.handlers.CustomAuthSuccess;
import fr.template.services.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author QTKT2194
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthentificationService authService;
    
    @Autowired
    private CustomAuthSuccess  customAuthSuccess;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/register**").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/login**").permitAll()
                .antMatchers("/users/**").authenticated()
                .antMatchers("/roles/**").authenticated()
                .antMatchers("/**").authenticated();;
        // STATICS STUFFS

        // login pages configs 
        http.formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/", Boolean.FALSE)
                .successHandler(this.customAuthSuccess)
                ;

        // logout config
        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .permitAll()
                ;
        
        // access denied config
        http.exceptionHandling().accessDeniedPage("/403");
        
        
        // ignore x-frame
        http.headers().frameOptions().disable();
        
        http.csrf().ignoringAntMatchers("/h2-console/**");

        
        //http.addheaders().successHandler(this.customAuthSuccess);
        //http.failureHandler(this.customAuthenticationFailureHandler);

        http.sessionManagement().maximumSessions(1).expiredUrl("/expired");

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/vendors/**"); // ignore auth for resources
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.authService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
