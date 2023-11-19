package com.course.reg;

import java.io.File;

import org.springframework.boot.CommandLineRunner;
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

@EntityScan(basePackages={"com.course.reg.model"})@EnableJpaRepositories(basePackages={"com.course.reg.repository"})

@SpringBootApplication
public class CourseRegistrationApp implements CommandLineRunner {

	// @Autowired
	// private UsersRepository usersRepository;

	// @Autowired
	// private CourseRepository coursesRepository;

	// @Autowired
	// private UserCourseRegRepository userCourseRegRepository;

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

	@Override
	public void run(String... args) throws Exception {

		// users
		/*
		 * UserReg user1 = new UserReg(1L,"punyasmruti", "nayak", "punya@gmail.com",
		 * "9962428121", null, null, null, "punya",
		 * "$2a$10$g5fAs.BoSvFLeTwdRst/GuwWFI7Sr12LX4uBr0s8d2pBgzyMUq68e", "ROLE_USER",
		 * 1, null); usersRepository.save(user1);
		 * 
		 * // admin user UserReg user2 = new UserReg(2L,"aswini", "kumar",
		 * "aswini@gmail.com", "9962428121", null, null, null, "aswini",
		 * "$2a$10$g5fAs.BoSvFLeTwdRst/GuwWFI7Sr12LX4uBr0s8d2pBgzyMUq68e", "ROLE_ADMIN",
		 * 1, null); usersRepository.save(user2);
		 * 
		 * // courses Course course1 = new Course(1, "Java", "Core Java",
		 * "https://www.google.com", "https://www.youtube.com");
		 * coursesRepository.save(course1);
		 * 
		 * Course course2 = new Course(2, "Java", "Advanced Java",
		 * "https://www.google.com", "https://www.youtube.com");
		 * coursesRepository.save(course2);
		 * 
		 * UserCourseReg ucr1 = new UserCourseReg("punya", "Core Java");
		 * userCourseRegRepository.save(ucr1);
		 */

	}
}
