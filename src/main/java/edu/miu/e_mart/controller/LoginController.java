package edu.miu.e_mart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.miu.e_mart.domain.ACredential;
import edu.miu.e_mart.repository.IAdminRepository;
import edu.miu.e_mart.service.IACredentialService;
import edu.miu.e_mart.service.IAddressService;
import edu.miu.e_mart.service.IAdminService;
import edu.miu.e_mart.service.ICustomerService;


@Controller
public class LoginController {
	@Autowired
	private IACredentialService credentialService;
	
//	@Autowired
//	private ICustomerService icustomerService;
//	
//	@Autowired
//	private IAdminService  iadminService;

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String diplayLogin(@ModelAttribute("credential") ACredential credential) {
		return "login";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String login(@ModelAttribute("credential") ACredential credential) {
		
		
		
		
		
		
		
		
		if(credential==null) {
			return "redirect:/customer/products/list";
		}
		

		return "redirect:/admin/products/list";
	}
	
	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String logout(@ModelAttribute("credential") ACredential credential) {
		return "login";
	}

}
