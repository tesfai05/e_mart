package edu.miu.e_mart.service;

import java.util.List;

import edu.miu.e_mart.domain.Review;

public interface IReviewService {
	public Review saveReview(Review review);
	public List<Review> findAllReviewsOfProduct(Integer productId);
	

}