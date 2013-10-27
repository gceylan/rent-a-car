package com.gceylan.rentacar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gceylan.rentacar.domain.User;
import com.gceylan.rentacar.service.RoleService;
import com.gceylan.rentacar.service.UserService;

@Controller
@RequestMapping("/admin/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView showAllUsers(ModelAndView model) {
		return new ModelAndView("admin/users/list", "users", userService.getAllUsers());
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newUser() {
		return new ModelAndView("admin/users/new", "user", new User());
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user") @Valid User user,
			BindingResult result) {
		
		return new ModelAndView("redirect:/admin/users/list");
	}

}
