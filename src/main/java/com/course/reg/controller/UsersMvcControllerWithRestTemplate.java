package com.course.reg.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.course.reg.model.UserReg;
import com.course.reg.security.util.SecurityUtil;

@Controller
@RequestMapping("/api/rest/consumer")
public class UsersMvcControllerWithRestTemplate {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	SecurityUtil securityUtil;
	
	@InitBinder
	public void allowEmptyDateBinding(WebDataBinder binder) {
		// Custom String Editor. tell spring to set empty values as null instead of
		// empty string.
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		// Custom Date Editor
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		simpleDateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, false));
	}

	@RequestMapping(value = "/homePage")
	public String homePage() {
		return "consumer/homePage";
	}
	
	@RequestMapping(value = "/register/form")
	public String userRegistrationForm(Model model) {
		model.addAttribute("userRegistration", new UserReg());
		return "consumer/userRegistrationForm";
	}

	@GetMapping(value = "/register/save")
	public String saveUserRegistration(@ModelAttribute UserReg user, ModelMap map) throws URISyntaxException {
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
	    HttpEntity<UserReg> request = new HttpEntity<>(user, headers);
	    //OR
	    //HttpEntity<UserRegistration> request = getEntityWithHeaders(user);
	    
	    final String baseUrl = "http://localhost:8081/api/rest";
	    URI uri = new URI(baseUrl+"/register");
	    ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
		map.put("resp", result.getBody());
		return "consumer/userRegistrationSuccess";
	}

	@GetMapping(value = "/profile1")
	public String userProfile(ModelMap map) {
		//https://www.youtube.com/watch?v=ijcce18bzng
		HttpHeaders header = securityUtil.getAuthorizationHeaders();
		HttpEntity<String> entity = new HttpEntity<>(header);
		String res = restTemplate.exchange("http://localhost:8081/api/rest/profile", HttpMethod.GET, entity, String.class).getBody();
		map.put("res", res);
		return "consumer/userProfile";
	}
	
	
	@GetMapping(value = "/profile")
	public String getUserProfile(ModelMap map) {
		final ResponseEntity<UserReg> responseEntity = restTemplate.getForEntity("http://localhost:8081/api/rest/profile", UserReg.class);
		UserReg user = responseEntity.getBody();
		map.put("res", user);
		return "consumer/userProfile";
	}
	
	@GetMapping(value = "/profileForm")
	public String getProfileFormPage(ModelMap map) {
		String res = restTemplate.exchange("http://localhost:8081/api/rest/profile", HttpMethod.GET, null, String.class).getBody();
		map.put("res", res);
		return "consumer/userProfileForm";
	}

	@PostMapping(value = "/profile")
	public String userProfileUpdate(@ModelAttribute UserReg user, ModelMap map, BindingResult br) {
		String res = restTemplate.exchange("http://localhost:8081/api/rest/profile", HttpMethod.PUT, null, String.class).getBody();
		map.put("res", res);
		return "redirect:/api/rest/consumer/profile";
	}
	
	@SuppressWarnings("unused")
	private HttpEntity<UserReg> getEntityWithHeaders(UserReg user) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<UserReg> entity = new HttpEntity<UserReg>(user, headers);
		return entity;
	}
}
