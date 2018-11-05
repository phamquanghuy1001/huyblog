package com.blog.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.model.Category;
import com.blog.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> getAll() {
		return (List<Category>) categoryRepository.findAll();
	}
	
	public Category save(Category category) {
		category.setRegDate(new Timestamp(new Date().getTime()));
		category.setModDate(new Timestamp(new Date().getTime()));
		category.setUserId(1);
		return categoryRepository.save(category);
	}
	
	public Optional<Category> findById(Integer id) {
		return categoryRepository.findById(id);
	}
}
