package com.course.reg.restcontroller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.reg.constant.URIConstants;
//import com.course.reg.model.UserProfile;
import com.course.reg.model.UserReg;
import com.course.reg.security.util.SecurityUtil;
import com.course.reg.service.UserService;

@RestController
@RequestMapping("/api/rest")
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:4200")
public class UsersRestController {

	@Autowired
	private UserService userService;
	
	@Autowired
	SecurityUtil securityUtil;
	
	@InitBinder
	public void allowEmptyDateBinding(WebDataBinder binder) {
		// Custom String Editor. tell spring to set empty values as null instead of empty string.
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		// Custom Date Editor
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		simpleDateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, false));
	}

	@PostMapping(path = URIConstants.SAVE_USER_DETAILS, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> userRegistration(@RequestBody UserReg user) { // need to adde user validation
		userService.saveUserRegistration(user);
		return new ResponseEntity<String>(URIConstants.REGISTRATION_SUCCESS, HttpStatus.OK);
	}
	
	/*@GetMapping(value = URIConstants.GET_USER_PROFILE_BY_LOGIN_USERNAME, produces = MediaType.APPLICATION_JSON_VALUE) 
	public  ResponseEntity<UserProfile> getProfile() {
		String loginUserId = securityUtil.getLoginUsername();
		UserProfile user = userService.findUserProfileByLoginUsername(loginUserId);
		return new ResponseEntity<>(user, new HttpHeaders(), HttpStatus.OK);
	}*/
	
	/*@PutMapping(value = URIConstants.UPDATE_USER_PROFILE_BY_LOGIN_USERNAME, produces = MediaType.APPLICATION_JSON_VALUE) 
	public  ResponseEntity<String> updateUsertProfile(@RequestBody UserProfile user) {
		String loginUsername = securityUtil.getLoginUsername();
		 userService.updateUserProfileByLoginUsername(loginUsername,user);
		return new ResponseEntity<>("user updated successfully", new HttpHeaders(), HttpStatus.OK);
	}*/
}
