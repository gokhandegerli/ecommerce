package com.avazon.ecommerce.response;

import com.avazon.ecommerce.dto.OrderProductDto;
import lombok.Data;

@Data
public class OrderProductResponse {

    OrderProductDto orderProduct;
    Meta meta = new Meta();

}
