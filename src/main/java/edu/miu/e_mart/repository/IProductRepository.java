package edu.miu.e_mart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.miu.e_mart.domain.Product;
import edu.miu.e_mart.domain.Review;

@Repository
public interface IProductRepository extends CrudRepository<Product, Integer> {
	@Query("select p from Product p where p.category.categoryName=:categoryName")
	public List<Product> findProductsByCategoryName(@Param("categoryName") String categoryName);

	//@Query("select r from Product p join Review r where p.productId=:id and p.productId=r.productId ")
	//public List<Review> findAllCommentsOfProduct(@Param("id")Integer productId);
}
