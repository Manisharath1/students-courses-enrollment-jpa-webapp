package com.course.reg.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "users_details")
public class UserReg {

	private static final long serialVersionUID = -300263021830590898L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userid;

	@NotEmpty(message = "First name should not be empty")
	@Column(name = "first_name")
	private String firstName;

	@NotEmpty(message = "Last name should not be empty")
	@Column(name = "last_name")
	private String lastName;

	@NotEmpty(message = "Email should not be empty")
	//@Size(min = 10, max = 20)
	@Column(name = "email_id")
	private String emailId;

	@NotEmpty(message = "Mobile No should not be empty")
	//@Size(min=10,max = 10)
	@Column(name = "mobile_no")
	private String mobileNo;

	@NotEmpty(message = "Login Username should not be empty")
	@Column(name = "login_username")
	private String loginUsername;

	@Transient
	private String loginPassword;

	@Transient
	private String userRole;

	@Transient
	private Integer enabled;

	@Transient
	private String adminCode;

	public UserReg() {
	}

	public UserReg(Long userid, String firstName, String lastName, String emailId, String mobileNo, Date dob,
			Date createdDate, Date lastUpdatedDate, String loginUsername, String loginPassword, String role,
			int enabled, String adminCode) {
		super();
		this.userid = userid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.loginUsername = loginUsername;
		this.loginPassword = loginPassword;
		this.userRole = role;
		this.enabled = enabled;
		this.adminCode = adminCode;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userId) {
		this.userid = userId;
	}

	public void setUserRole(String role) {
		this.userRole = role;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getLoginUsername() {
		return loginUsername;
	}

	public void setLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getAdminCode() {
		return adminCode;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public String getUserRole() {
		return userRole;
	}

	@Override
	public String toString() {
		return "UserReg [userid=" + userid + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", mobileNo=" + mobileNo + ", loginUsername=" + loginUsername
				+ ", loginPassword=" + loginPassword + ", userRole=" + userRole + ", enabled=" + enabled
				+ ", adminCode=" + adminCode + "]";
	}


}
