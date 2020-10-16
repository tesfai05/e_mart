package edu.miu.e_mart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.miu.e_mart.domain.Product;
import edu.miu.e_mart.domain.Review;
import edu.miu.e_mart.exception.ProductNotFoundException;
import edu.miu.e_mart.service.ICategoryService;
import edu.miu.e_mart.service.IProductService;
import edu.miu.e_mart.service.IReviewService;

@Controller
public class ProductController {

	@Autowired
	private IProductService productService;

	@Autowired
	private IReviewService reviewService;

	@Autowired
	private ICategoryService categoryService;

	@RequestMapping(value = { "/{user}/products/list" }, method = RequestMethod.GET)
	public String findAllProducts(@PathVariable("user") String user, Model model) {

		List<Product> products = productService.findAllProducts();
		model.addAttribute("products", products);
		if (user.equals("admin"))
			return "admin_products";

		return "customer_products";
	}

	@RequestMapping(value = { "/admin/products" }, method = RequestMethod.GET)
	public String getProductForm(@ModelAttribute("product") Product product, Model model) {

		model.addAttribute("categories", categoryService.findAllCategories());
		return "productForm";
	}

	@RequestMapping(value = { "/admin/products" }, method = RequestMethod.POST)
	public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
		model.addAttribute("categories", categoryService.findAllCategories());
		if (result.hasErrors()) {
			return "productForm";
		}
		productService.saveProduct(product);
		return "redirect:/admin/products/list";
	}

	@RequestMapping(value = { "/admin/products/{action}/{id}" }, method = RequestMethod.GET)
	public String getProduct(@PathVariable("action") String action, @PathVariable("id") Integer productId,
			Model model) {
		
		Product product = productService.findProductById(productId);
		model.addAttribute("product", product);
		//model.addAttribute("productId", productId);
		
		if (product == null) {
			throw new ProductNotFoundException("No product with ID :" + productId);

		}
		 else if (action.equals("delete")) {
			
		
			productService.deleteProductById(productId);
			return "redirect:/admin/products/list";
		
		} else if (action.equals("edit")) {
			
			
			model.addAttribute("categories", categoryService.findAllCategories());
			return "edit_product";
		
		} else if (action.equals("comments")) {
			
		
			model.addAttribute("reviews", reviewService.findAllReviewsOfProduct(productId));
			return "comment_product";
		
		}
		return "public_error";
	}

	@RequestMapping(value = { "/admin/products/edit/{id}" }, method = RequestMethod.POST)
	public String saveEditedProduct(@Valid @ModelAttribute("product") Product product, BindingResult result,
			@PathVariable("id") Integer productId, Model model) {

		Product editedProduct = productService.findProductById(product.getProductId());
		model.addAttribute("product", product);
		if (result.hasErrors()) {
			return "edit_product";
		}
		editedProduct.setCategory(product.getCategory());
		editedProduct.setDescription(product.getDescription());
		editedProduct.setProductImagePath(product.getProductImagePath());
		editedProduct.setProductName(product.getProductName());
		editedProduct.setUnitPrice(product.getUnitPrice());
		productService.saveProduct(editedProduct);
		return "redirect:/admin/products/list";

	}

	@RequestMapping(value = { "/{user}/products/{categoty}" }, method = RequestMethod.GET)
	public String findAllProductsByCategory(@PathVariable("categoty") String category,
			@PathVariable("user") String user, Model model) {

		model.addAttribute("products", productService.findAllProductsByCategory(category));
		if (user.equals("admin"))
			return "admin_products";
		return "customer_products";
	}

	@RequestMapping(value = { "/customer/products/comment/{id}" }, method = RequestMethod.GET)
	public String getReviewForm(@ModelAttribute("review") Review review, @PathVariable("id") Integer productId,
			Model model) {
		model.addAttribute("id", productId);
		return "reviewForm";
	}

	@RequestMapping(value = { "/customer/products/comment/{id}" }, method = RequestMethod.POST)
	public String writeCommentOnProduct(@PathVariable("id") Integer productId,
			@Valid @ModelAttribute("review") Review review, BindingResult result, Model model) {
		System.out.println("review");
		if (result.hasFieldErrors()) {
			return "reviewForm";
		}
		Product product = productService.findProductById(productId);
		review.setProduct(product);
		reviewService.saveReview(review);
		return "redirect:/customer/products/list";
	}


}
