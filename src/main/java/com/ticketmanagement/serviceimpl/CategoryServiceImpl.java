package com.ticketmanagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ticketmanagement.entities.Category;
import com.ticketmanagement.repository.CategoryRepository;
import com.ticketmanagement.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Category addCategory(String name) {
		Category category = new Category();
		category.setCategoryName(name);

		return categoryRepository.save(category);
	}

}
