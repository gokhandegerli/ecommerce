package com.avazon.ecommerce.response;

import com.avazon.ecommerce.dto.CartProductDto;
import lombok.Data;

@Data
public class CartProductResponse {

    CartProductDto cartProduct;
    Meta meta = new Meta();

}
