package com.avazon.ecommerce.response;

import com.avazon.ecommerce.dto.AddressDto;
import lombok.Data;

@Data
public class AddressResponse {

    AddressDto address = new AddressDto();
    Meta meta = new Meta();

    public AddressResponse(AddressDto address, Meta meta) {
        this.address = address;
        this.meta = meta;
    }

    public AddressResponse(AddressDto address) {
        this.address = address;
    }

    public AddressResponse() {
    }
}
