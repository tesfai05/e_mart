package edu.miu.e_mart.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.miu.e_mart.domain.ACredential;

public interface IACredentialService {

//	ACredential getCredntialByUserName(String userName);
	
	public ACredential getCredntialByUserName(String name);

//	public ACredential findACredentialByUsername(String userName)
	

}
