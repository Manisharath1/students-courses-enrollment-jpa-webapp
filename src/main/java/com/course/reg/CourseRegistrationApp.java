package com.course.reg;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.web.client.RestTemplate;

import com.course.reg.controller.UsersMvcController;

@EntityScan(basePackages = { "com.course.reg.model" })
@EnableJpaRepositories(basePackages = { "com.course.reg.repository" })

@SpringBootApplication
public class CourseRegistrationApp {

	public static void main(String[] args) {
		new File(UsersMvcController.uploadDirectory.toString()).mkdir();
		SpringApplication.run(CourseRegistrationApp.class, args);
	}

	@Bean
	PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	HttpFirewall allowUrlEncodedSlashHttpFirewall() {
		StrictHttpFirewall firewall = new StrictHttpFirewall();
		firewall.setAllowUrlEncodedSlash(true);
		return firewall;
	}

	@Bean
	RestTemplate restTemplate() {
		final RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}
}
