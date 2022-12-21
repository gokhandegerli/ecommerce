package com.avazon.ecommerce.response;

import com.avazon.ecommerce.dto.OrderDto;
import lombok.Data;

@Data
public class WebOrderResponse {

    OrderDto order;
    Meta meta = new Meta();

}
