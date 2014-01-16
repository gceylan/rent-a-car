package com.gceylan.rentacar.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gceylan.rentacar.domain.Branch;
import com.gceylan.rentacar.domain.User;
import com.gceylan.rentacar.service.BranchService;
import com.gceylan.rentacar.service.CarService;
import com.gceylan.rentacar.service.RoleService;
import com.gceylan.rentacar.service.ServicePointService;
import com.gceylan.rentacar.service.UserService;
import com.gceylan.rentacar.util.AddBranchForm;

@Controller
@RequestMapping("/admin/branchs")
public class AdminBranchController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private BranchService branchService;
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private ServicePointService servicePointService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listAllBranchsPage(ModelMap model) {
		model.addAttribute("allBranchs", getAllBranchAndManagers());
		return "admin/branchs/list";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newBranchForm(ModelMap model) {
		User manager = new User();
		manager.setRole(roleService.getRoleById(2));
		
		Branch branch = new Branch();
		manager.setBranch(branch);
		
		AddBranchForm form = new AddBranchForm();
		form.setManager(manager);
		form.setBranch(branch);
		
		model.addAttribute("branchForm", form);
		model.addAttribute("allRoles", roleService.getAllRoles());
		
		return "admin/branchs/new";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String addNewBranch(@Valid @ModelAttribute("branchForm") AddBranchForm addBranchForm, 
			BindingResult result, ModelMap model) {
		
		User manager1 = addBranchForm.getManager();
		manager1.setRole(roleService.getRoleById(2));
		addBranchForm.setManager(manager1);
		
		if (result.hasErrors()) {
			model.addAttribute("allRoles", roleService.getAllRoles());
			return "admin/branchs/new";
		}
		
		Branch branch = addBranchForm.getBranch();
		branchService.addBranch(branch);
		
		User manager = addBranchForm.getManager();
		manager.setBranch(branch);
		userService.addUser(manager);
		
		return "redirect:/admin/branchs/list";
	}
	
	@RequestMapping(value = "/delete/{branchId}", method = RequestMethod.GET)
	public String deleteBranch(@PathVariable("branchId") Integer branchId) {
		branchService.deleteBranch(branchId);
		return "redirect:/admin/branchs/list";
	}
	
	@RequestMapping(value = "/show/{branchId}", method = RequestMethod.GET)
	public String showBranch(@PathVariable("branchId") Integer branchId, Model model) {
		
		Branch branch = branchService.getBranchById(branchId);
		branch.setCars(carService.getAllCars(branch));
		branch.setServicePoints(servicePointService.getAllServicePoints(branch));
		branch.setEmployees(userService.getAllEmployees(branch));
		
		model.addAttribute("branch", branch);
		model.addAttribute("branchManagers", userService.getAllManagers(branch));

		return "admin/branchs/show";
	}
	
	@RequestMapping(value = "/edit/{branchId}", method = RequestMethod.GET)
	public String editBranchPage(@PathVariable("branchId") Integer branchId, Model model) {
		Branch branch = branchService.getBranchById(branchId);
		
		AddBranchForm editBranchForm = new AddBranchForm();
		editBranchForm.setManager(userService.getAllManagers(branch).get(0));
		editBranchForm.setBranch(branch);
		
		model.addAttribute("editBranchForm", editBranchForm);
		model.addAttribute("allRoles", roleService.getAllRoles());

		return "admin/branchs/edit";
	}
	
	@RequestMapping(value = "/edit/{branchId}", method = RequestMethod.POST)
	public String editBranch(@Valid @ModelAttribute("editBranchForm") AddBranchForm editBranchForm,
			BindingResult result, ModelMap model,
			@PathVariable("branchId") Integer branchId) {
		
		/* 
		 * AddBranchForm gibi bir sýnýf kullanýldýðýnda
		 * iþler biraz karýþtý
		*/
		User manager1 = editBranchForm.getManager();
		manager1.setRole(roleService.getRoleById(2));
		editBranchForm.setManager(manager1);
		editBranchForm.setBranch(branchService.getBranchById(branchId));
		
		if (result.hasErrors()) {
			model.addAttribute("allRoles", roleService.getAllRoles());
			return "admin/branchs/edit";
		}
		
//		Branch branch = editBranchForm.getBranch();
//		branchService.updateBranch(branch);

		return "redirect:/admin/branchs/list";
	}

	public Map<Branch, List<User>> getAllBranchAndManagers() {
		List<Branch> branchs = branchService.getAllBranchs();
		Map<Branch, List<User>> branchAndManagers = new HashMap<Branch, List<User>>();
		
		for (Branch branch : branchs) {
			branchAndManagers.put(branch, userService.getAllManagers(branch));
		}
		
		return branchAndManagers;
	}
	
	@RequestMapping(value = "/addBranch", method = RequestMethod.GET)
	public String addBranch(ModelMap model) {
		
//		User u = new User();
//		u.setUsername("deneme");
//		u.setPassword("12345789");
//		u.setFirstname("deneme");
//		u.setLastname("deneme");
//		u.setEmail("deneme@deneme.com.tr");
//		u.setRole(roleService.getRoleById(1));
//		
//		Branch b1 = branchService.getBranchById(1);
//		b1.setManager(u);
//		
//		branchService.updateBranch(b1);
		
		User u = userService.getUserById(3);
		
		System.out.println("u: " + u.getFirstname());
		
		System.out.println("u.branch: " + u.getBranch().getBranchCode());
		
		return "admin/main";
	}
	
	public void setBranchService(BranchService branchService) {
		this.branchService = branchService;
	}
	
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void setCarService(CarService carService) {
		this.carService = carService;
	}
	
	public void setServicePointService(ServicePointService servicePointService) {
		this.servicePointService = servicePointService;
	}

}
