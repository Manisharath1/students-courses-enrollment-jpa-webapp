package com.course.reg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.reg.model.UserCourseReg;

@Repository
public interface UserCourseRegRepository extends JpaRepository<UserCourseReg, Long> {

	List<UserCourseReg> findTopicByLoginUsername(String loginUsername);

}
