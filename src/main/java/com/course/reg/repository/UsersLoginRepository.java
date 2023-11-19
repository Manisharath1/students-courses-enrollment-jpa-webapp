package com.course.reg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.reg.model.UserLogin;

@Repository
public interface UsersLoginRepository extends JpaRepository<UserLogin, Long> {
	
	UserLogin findByLoginUserName(String loginUsername);

}
