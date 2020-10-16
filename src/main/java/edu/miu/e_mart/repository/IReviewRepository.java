package edu.miu.e_mart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.miu.e_mart.domain.ACredential;
import edu.miu.e_mart.domain.Review;

@Repository
public interface IReviewRepository extends CrudRepository<Review, Integer> {
	@Query("select r from Review r where r.product.productId=:id")
	List<Review> findAllReviewsByProductId(@Param("id")Integer productId);

}
