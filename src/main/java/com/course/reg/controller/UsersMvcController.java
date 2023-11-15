package com.course.reg.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.course.reg.model.Course;
import com.course.reg.model.UserReg;
import com.course.reg.security.util.SecurityUtil;
import com.course.reg.service.UserService;

@Controller
public class UsersMvcController {

	private static Logger log = LoggerFactory.getLogger(UsersMvcController.class);

	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityUtil securityUtil;

	@InitBinder
	public void allowEmptyDateBinding(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		simpleDateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, false));
	}

	@GetMapping(value = { "/", "/home", "/homePage" })
	public String homePage() {
		log.info("Loading Home age");
		return "homePage";
	}

	@GetMapping(value = "/login")
	public String loginPage(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Login Username and Pasword does not match");
		if (logout != null)
			model.addAttribute("messsage", "You have logged out successfully");
		return "login2";
	}

	@GetMapping(value = "/register/form")
	public String userRegistrationForm(Model model) {
		model.addAttribute("userRegistration", new UserReg());
		return "userRegistrationForm";
	}

	@PostMapping(value = "/register/save")
	public String saveUserRegistration(@ModelAttribute(name = "userRegistration") UserReg userRegistration, BindingResult result,ModelMap map) {
		if (result.hasErrors()) {
			return "userRegistrationForm";
		}
		userService.saveUserRegistration(userRegistration);
		map.put("resp", "Registration Successful");
		return "userRegistrationForm";
	}

	@GetMapping(value = "/view/profile")
	public String getUserProfile(ModelMap map) {
		
		UserReg userRegistration = userService.findUserProfileByLoginUsername(securityUtil.getLoginUsername());
		map.put("userProfile", userRegistration);
		
		String loginUserName = securityUtil.getLoginUsername();
		System.out.println(loginUserName);
		
		if (loginUserName != null && !loginUserName.equals("anonymousUser")) {
			UserDetails details = userService.loadUserByUsername(loginUserName);
			if (details != null && details.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
				return "viewUserProfileAdmin";
			}
		}
		return "viewUserProfile";
	}

	@GetMapping(value = "/editProfileForm/{loginUsername}")
	public String updateUserProfileFormPage(@PathVariable String loginUsername, ModelMap map) {
		UserReg user = userService.findUserProfileByLoginUsername(loginUsername);
		map.addAttribute("userReg", user);
		return "updateUserProfileForm";
	}

	@PostMapping(value = "/profile/update")
	public String updateUserProfile(@Valid @ModelAttribute UserReg userReg, BindingResult br) {
		if (br.hasErrors()) {
			return "updateUserProfileForm";
		}
		userService.updateUserProfileByLoginUsername(securityUtil.getLoginUsername(), userReg);
		return "redirect:/view/profile";
	}

	/*
	 * @GetMapping(value = "/setProfilePic") public String getProfilePicForm() {
	 * return "profilePicForm2"; }
	 */

	/*@PostMapping(value = "/image-upload/saveEmployee")
	public @ResponseBody ResponseEntity<?> saveprofilePic(final @RequestParam("file") MultipartFile file) {
		try {
			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			String fileType = file.getContentType();
			long size = file.getSize();
			String fileSize = String.valueOf(size);

			log.info("FileName: " + file.getOriginalFilename());
			log.info("FileType: " + fileType);
			log.info("FileSize: " + fileSize);

			// Save the file locally
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(file.getBytes());
			stream.close();
			userService.updateProfilePicNameForCurrentLoggedInUser(fileName, securityUtil.getLoginUsername());
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception: " + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}*/

	/*@PostMapping(value = "/savefile")
	public String saveimage(@RequestParam MultipartFile file, @RequestParam(name = "contactId") Long contactId)
			throws Exception {

		String fileName = file.getOriginalFilename();
		String filePath = Paths.get(uploadDirectory, fileName).toString();

		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
		stream.write(file.getBytes());
		stream.flush();
		stream.close();
		userService.updateContctPicNameForCurrentLoggedInUsername(fileName, contactId);

		return "redirect:/view/courses";
	}*/
	
	
	@GetMapping(value = "/view/courses")
	public String allCourses(ModelMap map) {
		List<Course> courseList = userService.getAllCourses();
		//System.out.println(courseList);
		map.put("courseList", courseList);
		
		String loginUserName = securityUtil.getLoginUsername();
		System.out.println(loginUserName);
		if (loginUserName != null && !loginUserName.equals("anonymousUser")) {
			UserDetails details = userService.loadUserByUsername(loginUserName);
			if (details != null && details.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
				return "viewAllCoursesAdmin";
			}
		}
		return "viewAllCourses";

	}
	
	
	@GetMapping(value = "/enroll/{topicName}")
	public String enrollTopicName(@PathVariable(name = "topicName", required = true) String topicName, ModelMap map) {
		String res = userService.enrollTopicNameForUser(securityUtil.getLoginUsername(), topicName);
		map.put("enroll", res);
		return "enrollSuccess";
	}
	
	
	@GetMapping(value = "/view/enrolledcourses")
	public String myCourses(ModelMap map) {
		List<Course> courseListForUser = userService.getAllEnrolledCoursesByLoginUsername(securityUtil.getLoginUsername());
		map.put("enrolledCourseList", courseListForUser);
		return "viewAllEnrolledCoursesForUser";
	}

	@GetMapping(value = "/admin/search/topic")
	public String adminSearchTopic(@RequestParam("topic") String topic, ModelMap map) {
		Optional<List<Course>> courseList = userService.searchAllTopicsByTopicName(topic);
		if(courseList.isPresent()) {
			map.put("courseList", courseList.get());
			return "viewAllCoursesAdmin";
		}else {
			return "viewCoursesAdmin";
		}
	}

	@GetMapping(value = "/user/search/topic")
	public String searchTopicByToicName(@RequestParam("topicName") String topicName, ModelMap map) {
		Optional<List<Course>> courseListForUser = userService.searchAllTopicsByTopicName(topicName);
		if(courseListForUser.isPresent())
			map.put("enrolledCourseList", courseListForUser.get());
		return "viewAllEnrolledCoursesForUser";
	}
	
	// user enrolled courses page
		/*@GetMapping(value = "/search/topic")
		public String searchTopic(@RequestParam("topic") String topic, ModelMap map) {
			List<Courses> courseList = userService.searchAllTopicsByTopicName(topic);
			map.put("courseList", courseList);
			return "viewAllCourses";
		}*/

	@GetMapping(value = "/course/form")
	public String getAddCourseFormPage(ModelMap model) {
		model.addAttribute("course", new Course());
		return "addCourseForm";
	}

	@GetMapping(value = "/edit/courseForm/{topicName}")
	public String updateCourseFormPage(@PathVariable String topicName, ModelMap map) {
		Course course = userService.getCourseByTopicName(topicName);
		map.addAttribute("course", course);
		return "updateCourseForm";
	}

	@PostMapping(value = "/course/save")
	public String saveCourse(@Valid @ModelAttribute Course course, BindingResult br, ModelMap map) {
		if (br.hasErrors()) {
			return "addCourseForm";
		}
		String reg = userService.saveCourse(course);
		map.put("reg", reg);
		return "courseAddSuccess";
	}

	@PostMapping(value = "/course/update")
	public String updateCourse(@Valid @ModelAttribute Course course, BindingResult br) {
		if (br.hasErrors()) {
			return "updateCourseForm";
		}
		userService.updateCourse(course);
		return "redirect:/view/courses";
	}
}
