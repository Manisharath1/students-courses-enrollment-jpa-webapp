package com.course.reg.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.course.reg.model.Course;
import com.course.reg.model.UserCourseReg;
import com.course.reg.model.UserReg;
import com.course.reg.repository.CourseRepository;
import com.course.reg.repository.UserCourseRegRepository;
import com.course.reg.repository.UsersRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private UserCourseRegRepository userCourseRegRepository;

	@Autowired
	private CourseRepository coursesRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String loginUsername) throws UsernameNotFoundException {

		UserReg userReg = usersRepository.findByLoginUsername(loginUsername);
		GrantedAuthority authority = null;
		UserDetails userDetails = null;
		User user = null;
		if (userReg != null) {
			authority = new SimpleGrantedAuthority(userReg.getRole());
			user = new User(userReg.getLoginUsername(), userReg.getLoginPassword(), Arrays.asList(authority));
			userDetails = (UserDetails) user;
		}
		return userDetails;
	}

	@Override
	public void saveUserRegistration(UserReg user) {
		user.setLoginPassword(passwordEncoder.encode(user.getLoginPassword()));

		if (user != null && user.getAdminCode() != null && user.getAdminCode().equals("121")) {
			user.setRole("ROLE_ADMIN");
		} else {
			user.setRole("ROLE_USER");
		}

		usersRepository.save(user);
	}

	@Override
	public UserReg findUserProfileByLoginUsername(String loginUsername) {
		UserReg userReg = usersRepository.findByLoginUsername(loginUsername);
		return userReg;
	}

	@Override
	public void updateUserProfileByLoginUsername(String loginUsername, UserReg userProfile) {

		UserReg user = usersRepository.findByLoginUsername(loginUsername);
		user.setFirstName(userProfile.getFirstName());
		user.setLastName(userProfile.getLastName());
		user.setEmailId(userProfile.getEmailId());
		user.setMobileNo(userProfile.getMobileNo());
		user.setDob(userProfile.getDob());
		usersRepository.save(user);
	}

	/*
	 * @Override public void updateProfilePicNameForCurrentLoggedInUser(String
	 * fileName, String loginUsername) {
	 * userDao.updateProfilePicNameForCurrentLoggedInUser(fileName, loginUsername);
	 * }
	 */

	/*
	 * @Override public void updateContctPicNameForCurrentLoggedInUsername(String
	 * fileName, Long contactId) {
	 * userDao.updateContactPicNameByContactIdForCurrentLoggedInUser(fileName,
	 * contactId); }
	 */

	@Override
	public List<Course> getAllCourses() {
		List<Course> coursesList = coursesRepository.findAll();
		return coursesList;
	}

	@Override
	public List<Course> getAllEnrolledCoursesByLoginUsername(String loginUsername) {
		List<UserCourseReg> UserCourseRegList = userCourseRegRepository.findTopicByLoginUsername(loginUsername);
		List<String> topicNames = UserCourseRegList.stream().map(UserCourseReg::getTopicName)
				.collect(Collectors.toList());
		return coursesRepository.findByTopicNameIn(topicNames);
	}

	@Override
	public String enrollTopicNameForUser(String loginusername, String topicName) {
		UserCourseReg obj = new UserCourseReg(loginusername, topicName);
		userCourseRegRepository.save(obj);
		return topicName + " enrolled successfully";
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
	public Course getCourseByTopicName(String topicName) {
		return coursesRepository.findByTopicName(topicName);
	}

	@Override
	public void updateCourse(Course course) {
		coursesRepository.save(course);
	}
}
