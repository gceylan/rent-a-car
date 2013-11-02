package com.gceylan.rentacar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ModelAndView newUser(ModelAndView model) {
		
		model.setViewName("admin/users/new");
		model.addObject("user", new User());
		model.addObject("allRoles", roleService.getAllRoles());		
		
		return model;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user") @Valid User user,
			BindingResult result, ModelAndView model) {
		
		if (result.hasErrors()) {
			model.setViewName("admin/users/new");
			model.addObject("allRoles", roleService.getAllRoles());
			
			return model;
		}
		
		user.getRole().setId(roleService.getRoleByName(user.getRole().getName()).getId());
		
		userService.addUser(user);
		model.setViewName("redirect:/admin/users/list");
		
		return model;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editUserPage(@PathVariable("id") Integer id,
			ModelAndView model) {
		
		model.setViewName("admin/users/edit");
		model.addObject("user", userService.getUserById(id));
		model.addObject("allRoles", roleService.getAllRoles());
		
		return model;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editUser(@PathVariable("id") Integer id,
			@Valid User user, BindingResult result, ModelAndView model) {
		
		if (result.hasErrors()) {
			model.setViewName("admin/users/edit");
			model.addObject("allRoles", roleService.getAllRoles());
			
			return model;
		}
		
		user.getRole().setId(roleService.getRoleByName(user.getRole().getName()).getId());
		
		userService.updateUser(user);
		model.setViewName("redirect:/admin/users/list");
		
		return model;
	}
	
	@RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable("userId") Integer userId,
			ModelAndView model) {
		
		model.setViewName("redirect:/admin/users/list");
		userService.deleteUser(userId);
		
		return model;
	}
	
	@RequestMapping(value = "/profil/{username}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable("username") String username,
			ModelAndView model) {
		
		model.setViewName("admin/users/profil");
		model.addObject("user", userService.getUserByUsername(username));
		
		return model;
	}

}
