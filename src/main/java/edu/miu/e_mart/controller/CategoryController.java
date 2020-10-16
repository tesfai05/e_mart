package edu.miu.e_mart.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.miu.e_mart.domain.Category;
import edu.miu.e_mart.service.ICategoryService;

@Controller
public class CategoryController {
	@Autowired
	private ICategoryService categoryService;

	@RequestMapping(value = { "/admin/categories" }, method = RequestMethod.GET)
	public String getCategoryForm(@ModelAttribute("category") Category category, Model model) {

		return "categoryForm";
	}

	@RequestMapping(value = { "/admin/categories" }, method = RequestMethod.POST)
	public String saveCategory(@Valid @ModelAttribute("category") Category category, 
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "categoryForm";
		}
		categoryService.saveCategory(category);
		return "redirect:/admin/products";
	}

}
