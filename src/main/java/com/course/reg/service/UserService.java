package com.course.reg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.course.reg.model.Course;
import com.course.reg.model.UserReg;


public interface UserService extends UserDetailsService{
	
	public void saveUserRegistration(UserReg user);
	public UserReg findUserProfileByLoginUsername(String loginUsername);
	public void updateUserProfileByLoginUsername(String loginUsername,UserReg userProfile);
	//public void updateProfilePicNameForCurrentLoggedInUser(String profilePicfileName, String loginUsername);
	//public void updateContctPicNameForCurrentLoggedInUsername(String contactPicfileName, Long contactId);
	public List<Course> getAllEnrolledCoursesByLoginUsername(String loginUsername);
	public List<Course> getAllCourses();
	//public String enrollTopicName(String loginusername,String topicName);
	public Optional<List<Course>> searchAllTopicsByTopicName(String topicName);
	public String saveCourse(Course course);
	public Course getCourseByTopicName(String topicName);
	public void updateCourse(Course course);
	public String enrollTopicNameForUser(String username, String topicName);
	
}
