package com.course.reg.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.course.reg.model.Course;
import com.course.reg.model.UserCourseEnroll;
import com.course.reg.model.UserReg;
import com.course.reg.model.UserLogin;
import com.course.reg.repository.CourseRepository;
import com.course.reg.repository.UserCourseEnrollRepository;
import com.course.reg.repository.UsersLoginRepository;
import com.course.reg.repository.UsersRegRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersRegRepository usersRegRepository;

	@Autowired
	private UserCourseEnrollRepository userCourseEnrollRepository;

	@Autowired
	private CourseRepository coursesRepository;

	@Autowired
	private UsersLoginRepository usersLoginRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String loginUsername) throws UsernameNotFoundException {

		UserLogin userLogin = usersLoginRepository.findByLoginUserName(loginUsername);
		Set<GrantedAuthority> grantedauthorities = new HashSet<>();
		grantedauthorities.add(new SimpleGrantedAuthority(userLogin.getUserRole()));
		return new org.springframework.security.core.userdetails.User(userLogin.getLoginUserName(),
				userLogin.getLoginPassword(), grantedauthorities);

	}

	@Override
	public void saveUserRegistration(UserReg user) {
		

		if (user != null && user.getAdminCode() != null && user.getAdminCode().equals("121")) {
			user.setLoginPassword(passwordEncoder.encode(user.getLoginPassword()));
			user.setUserRole("ROLE_ADMIN");
			user.setEnabled(1);
		} else {
			user.setLoginPassword(passwordEncoder.encode(user.getLoginPassword()));
			user.setUserRole("ROLE_USER");
			user.setEnabled(1);
		}

		usersRegRepository.save(user);

		UserLogin login = new UserLogin(user.getLoginUsername(), user.getLoginPassword(), user.getUserRole(),
				user.getEnabled());
		usersLoginRepository.save(login);

	}

	@Override
	public UserReg findUserProfileByUserId(Long userid) {
		UserReg userReg = usersRegRepository.findById(userid).get();
		return userReg;
	}

	@Override
	public UserReg findUserProfileByLoginUsername(String username) {
		UserReg userReg = usersRegRepository.findByLoginUsername(username);
		return userReg;
	}

	@Override
	public void updateUserProfile(UserReg userProfile) {
		usersRegRepository.save(userProfile);
	}

	@Override
	public List<Course> getAllCourses() {
		List<Course> coursesList = coursesRepository.findAll();
		return coursesList;
	}

	@Override
	public List<Course> getAllEnrolledCoursesByLoginUsername(String loginUsername) {
		List<UserCourseEnroll> UserCourseRegList = userCourseEnrollRepository.findTopicByLoginUsername(loginUsername);
		List<String> topicNames = UserCourseRegList.stream().map(UserCourseEnroll::getTopicName)
				.collect(Collectors.toList());
		return coursesRepository.findByTopicNameIn(topicNames);
	}

	@Override
	public String enrollTopicNameForUser(String loginusername, String topicName) {
		UserCourseEnroll obj = new UserCourseEnroll(loginusername, topicName);
		UserCourseEnroll obj2 = userCourseEnrollRepository.findByLoginUsernameAndTopicName(loginusername, topicName);
		if (obj2 == null) {
			userCourseEnrollRepository.save(obj);
			return topicName + " enrolled successfully";
		} else {
			return topicName + " has already enrolled";
		}
	}
	
	@Override
	public List<Course> searchAllEnrolledTopicsByTopicName(String loginusername,String topicName) {
		Optional<List<UserCourseEnroll>> obj2 = userCourseEnrollRepository.findByLoginUsernameAndTopicNameIgnoreCaseContaining(loginusername, topicName);
		List<String> topicNames = null;
		if(obj2.isPresent()) {
			topicNames = obj2.get().stream().map(UserCourseEnroll::getTopicName).collect(Collectors.toList());
		}
		return coursesRepository.findByTopicNameIn(topicNames);
	}

	@Override
	public Optional<List<Course>> searchAllTopicsByTopicName(String topicName) {
		return coursesRepository.findByTopicNameIgnoreCaseContaining(topicName);
	}

	@Override
	public String saveCourse(Course course) {
		coursesRepository.save(course);
		return "course saved successfully";
	}

	@Override
	public Course getCourseByCourseId(Long courseId) {
		return coursesRepository.findById(courseId).get();
	}

	@Override
	public void updateCourse(Course course) {
		coursesRepository.save(course);
	}

	@Override
	public List<UserReg> getAllUsers() {
		return usersRegRepository.findAll();
	}

	
}
