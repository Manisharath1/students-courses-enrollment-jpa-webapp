package com.course.reg.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users_login")
public class UserLogin implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loginid;
	@Column(name = "login_username")
	private String loginUserName;
	@Column(name = "login_password")
	private String loginPassword;
	@Column(name = "user_role")
	private String userRole;
	@Column(name = "enabled")
	private Integer enabled;

	public UserLogin() {
	}

	public UserLogin(String loginUserName, String loginPassword, String userRole, Integer enabled) {
		super();
		this.loginUserName = loginUserName;
		this.loginPassword = loginPassword;
		this.userRole = userRole;
		this.enabled = enabled;
	}

	public Long getLoginid() {
		return loginid;
	}

	public void setLoginid(Long loginid) {
		this.loginid = loginid;
	}

	public String getLoginUserName() {
		return loginUserName;
	}

	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> listRole = new ArrayList<GrantedAuthority>();
		listRole.add(new SimpleGrantedAuthority(userRole));
		return listRole;
	}

	@Override
	public String getPassword() {
		return loginPassword;
	}

	@Override
	public String getUsername() {
		return loginUserName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
