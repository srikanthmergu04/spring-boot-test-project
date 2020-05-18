package com.interview.javainterview.resource;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.interview.javainterview.model.User;
import com.interview.javainterview.util.Constants;

@Controller
public class UserResource {

	@GetMapping("/displayUsers")
	public ModelAndView displayUsers(ModelAndView modelAndView) throws JsonMappingException, JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		List<User> users = (List<User>) mapper.readValue(Constants.USER_DETAILS, new TypeReference<List<User>>() {
		});

		modelAndView.addObject("users", users);
		modelAndView.setViewName("userDetails.jsp");
		return modelAndView;
	}

}
