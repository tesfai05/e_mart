package edu.miu.e_mart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.e_mart.domain.ACredential;
import edu.miu.e_mart.domain.Customer;
import edu.miu.e_mart.repository.ICustomerRepository;
import edu.miu.e_mart.service.ICustomerService;
@Service
public class CustomerServiceImp implements ICustomerService {
	
	@Autowired
	private ICustomerRepository icustomerRepository;
	

	@Override
	public void addCustomer(Customer customer) {
		icustomerRepository.save(customer);
		
	}

//	@Override
//	public Customer findCustomerByName(String userName) {
//		
//		return icustomerRepository.findCustomerByName(userName);
//
//	}



	public ACredential findByUserName(String name) {
		
		return null;
	}

}
