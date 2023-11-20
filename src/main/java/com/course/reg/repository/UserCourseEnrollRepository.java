package com.course.reg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.reg.model.UserCourseEnroll;

@Repository
public interface UserCourseEnrollRepository extends JpaRepository<UserCourseEnroll, Long> {

	List<UserCourseEnroll> findTopicByLoginUsername(String loginUsername);

	UserCourseEnroll findByLoginUsernameAndTopicName(String loginusername, String topicName);
	Optional<List<UserCourseEnroll>> findByLoginUsernameAndTopicNameIgnoreCaseContaining(String loginusername,String topicName);

}
