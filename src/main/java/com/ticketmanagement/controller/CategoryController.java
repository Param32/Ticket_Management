package com.ticketmanagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ticketmanagement.entities.Category;
import com.ticketmanagement.repository.CategoryRepository;
import com.ticketmanagement.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	CategoryService categoryService;

	@GetMapping("/getCategory")
	public List<Category> getCategoryList() {
		return this.categoryRepository.findAll();
	}

	@PostMapping("/addCategory")
	public Category addCategory(@RequestBody String name) {
		return this.categoryService.addCategory(name);
	}
}
