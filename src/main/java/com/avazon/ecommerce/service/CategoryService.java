package com.avazon.ecommerce.service;


import com.avazon.ecommerce.api.model.CategoryCreateBody;
import com.avazon.ecommerce.exception.AlreadyExistException;
import com.avazon.ecommerce.exception.FieldsMissingException;
import com.avazon.ecommerce.model.entity.Category;
import com.avazon.ecommerce.repository.CategoryRepository;
import com.avazon.ecommerce.response.CategoryResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {


    private CategoryRepository repository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.repository = categoryRepository;
    }


    public CategoryResponse createCategory(CategoryCreateBody categoryCreateBody)
            throws AlreadyExistException,FieldsMissingException {
        if (repository.findByName(categoryCreateBody.getName()).isPresent()) {
            throw new AlreadyExistException("Category exist, use a different name!");
        }
        if (categoryCreateBody.getName() == null || categoryCreateBody.getName().equals("") ) {
            throw new FieldsMissingException("All fields should have been filled, please check!!");
        }
        Category category = new Category();
        category.setName(categoryCreateBody.getName());
        CategoryResponse response = new CategoryResponse();
        response.setCategory(repository.save(category).toDto());
        return response;
    }

    public Optional<Category> getCategoryEntity(long categoryId) {
         return repository.findById(categoryId);

    }
}
