package com.course.reg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.reg.model.UserReg;

@Repository
public interface UsersRepository extends JpaRepository<UserReg, Long> {
	UserReg findByLoginUsername(String loginUsername);
}
