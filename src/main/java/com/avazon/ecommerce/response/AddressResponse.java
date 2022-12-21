package com.avazon.ecommerce.response;

import com.avazon.ecommerce.dto.AddressDto;
import lombok.Data;

@Data
public class AddressResponse {

    AddressDto address;
    Meta meta = new Meta();
}
