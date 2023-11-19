package com.course.reg.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_enrolled_courses_details")
public class UserCourseEnroll {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//@Column(name = "login_username")
	private String loginUsername;

	//@Column(name = "topic_name")
	private String topicName;
	
	public UserCourseEnroll() {}
	
	public UserCourseEnroll(String login_username, String topicName) {
		super();
		this.loginUsername = login_username;
		this.topicName = topicName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginUsername() {
		return loginUsername;
	}

	public void setLoginUsername(String login_username) {
		this.loginUsername = login_username;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	@Override
	public String toString() {
		return "UserCourseReg [id=" + id + ", login_username=" + loginUsername + ", topicName=" + topicName + "]";
	}

}
