package com.course.reg.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COURSES_DETAILS")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer courseid;

	//@Column(name = "courseName")
	private String courseName;

	//@Column(name = "topicName")
	private String topicName;

	//@Column(name = "refUrlText")
	private String refUrlText;

	//@Column(name = "refUrlVideo")
	private String refUrlVideo;

	public Course() {
	}

	public Course(Integer courseid, String courseName, String topicName, String refUrlText, String refUrlVideo) {
		super();
		this.courseid = courseid;
		this.courseName = courseName;
		this.topicName = topicName;
		this.refUrlText = refUrlText;
		this.refUrlVideo = refUrlVideo;
	}

	public Integer getCourseid() {
		return courseid;
	}

	public void setCoursiId(Integer id) {
		this.courseid = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getRefUrlText() {
		return refUrlText;
	}

	public void setRefUrlText(String refUrlText) {
		this.refUrlText = refUrlText;
	}

	public String getRefUrlVideo() {
		return refUrlVideo;
	}

	public void setRefUrlVideo(String refUrlVideo) {
		this.refUrlVideo = refUrlVideo;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseid + ", courseName=" + courseName + ", topicName=" + topicName + ", refUrlText="
				+ refUrlText + ", refUrlVideo=" + refUrlVideo + "]";
	}

}
