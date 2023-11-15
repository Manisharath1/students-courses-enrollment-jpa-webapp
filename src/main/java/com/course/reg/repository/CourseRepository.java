package com.course.reg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.reg.model.Course;


@Repository
public interface CourseRepository  extends JpaRepository<Course, Long> {

	Course findByTopicName(String topicName);
	Optional<List<Course>> findByTopicNameIgnoreCaseContaining(String topicName);
	List<Course>  findByTopicNameIn(List<String> topicNames);

}
