package com.avazon.ecommerce.api.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddressUpdateBody {


    String line;
    String city;
    String country;
    String postCode;

}
