package edu.miu.e_mart.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.miu.e_mart.domain.ACredential;

@Repository
public interface IACredentialRepository extends CrudRepository<ACredential, Integer>{
@Query("select a from ACredential a where a.userName=:name")
	ACredential findByUserName(@Param("name")String name);
	
}
