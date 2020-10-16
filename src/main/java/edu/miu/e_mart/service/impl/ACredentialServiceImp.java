package edu.miu.e_mart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.e_mart.domain.ACredential;
import edu.miu.e_mart.repository.IACredentialRepository;
import edu.miu.e_mart.service.IACredentialService;

@Service
public class ACredentialServiceImp implements IACredentialService {
	@Autowired
	private IACredentialRepository Credentialrepo;

	@Override
	public ACredential getCredntialByUserName(String name) {
		return Credentialrepo.findByUserName(name);
	}

//	@Override
//	public ACredential findACredentialByUsername(String userName) {
//		// TODO Auto-generated method stub
//		return null
//	}


}
