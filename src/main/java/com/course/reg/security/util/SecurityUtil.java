package com.course.reg.security.util;

import java.nio.charset.Charset;
import java.util.Arrays;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.course.reg.service.UserService;

@Service
public class SecurityUtil {

	@Autowired
	private UserService userService;

	public String getLoginUsername() {
		String loginUsername = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			loginUsername = ((UserDetails) principal).getUsername();
		} else {
			loginUsername = principal.toString();
		}
		return loginUsername;
	}
	

	public String getLoginUsernameAndPassword() {
		String loginUsername = null;
		String loginPassword = null;
		String loginUsernameWithPassword = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			loginUsername = ((UserDetails) principal).getUsername();
			UserDetails userDetails = userService.loadUserByUsername(loginUsername);
			loginPassword = userDetails.getPassword();
			loginUsernameWithPassword = loginUsername + ":" + loginPassword;
		} else {
			loginUsername = principal.toString();
			UserDetails userDetails = userService.loadUserByUsername(loginUsername);
			loginPassword = userDetails.getPassword();
			loginUsernameWithPassword = loginUsername + ":" + loginPassword;
		}
		return loginUsernameWithPassword;
	}

	public HttpHeaders getAuthorizationHeaders() {
		String credentials = getLoginUsernameAndPassword();
		String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));
		HttpHeaders authHeaders = new HttpHeaders();
		authHeaders.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		authHeaders.setContentType(MediaType.APPLICATION_JSON);
		authHeaders.add("Authorization", "Basic " + encodedCredentials);
		return authHeaders;
	}


	public HttpHeaders createHeaders() {
		return new HttpHeaders() {
			private static final long serialVersionUID = -5689636243169560542L;
			{
				String auth = getLoginUsernameAndPassword();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				set("Authorization", authHeader);
			}
		};
	}
}
