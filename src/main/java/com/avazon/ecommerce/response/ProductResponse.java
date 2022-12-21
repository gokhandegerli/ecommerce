package com.avazon.ecommerce.response;

import com.avazon.ecommerce.dto.ProductDto;
import lombok.Data;

@Data
public class ProductResponse {

    ProductDto product;
    Meta meta = new Meta();

}
