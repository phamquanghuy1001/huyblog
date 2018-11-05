package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.model.Category;
import com.blog.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryServices;

	@RequestMapping(value = "/admin/categories", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("categories", categoryServices.getAll());
		return "categories/list";
	}
	
	
	@RequestMapping(value = "/admin/categories/add", method = RequestMethod.GET)
	public String addPage(Model model) {
		model.addAttribute("category", new Category());
		return "categories/save";
	}
	
	@RequestMapping(value = "/admin/categories", method = RequestMethod.POST)
	public String add(@ModelAttribute Category category) {
		categoryServices.save(category);
		return "redirect:/admin/categories";
	}

}
