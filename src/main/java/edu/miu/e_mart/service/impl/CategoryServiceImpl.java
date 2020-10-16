package edu.miu.e_mart.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.e_mart.domain.Category;
import edu.miu.e_mart.repository.ICategoryRepository;
import edu.miu.e_mart.service.ICategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	private ICategoryRepository categoryRepository;

	@Override
	public Category saveCategory(Category category) {
		
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> findAllCategories() {
		
		return (List<Category>) categoryRepository.findAll();
	}

	@Override
	public Category findCategoryById(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category deleteCategoryById(Integer categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

}
