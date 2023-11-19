package com.course.reg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.reg.model.UsersLogin;

@Repository
public interface UsersLoginRepository extends JpaRepository<UsersLogin, Long> {
	
	UsersLogin findByLoginUserName(String loginUsername);

}
