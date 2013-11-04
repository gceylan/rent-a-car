package com.gceylan.rentacar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gceylan.rentacar.domain.Car;
import com.gceylan.rentacar.service.CarService;

@Controller
@RequestMapping("/admin/cars")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newCarPage(ModelMap model) {
		model.addAttribute("car", new Car());
		return "admin/cars/new";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String addCar(@Valid Car car, BindingResult result, 
			ModelMap model) {
		
		if (result.hasErrors())
			return "admin/cars/new";
		
		carService.addCar(car);
		
		return "redirect:/admin/cars/list";
	}
	
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String showCar(@PathVariable("id") Integer carId, ModelMap model) {
		
		model.addAttribute("car", carService.getCarById(carId));
		
		return "admin/cars/show";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listAllCars(ModelMap model) {
		
		model.addAttribute("allCars", carService.getAllCars());
		
		return "admin/cars/list";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editCarPage(@PathVariable("id") Integer carId, ModelMap model) {
		
		model.addAttribute("car", carService.getCarById(carId));
		
		return "admin/cars/edit";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String editCar(@Valid Car car, BindingResult result,
			@PathVariable("id") Integer carId, ModelMap model) {
		
		if (result.hasErrors()) {
			return "admin/cars/edit";
		}
		
		carService.updateCar(car);
		
		return "redirect:/admin/cars/list";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteCar(@PathVariable("id") Integer carId) {
		
		return "redirect:/admin/cars/list";
	}
	
	@RequestMapping(value = "/available/{carId}/{value}", method = RequestMethod.GET)
	public String isAvailable(@PathVariable("carId") Integer carId, 
			@PathVariable("value") Integer value) {
		
		carService.isAvailable(carId, value);
		
		return "redirect:/admin/cars/list";
	}
	
	public void setCarService(CarService carService) {
		this.carService = carService;
	}

}
