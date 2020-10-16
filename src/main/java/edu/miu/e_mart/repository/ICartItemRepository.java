package edu.miu.e_mart.repository;

//import edu.miu.e_mart.domain.CartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.miu.e_mart.domain.CartItem;

@Repository
public interface ICartItemRepository extends CrudRepository<CartItem,Integer> {
}
