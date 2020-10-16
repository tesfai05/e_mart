package edu.miu.e_mart.repository;

import edu.miu.e_mart.domain.ARole;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IARoleRepository extends CrudRepository<ARole,Integer> {
}
