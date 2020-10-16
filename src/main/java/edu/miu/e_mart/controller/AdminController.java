package edu.miu.e_mart.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.miu.e_mart.domain.Admin;
import edu.miu.e_mart.exception.AdminNotFoundException;
import edu.miu.e_mart.service.IAdminService;

@Controller
public class AdminController {
	
  @Autowired
  private IAdminService adminService;
  
  @RequestMapping(value = "/admin/create", method = RequestMethod.GET)
  public String getAdminForm(@ModelAttribute("admin")Admin admin, Model model) {
   
	  String[] roles= new String[] {"ADMIN"};
	  
    model.addAttribute("roles", roles);
    return "adminForm";
  }
  @RequestMapping(value = {"/admin/create"}, method = RequestMethod.POST)
  public String saveAdmin(@Valid @ModelAttribute("admin")Admin admin,BindingResult result,Model model) {
    
	  String[] roles= new String[] {"ADMIN"};
	  
	    model.addAttribute("roles", roles);
    if(result.hasErrors()) {
      return "adminForm";
    }
    adminService.saveAdmin(admin);
    return "redirect:/admin/admins";
  }
  @RequestMapping(value = {"/admin/admins"}, method = RequestMethod.GET)
  public String allAdmins(Model model) {
    
    model.addAttribute("admins",adminService.allAdmins());
    return "admins_list";
  }
  
  @RequestMapping(value = {"/admin/admins/edit/{id}"}, method = RequestMethod.GET)
  public String editAdmin(@PathVariable("id")Integer adminId,@ModelAttribute("admin")Admin admin, Model model) {
    
    Admin editedAdmin = adminService.findAdminById(adminId);
    if(editedAdmin==null) {
      throw new AdminNotFoundException("No Admin with ID : "+adminId);
    }
    String[] roles= new String[] {"ADMIN"};
    model.addAttribute("roles", roles);
    model.addAttribute("admin", editedAdmin);
    
    return "edit_admin";
  }
  @RequestMapping(value = {"/admin/admins/edit/{id}"}, method = RequestMethod.POST)
  public String saveEditedAdmin(@PathVariable("id")Integer adminId,@ModelAttribute("admin")Admin admin,
      BindingResult result, Model model) {
    
    Admin editedAdmin = adminService.findAdminById(adminId);
    
    model.addAttribute("admin", admin);
    if (result.hasErrors()) {
      return "edit_admin";
    }
    editedAdmin.setAcredential(admin.getAcredential());
    editedAdmin.setAddress(admin.getAddress());
    editedAdmin.setFirstName(admin.getFirstName());
    editedAdmin.setLastName(admin.getLastName());
    editedAdmin.setRole(admin.getRole());
    
    adminService.saveAdmin(editedAdmin);
    
    return "redirect:/admin/admins";
  }
  
  @RequestMapping(value = {"/admin/admins/delete/{id}"}, method = RequestMethod.GET)
  public String deleteAdmin(@PathVariable("id")Integer adminId) {
    
     adminService.deleteAdminById(adminId);
    
    return "redirect:/admin/admins";
  }
  

}