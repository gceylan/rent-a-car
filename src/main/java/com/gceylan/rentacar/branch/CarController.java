package com.gceylan.rentacar.branch;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gceylan.rentacar.domain.Branch;
import com.gceylan.rentacar.domain.Car;
import com.gceylan.rentacar.service.BranchService;
import com.gceylan.rentacar.service.CarService;

@Controller
@RequestMapping("/branch/cars")
public class CarController {

	@Autowired
	private CarService carService;
	
	@Autowired
	private BranchService branchService;

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newCarPage(ModelMap model) {
		model.addAttribute("car", new Car());
		return "branch/cars/new";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String addCar(HttpSession session, 
			@Valid Car car, BindingResult result, ModelMap model) {

		if (result.hasErrors())
			return "branch/cars/new";
		
		/* eklenecek nesne Car 
		 * Car eklemek için car.setBranch(branch) þart.
		 * mvc rules
		 * 
		 * addCar(Branch branch, Car car) þeklinde güncellenebilir
		 * 
		 * */
		
		Branch branch = (Branch) session.getAttribute("branch");
		car.setBranch(branch);
		carService.addCar(car);

		return "redirect:/branch/cars/list";
	}

	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String showCar(@PathVariable("id") Integer carId, ModelMap model) {

		model.addAttribute("car", carService.getCarById(carId));

		return "branch/cars/show";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listAllCars(HttpSession session, ModelMap model) {
		Branch branch = (Branch) session.getAttribute("branch");

		model.addAttribute("allCars", carService.getAllCars(branch));

		return "branch/cars/list";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editCarPage(@PathVariable("id") Integer carId, ModelMap model) {

		model.addAttribute("car", carService.getCarById(carId));

		return "branch/cars/edit";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String editCar(@Valid Car car, BindingResult result,
			@PathVariable("id") Integer carId, ModelMap model,
			HttpSession session) {

		if (result.hasErrors()) {
			return "branch/cars/edit";
		}
		
		Branch branch = (Branch) session.getAttribute("branch");
		car.setBranch(branch);
		carService.updateCar(car);

		return "redirect:/branch/cars/list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteCar(@PathVariable("id") Integer carId) {
		
		carService.deleteCar(carId);

		return "redirect:/branch/cars/list";
	}
	
	@RequestMapping(value = "/available/{carId}/{value}", method = RequestMethod.GET)
	public String isAvailable(@PathVariable("carId") Integer carId, 
			@PathVariable("value") Integer value) {
		
		carService.isAvailable(carId, value);
		
		return "redirect:/branch/cars/list";
	}
	
	public void setBranchService(BranchService branchService) {
		this.branchService = branchService;
	}
	
	public void setCarService(CarService carService) {
		this.carService = carService;
	}

}
