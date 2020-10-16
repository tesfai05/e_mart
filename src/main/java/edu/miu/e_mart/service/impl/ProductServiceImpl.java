package edu.miu.e_mart.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.e_mart.domain.Product;
import edu.miu.e_mart.domain.Review;
import edu.miu.e_mart.repository.IProductRepository;
import edu.miu.e_mart.repository.IReviewRepository;
import edu.miu.e_mart.service.IProductService;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {
	@Autowired
	private IProductRepository productRepository;
	@Autowired
	private IReviewRepository reviewRepository;

	@Override
	public Product saveProduct(Product product) {

		return productRepository.save(product);
	}

	@Override
	public List<Product> findAllProducts() {
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Product findProductById(Integer productId) {
		return productRepository.findById(productId).orElse(null);
	}

	@Override
	public void deleteProductById(Integer productId) {

		productRepository.deleteById(productId);
	}

	@Override
	public List<Product> findAllProductsByCategory(String categoryName) {

		return productRepository.findProductsByCategoryName(categoryName);
	}

	@Override
	public String identifyUser(String user) throws Exception {
		if (!user.equals("admin") || !user.equals("customer")) {
			throw new Exception("Access Denied");
		} else if (user.equals("admin")) {
//=======
//		 productRepository.deleteById(productId);
//	}
//
////	@Override
////	public List<Product> findAllProductsByCategory(String categoryName) {
////		
////		return productRepository.findProductsByCategoryName(categoryName);
////	}
//
//	@Override
//	public String identifyUser(String user) throws Exception {
//		if(!user.equals("admin")||!user.equals("customer")) {
//			throw new Exception("Access Denied");
//		}
//		else if(user.equals("admin")) {
//>>>>>>> 27fec0bcc92e59cf2ea3c2a5100206473dc9f03f
			return "admin";
		}
		return "customer";
	}


	@Override
	public List<Review> findAllCommentsOfProduct(Integer productId) {
		Product product=productRepository.findById(productId).orElse(null);
		return product.getReviews();
	}


}

//	@Override
//	public List<Review> findAllCommentsOfProduct(Integer productId) {
//		
//		return (List<Review>) productRepository.findAllCommentsOfProduct(productId);
//	}



