package com.course.reg.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.course.reg.service.UserService;

@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;


	@Override
	protected void configure(AuthenticationManagerBuilder authManager) throws Exception {
		
		authManager.userDetailsService(userService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.headers().frameOptions().disable()
		.and()
		.authorizeRequests()
		.antMatchers("./uploads/**","/resources/**","static/css","static/js","/h2-console/**","/","/homePage","/register/**","/api/rest/consumer/homePage","/api/rest/consumer/register/form","/api/rest/register","/view/courses","/user/search/topic").permitAll()
		.antMatchers("/course/form").hasRole("ADMIN")
		.antMatchers("/view/users").hasRole("ADMIN")
		.anyRequest().fullyAuthenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/login")
		.defaultSuccessUrl("/view/courses")
		.failureUrl("/login?error").permitAll()
		.and()
		.logout().permitAll()
		.logoutSuccessUrl("/")
		.and()
	   .exceptionHandling().accessDeniedPage("/accessDenied.jsp");
	}
}