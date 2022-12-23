package com.avazon.ecommerce.service;


import com.avazon.ecommerce.api.model.ProductCreateBody;
import com.avazon.ecommerce.dto.AddressDto;
import com.avazon.ecommerce.dto.ProductDto;
import com.avazon.ecommerce.exception.AlreadyExistException;
import com.avazon.ecommerce.exception.FieldsMissingException;
import com.avazon.ecommerce.model.entity.Address;
import com.avazon.ecommerce.model.entity.Category;
import com.avazon.ecommerce.model.entity.Product;
import com.avazon.ecommerce.repository.ProductRepository;
import com.avazon.ecommerce.response.AddressResponse;
import com.avazon.ecommerce.response.ProductResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository repository;

    private CategoryService categoryService;

    public ProductService(ProductRepository repository, CategoryService categoryService) {
        this.repository = repository;
        this.categoryService = categoryService;
    }

    public ProductResponse createProduct(ProductCreateBody productCreateBody)
            throws AlreadyExistException, FieldsMissingException {
        if (repository.findByName(productCreateBody.getName()).isPresent()) {
            throw new AlreadyExistException("Product exist, use a different name!");
        }
        if (productCreateBody.getName() == null || productCreateBody.getName().equals("") ) {
            throw new FieldsMissingException("All fields should have been filled, please check!!");
        }
        Product product = new Product();
        product.setName(productCreateBody.getName());
        product.setDescription(productCreateBody.getDescription());
        product.setPicture(productCreateBody.getPicture());
        product.setPrice(productCreateBody.getPrice());
        product.setQuantity(productCreateBody.getQuantity());
        ProductResponse response = new ProductResponse();
        response.setProduct(repository.save(product).toDto());
        return response;
    }

    public ProductResponse addProductToCategory(long productId, long categoryId) throws EntityNotFoundException {

        Optional<Product> product = repository.findById(productId);
        Optional<Category> category = categoryService.getCategoryEntity(categoryId);
        ProductResponse response = new ProductResponse();

        if (product.isPresent() && category.isPresent()) {
            product.get().setCategory(category.get());
            response.setProduct(repository.save(product.get()).toDto());
            return response;
        } else {
            throw new EntityNotFoundException("Product or Category could not be identified, please check the data!");
        }
    }

    public List<ProductResponse> getCategoryProductList(long categoryId) {
        List<Product> productList = repository.findProductByCategoryId(categoryId);
        List<ProductDto> productDtoList = productList.stream().map(Product::toDto).toList();
        return productDtoList.stream().map(productDto -> new ProductResponse(productDto)).toList();
    }

    public Optional<Product> getProductEntity(long productId) {
        return repository.findById(productId);
    }
}
