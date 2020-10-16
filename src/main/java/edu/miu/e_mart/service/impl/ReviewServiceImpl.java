package edu.miu.e_mart.service.impl;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.e_mart.domain.Review;
import edu.miu.e_mart.repository.IReviewRepository;
import edu.miu.e_mart.service.IReviewService;
@Service
@Transactional
public class ReviewServiceImpl implements IReviewService {
	@Autowired
	private IReviewRepository reviewRepository;
	@Override
	public Review saveReview(Review review) {
		
		return reviewRepository.save(review);
	}

	@Override
	public List<Review> findAllReviewsOfProduct(Integer productId) {
		
		return (List<Review>) reviewRepository.findAllReviewsByProductId(productId);
	}


}