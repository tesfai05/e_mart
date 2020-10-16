package edu.miu.e_mart.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.miu.e_mart.domain.ACredential;
import edu.miu.e_mart.domain.Admin;
import edu.miu.e_mart.domain.Customer;
@Repository
public interface ICustomerRepository extends CrudRepository<Customer, Integer>{
	// @Query(value="SELECT a FROM Customer a WHERE a.userName = ?1") 
	// ACredential findAcredentialByUserName(String userName );
//	 @Query(value="SELECT a FROM Customer a WHERE a.userName = ?1") 
//	public Customer findCustomerByName(String userName);
}
