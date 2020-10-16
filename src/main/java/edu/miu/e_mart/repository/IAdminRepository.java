package edu.miu.e_mart.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.miu.e_mart.domain.ARole;
import edu.miu.e_mart.domain.Admin;


@Repository
public interface IAdminRepository extends CrudRepository<Admin, Integer>{

//	@Query("select a from Admin a where a.userName=:name")
//	Admin findAdminByName(@Param("name")String name);

//	Admin getAdminByNmae(String name);


	
	

}
