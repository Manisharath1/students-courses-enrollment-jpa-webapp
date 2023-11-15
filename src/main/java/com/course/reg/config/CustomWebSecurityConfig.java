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
	
	//@Autowired
	//private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private UserService userService;


	@Override
	protected void configure(AuthenticationManagerBuilder authManager) throws Exception {
		
		//authManager
		//.inMemoryAuthentication()
		//.withUser("punya").password(passwordEncoder.encode("punya")).roles("USER");
		/*.and()
		.withUser("sai").password(passwordEncoder.encode("sai")).roles("USER")
		.and()
		.withUser("aswini").password(passwordEncoder.encode("aswini")).roles("USER")
		.and()
		.withUser("admin").password(passwordEncoder.encode("admin")).roles("ADMIN","MANAGER");*/
		
		//OR
		authManager.userDetailsService(userService).passwordEncoder(passwordEncoder);
		//https://www.youtube.com/watch?v=ijcce18bzng
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.headers().frameOptions().disable()
		.and()
		.authorizeRequests()
		.antMatchers("./uploads/**","/resources/**","static/css","static/js","/h2-console/**","/","/homePage","/register/**","/api/rest/consumer/homePage","/api/rest/consumer/register/form","/api/rest/register","/view/courses").permitAll()
		.antMatchers("/course/form").hasRole("ADMIN")
		.anyRequest().fullyAuthenticated()
		.and()
		//.httpBasic();
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/login")
		.defaultSuccessUrl("/view/courses")
		//.defaultSuccessUrl("/home")
		//.defaultSuccessUrl("/api/rest/consumer/contacts")
		.failureUrl("/login?error").permitAll()
		.and()
		.logout().permitAll()
		.logoutSuccessUrl("/")
		.and()
	   .exceptionHandling().accessDeniedPage("/accessDenied.jsp");
	}
}