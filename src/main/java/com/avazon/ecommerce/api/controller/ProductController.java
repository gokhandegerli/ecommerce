package com.avazon.ecommerce.api.controller;

import com.avazon.ecommerce.api.model.CategoryCreateBody;
import com.avazon.ecommerce.api.model.ProductCreateBody;
import com.avazon.ecommerce.exception.AlreadyExistException;
import com.avazon.ecommerce.exception.FieldsMissingException;
import com.avazon.ecommerce.response.AddressResponse;
import com.avazon.ecommerce.response.CategoryResponse;
import com.avazon.ecommerce.response.ProductResponse;
import com.avazon.ecommerce.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService productService) {
        this.service = productService;
    }

    @PostMapping()
    public ProductResponse createProduct(@RequestBody ProductCreateBody productCreateBody) {
        try {
            return service.createProduct(productCreateBody);
        } catch (AlreadyExistException ex) {
            ex.printStackTrace();
            ProductResponse failResponse = new ProductResponse();
            failResponse.getMeta().setCode(1001);
            failResponse.getMeta().setDescription("This product already exist! " +
                    "Please use a different name!");
            return failResponse;
        }
        catch (FieldsMissingException ex) {
            ex.printStackTrace();
            ProductResponse failResponse = new ProductResponse();
            failResponse.getMeta().setCode(1002);
            failResponse.getMeta().setDescription("Please fill the name field!");
            return failResponse;
        }
    }

    @PostMapping("{productId}/category/{categoryId}")
    public ProductResponse addProductToCategory(@PathVariable(value = "productId") long productId,
                                            @PathVariable(value = "categoryId") long categoryId) {
        try {
            return service.addProductToCategory(productId, categoryId );
        } catch (EntityNotFoundException ex){
            ex.printStackTrace();
            ProductResponse failResponse = new ProductResponse();
            failResponse.getMeta().setCode(1003);
            failResponse.getMeta().setDescription("Product or Category could not be identified, please check the data!");
            return failResponse;
        }
    }

    @GetMapping ("{categoryId}/get-category-product-list")
    public List<ProductResponse> getCategoryProductList (@PathVariable(value = "categoryId") long categoryId) {
        return service.getCategoryProductList(categoryId);
    }

}
