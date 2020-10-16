package edu.miu.e_mart.repository;
import edu.miu.e_mart.domain.AnOrder;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IOrderRepository extends CrudRepository<AnOrder,Integer> {
}
