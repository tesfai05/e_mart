package edu.miu.e_mart.service;

import java.util.List;


import edu.miu.e_mart.domain.Admin;

public interface IAdminService {

	public Admin saveAdmin(Admin admin);

	  public List<Admin> allAdmins();

	public Admin findAdminById(Integer adminId);

	public void deleteAdminById(Integer adminId);
	
//	public Admin findAdminByName(String name);
	
	
}
