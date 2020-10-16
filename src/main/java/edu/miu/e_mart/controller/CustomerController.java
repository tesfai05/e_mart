package edu.miu.e_mart.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.miu.e_mart.domain.ARole;
import edu.miu.e_mart.domain.Customer;
import edu.miu.e_mart.service.ICustomerService;
import edu.miu.e_mart.service.impl.CustomerServiceImp;

@Controller
public class CustomerController {

	@Autowired
	ICustomerService customerService;
	
	@RequestMapping(value = {"/customer/signup"}, method = RequestMethod.GET)
	public String customerForm(@ModelAttribute("newCustomer") Customer customer) {
		return "customerForm";
	}
	@RequestMapping(value = {"/customer/save"}, method = RequestMethod.POST)
	public String addCustomer(@Valid @ModelAttribute("newCustomer") Customer customer,BindingResult result) {
	

		if(result.hasErrors()) {
			return "customerForm";
		}
		
		
		

		customerService.addCustomer(customer);
		return "redirect:/login";
	}


}
