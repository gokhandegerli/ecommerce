package com.avazon.ecommerce.api.controller;


import com.avazon.ecommerce.api.model.CategoryCreateBody;
import com.avazon.ecommerce.api.model.RegistrationBody;
import com.avazon.ecommerce.exception.AlreadyExistException;
import com.avazon.ecommerce.exception.FieldsMissingException;
import com.avazon.ecommerce.response.CategoryResponse;
import com.avazon.ecommerce.service.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categories")
public class CategoryController {


    private CategoryService service;

    public CategoryController(CategoryService categoryService) {
        this.service = categoryService;
    }

    @PostMapping()
    public CategoryResponse createCategory(@RequestBody CategoryCreateBody categoryCreateBody) {
        try {
            checkCategoryCreateBody(categoryCreateBody);
            return service.createCategory(categoryCreateBody);
        } catch (AlreadyExistException ex) {
            ex.printStackTrace();
            CategoryResponse failResponse = new CategoryResponse();
            failResponse.getMeta().setCode(1001);
            failResponse.getMeta().setDescription("This category already exist! " +
                    "Please use a different name!");
            return failResponse;
        } catch (FieldsMissingException ex) {
            ex.printStackTrace();
            CategoryResponse failResponse = new CategoryResponse();
            failResponse.getMeta().setCode(1002);
            failResponse.getMeta().setDescription("Please fill the name field!");
            return failResponse;
        }
    }
    public void checkCategoryCreateBody(CategoryCreateBody categoryCreateBody) throws FieldsMissingException {
        if (categoryCreateBody.getName() == null || categoryCreateBody.getName().equals("")) {
            throw new FieldsMissingException("All fields should have been filled, please check!!");
        }
    }

}
