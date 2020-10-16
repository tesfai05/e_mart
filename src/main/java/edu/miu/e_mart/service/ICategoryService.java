package edu.miu.e_mart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.miu.e_mart.domain.Category;

@Service
public interface ICategoryService {
	public Category saveCategory(Category category);

	public List<Category> findAllCategories();

	public Category findCategoryById(Integer categoryId);

	public Category deleteCategoryById(Integer categoryId);
}
