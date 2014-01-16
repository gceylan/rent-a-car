package com.gceylan.rentacar.branch;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gceylan.rentacar.domain.Branch;
import com.gceylan.rentacar.domain.User;
import com.gceylan.rentacar.service.RentalService;
import com.gceylan.rentacar.service.UserService;

@Controller
@RequestMapping("/branch")
@SessionAttributes({"logonUser", "branch"})
public class BranchController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RentalService rentalService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String redirectBranchMain() {
		return "redirect:/branch/main";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String branchPage(ModelMap model, Principal principal) {
		
		User logonUser = userService.getUserByUsername(principal.getName());
		Branch branch = logonUser.getBranch();
		
		model.addAttribute("logonUser", logonUser);
		model.addAttribute("branch", branch);
		
//		model.addAttribute("notConfirmed", rentalService.getRentalCount(branch.getId(), false, false));
//		model.addAttribute("notCompleted", rentalService.getNotCompletedRentals(branch.getId()).size());
//		model.addAttribute("completed", rentalService.getRentalCount(branch.getId(), true, true));
//		model.addAttribute("nowDoing", rentalService.getNowRentalCount(branch.getId()));

		return "branch/main";
	}

	@RequestMapping(value = "/charts", method = RequestMethod.GET)
	public String branchCharts(ModelMap model) {
		return "branch/charts";
	}

	@RequestMapping(value = "/tables", method = RequestMethod.GET)
	public String branchTables(ModelMap model) {
		return "branch/tables";
	}

	@RequestMapping(value = "/forms", method = RequestMethod.GET)
	public String branchForms(ModelMap model) {
		return "branch/forms";
	}

	@RequestMapping(value = "/typography", method = RequestMethod.GET)
	public String branchTypography(ModelMap model) {
		return "branch/typography";
	}

	@RequestMapping(value = "/bootstrap-elements", method = RequestMethod.GET)
	public String branchBootstrapElements(ModelMap model) {
		return "branch/bootstrap-elements";
	}

	@RequestMapping(value = "/bootstrap-grid", method = RequestMethod.GET)
	public String branchBootstrapGrid(ModelMap model) {
		return "branch/bootstrap-grid";
	}

	@RequestMapping(value = "/blank-page", method = RequestMethod.GET)
	public String branchBlankPage(ModelMap model) {
		return "branch/blank-page";
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void setRentalService(RentalService rentalService) {
		this.rentalService = rentalService;
	}
	
	@RequestMapping(value = "/not-confirmed-rental-count", method = RequestMethod.POST)
	public @ResponseBody Integer notConfirmedRentalCount(HttpSession session) {
		Branch branch = (Branch) session.getAttribute("branch");
		return rentalService.getRentalCount(branch.getId(), false, false);
	}
	
	@RequestMapping(value = "/completed-rental-count", method = RequestMethod.POST)
	public @ResponseBody Integer completedRentalCount(HttpSession session) {
		Branch branch = (Branch) session.getAttribute("branch");
		return rentalService.getRentalCount(branch.getId(), true, true);
	}
	
	@RequestMapping(value = "/not-completed-rental-count", method = RequestMethod.POST)
	public @ResponseBody Integer notCompletedRentalCount(HttpSession session) {
		Branch branch = (Branch) session.getAttribute("branch");
		return rentalService.getNotCompletedRentals(branch.getId()).size();
	}
	
	@RequestMapping(value = "/now-doing-rental-count", method = RequestMethod.POST)
	public @ResponseBody Integer test(HttpSession session) {
		Branch branch = (Branch) session.getAttribute("branch");
		return  rentalService.getNowRentalCount(branch.getId());
	}

}
