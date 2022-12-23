package com.avazon.ecommerce.response;

import com.avazon.ecommerce.dto.ProductDto;
import lombok.Data;

@Data
public class ProductResponse {

    ProductDto product;
    Meta meta = new Meta();


    public ProductResponse(ProductDto product) {
        this.product = product;
    }

    public ProductResponse(ProductDto product, Meta meta) {
        this.product = product;
        this.meta = meta;
    }

    public ProductResponse() {
    }
}
