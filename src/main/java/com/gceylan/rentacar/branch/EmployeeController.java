package com.gceylan.rentacar.branch;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gceylan.rentacar.domain.Branch;
import com.gceylan.rentacar.domain.User;
import com.gceylan.rentacar.service.RoleService;
import com.gceylan.rentacar.service.UserService;

@Controller
@RequestMapping("/branch/employees")
public class EmployeeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String showAllEmployees(HttpSession session, Model model) {
		Branch branch = (Branch) session.getAttribute("branch");
		model.addAttribute("allEmployees", userService.getAllEmployees(branch));
		return "branch/employees/list";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newEmployeePage(Model model) {
		User user = new User();
		user.setRole(roleService.getRoleById(3));
		
		model.addAttribute("employee", user);
		model.addAttribute("allRoles", roleService.getAllRoles());
		return "branch/employees/new";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView addEmployee(@Valid @ModelAttribute("employee") User employee,
			BindingResult result, HttpSession session, ModelAndView model) {
		employee.getRole().setId(roleService.getRoleByName(employee.getRole().getName()).getId());
		
		Branch branch = (Branch) session.getAttribute("branch");
		
		if (result.hasErrors()) {
			model.setViewName("branch/employees/new");
			model.addObject("allRoles", roleService.getAllRoles());
			
			return model;
		}
		
//		employee.getRole().setId(roleService.getRoleByName(employee.getRole().getName()).getId());
		employee.setBranch(branch);
		
		userService.addUser(employee);
		
		model.setViewName("redirect:/branch/employees/list");
		
		return model;
	}
	
	@RequestMapping(value = "/delete/{empId}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable("empId") Integer empId, Model model) {
		userService.deleteUser(empId);
		return "redirect:/branch/employees/list";
	}
	
	@RequestMapping(value = "/edit/{empId}", method = RequestMethod.GET)
	public String editEmployeePage(@PathVariable("empId") Integer empId, Model model) {
		model.addAttribute("employee", userService.getUserById(empId));
		model.addAttribute("allRoles", roleService.getAllRoles());
		return "branch/employees/edit";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String editEmployee(@Valid @ModelAttribute("employee") User employee, BindingResult result, 
			@PathVariable("id") Integer id, HttpSession session, Model model) {
		employee.getRole().setId(roleService.getRoleByName(employee.getRole().getName()).getId());
		
		if (result.hasErrors()) {
			model.addAttribute("allRoles", roleService.getAllRoles());
			return "branch/employees/edit";
		}
		
		Branch branch = (Branch) session.getAttribute("branch");
		employee.setBranch(branch);
		userService.updateUser(employee);
		
		return "redirect:/branch/employees/list";
	}
	
	@RequestMapping(value = "/profile/{empId}", method = RequestMethod.GET)
	public String showProfile(@PathVariable("empId") Integer empId, Model model) {
		
		model.addAttribute("employee", userService.getUserById(empId));
		
		return "branch/employees/profile";
	}
	
	@RequestMapping(value = "/settings/{empId}", method = RequestMethod.GET)
	public String showSettings(@PathVariable("empId") Integer empId, Model model) {
		return "branch/employees/settings";
	}
	
	@RequestMapping(value = "/enabled/{empId}/{val}", method = RequestMethod.GET)
	public String changeEmployeeEnabled(@PathVariable("empId") Integer empId, 
			@PathVariable("val") boolean val, Model model) {
		User u = userService.getUserById(empId);
		u.setEnabled(val);
		userService.updateUser(u);
		
		return "redirect:/branch/employees/list";
	}

}
