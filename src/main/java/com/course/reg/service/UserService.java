package com.course.reg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.course.reg.model.Course;
import com.course.reg.model.UserReg;


public interface UserService extends UserDetailsService{
	
	public void saveUserRegistration(UserReg user);
	public UserReg findUserProfileByUserId(Long userid);
	public UserReg findUserProfileByLoginUsername(String loginusername);
	public void updateUserProfile(UserReg userProfile);
	public List<Course> getAllEnrolledCoursesByLoginUsername(String loginUsername);
	public List<Course> getAllCourses();
	public List<UserReg> getAllUsers();
	public Optional<List<Course>> searchAllTopicsByTopicName(String topicName);
	public String saveCourse(Course course);
	public Course getCourseByCourseId(Long courseId);
	public void updateCourse(Course course);
	public String enrollTopicNameForUser(String username, String topicName);
	
}
