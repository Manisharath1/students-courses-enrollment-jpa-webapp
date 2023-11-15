package com.course.reg.dao;
/*
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.course.reg.model.Courses;
import com.course.reg.model.UserLogin;
import com.course.reg.model.UserProfile;
import com.course.reg.model.Users;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void saveUserRegistration(Users userRegistration) {
		String query = "INSERT INTO users_details(firstName, lastName, emailId, mobileNo, dob,createdDate, lastUpdatedDate, login_username, login_password,role,isenabled) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
		jdbcTemplate.update(query, userRegistration.getFirstName(), userRegistration.getLastName(), userRegistration.getEmailId(),
				userRegistration.getMobileNo(), userRegistration.getDob(),new Date(), new Date(),userRegistration.getLoginUsername(),userRegistration.getLoginPassword(),userRegistration.getRole(),1);
	}

	
	@Override
	public void updateUserProfileByLoginUsername(String loginUsername,UserProfile userProfile) {
		
		String query = "update users_details set firstName = ?,lastName=?, emailId=?,mobileNo=?,dob=?,lastUpdatedDate=? where login_username = ?";
		jdbcTemplate.update(query, userProfile.getFirstName(), userProfile.getLastName(), userProfile.getEmailId(),userProfile.getMobileNo(), userProfile.getDob(),new Date(),loginUsername);
	}

	@Override
	public UserProfile findUserProfileByLoginUsername(String loginUsername) {
		String query = "SELECT firstName,lastName,emailId,mobileNo,dob,profilePicName,createdDate,lastUpdatedDate,login_username FROM users_details WHERE login_username = ?";
		RowMapper<UserProfile> rowMapper = new BeanPropertyRowMapper<UserProfile>(UserProfile.class);
		UserProfile userProfile = jdbcTemplate.queryForObject(query, rowMapper, loginUsername);
		return userProfile;
	}
	
	@Override
	public UserLogin findUserByLoginUsername(String loginUsername) {
		String query = "SELECT login_username,login_password,role FROM users_details WHERE login_username = ?";
		RowMapper<UserLogin> rowMapper = new BeanPropertyRowMapper<UserLogin>(UserLogin.class);
		UserLogin userLogin = jdbcTemplate.queryForObject(query, rowMapper, loginUsername);
		return userLogin;
	}

	@Override
	public void updateProfilePicNameForCurrentLoggedInUser(String fileName, String loginUsername) {
		String query = "update users_details set profilePicName = ? where login_username = ?";
		jdbcTemplate.update(query,fileName,loginUsername);
	}
	
	@Override
	public void updateContactPicNameByContactIdForCurrentLoggedInUser(String contactPicFileName, Long contactId) {
		String query = "update contacts_details set contactPicName = ? where contactid = ?";
		jdbcTemplate.update(query,contactPicFileName,contactId);
	}
	
	//##############################################################################################################


	@Override
	public List<Courses> getAllCourses() {
		String query = "SELECT * FROM courses_details";
		RowMapper<Courses> rowMapper = new BeanPropertyRowMapper<Courses>(Courses.class);
		List<Courses> courselist = jdbcTemplate.query(query, rowMapper);
		return courselist;
	}


	@Override
	public String enrollTopicName(String loginusername, String topicName) {

		String query = "SELECT * FROM users_enrolled_courses_details WHERE login_username = ? and topicName = ?";
		RowMapper<Courses> rowMapper = new BeanPropertyRowMapper<Courses>(Courses.class);
		List<Courses> courselist = jdbcTemplate.query(query, rowMapper, loginusername, topicName);

		if (courselist.size() == 0) {
			String query2 = "INSERT INTO users_enrolled_courses_details(login_username,topicName) VALUES(?,?)";
			jdbcTemplate.update(query2, loginusername, topicName);
			return topicName+" successfully enrolled";
		} else {
			return topicName+" already enrolled";
		}
	}
	
	@Override
	public List<Courses> getAllEnrolledCoursesByLoginUsername(String loginUsername) {
		
		
		String query = "SELECT * FROM users_enrolled_courses_details WHERE login_username = ?";
		RowMapper<Courses> rowMapper = new BeanPropertyRowMapper<Courses>(Courses.class);
		List<Courses> courselist = jdbcTemplate.query(query, rowMapper, loginUsername);
		
		 String inParams = String.join(",", courselist.stream().map(course -> "'"+course.getTopicName()+"'").collect(Collectors.toList()));
		 List<Courses> coursesList = jdbcTemplate.query(String.format("SELECT * FROM courses_details WHERE topicName IN (%s)",inParams), rowMapper);
	
		return coursesList;
	}

	@Override
	public List<Courses> searchAllTopicsByTopicName(String topicName) {
		String query = "SELECT * FROM COURSES_DETAILS where topicName like '"+ topicName+"%'";
		RowMapper<Courses> rowMapper = new BeanPropertyRowMapper<Courses>(Courses.class);
		List<Courses> courselist = jdbcTemplate.query(query, rowMapper);
		System.out.println("======>"+courselist);
		return courselist;
	}


	@Override
	public String saveCourse(Courses course) {
		
		
		String query = "SELECT * FROM courses_details WHERE topicName = ?";
		RowMapper<Courses> rowMapper = new BeanPropertyRowMapper<Courses>(Courses.class);
		List<Courses> courselist = jdbcTemplate.query(query, rowMapper,course.getTopicName());

		if (courselist.size() == 0) {
			String query2 = "INSERT INTO courses_details(courseName,topicName,refUrlText,refUrlVideo) VALUES(?,?,?,?)";
			jdbcTemplate.update(query2,course.getCourseName(),course.getTopicName(),course.getRefUrlText(),course.getRefUrlVideo());	
			return course.getTopicName()+" successfully added";
		} else {
			return course.getTopicName()+" has already added";
		}
		
	}


	@Override
	public Courses getCourseByTopicName(String topicName) {
		String query = "SELECT * FROM courses_details WHERE topicName = ?";
		RowMapper<Courses> rowMapper = new BeanPropertyRowMapper<Courses>(Courses.class);
		List<Courses> course =  jdbcTemplate.query(query, rowMapper,topicName);
		return course.get(0);
	}


	@Override
	public void updateCourse(Courses course) {
		System.out.println(course);
		String query = "update courses_details set courseName = ?, refUrlText=?,refUrlVideo=? where topicName = ?";
		jdbcTemplate.update(query,course.getCourseName(), course.getRefUrlText(),course.getRefUrlVideo(),course.getTopicName());
		
	}
}*/
