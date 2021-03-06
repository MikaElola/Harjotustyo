package hh.Harjotustyo.harjotustyo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hh.Harjotustyo.harjotustyo.webcontroller.UserDetailServiceIMPL;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	 @Autowired
	 private UserDetailServiceIMPL userDetailsService;
	 
 @Override
 protected void configure(HttpSecurity http) throws Exception {
	http
	.authorizeRequests()
	.antMatchers("/css/**", "/", "/index", "/signup", "/saveuser").permitAll()
	.antMatchers("/deletebook/{id}", "/deletemusic/{id}", "/deletemovie/{id}" ).hasAuthority("ADMIN")
	.anyRequest().authenticated()
	.and()
.formLogin()
	.loginPage("/login")
	.defaultSuccessUrl("/index")
	.permitAll()
	.and()
.logout()
	.permitAll()
	.logoutSuccessUrl("/index");
	
 }
 @Autowired
 public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
     auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
 }
	
}
