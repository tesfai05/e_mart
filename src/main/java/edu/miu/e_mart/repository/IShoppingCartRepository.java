package edu.miu.e_mart.repository;


import edu.miu.e_mart.domain.ShoppingCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShoppingCartRepository extends CrudRepository<ShoppingCart,Integer> {
}
