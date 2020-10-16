package edu.miu.e_mart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.e_mart.domain.ARole;
import edu.miu.e_mart.domain.Admin;
import edu.miu.e_mart.repository.IAdminRepository;
import edu.miu.e_mart.service.IAdminService;

@Service
public class AdminServiceImp implements IAdminService {
	
	@Autowired
	  private IAdminRepository adminrepository;
	
	  @Override
	  public Admin saveAdmin(Admin admin) {
	    
	    return adminrepository.save(admin);
	  }
	  @Override
	  public List<Admin> allAdmins() {
	    
	    return (List<Admin>) adminrepository.findAll();
	  }
	@Override
	public Admin findAdminById(Integer adminId) {
		
		return adminrepository.findById(adminId).orElse(null);
	}
	@Override
	public void deleteAdminById(Integer adminId) {
		adminrepository.deleteById(adminId);
		
	}
//	@Override
//	public Admin findAdminByName(String name) {
//		
//		return adminrepository.findAdminByName(name);
//	}
}