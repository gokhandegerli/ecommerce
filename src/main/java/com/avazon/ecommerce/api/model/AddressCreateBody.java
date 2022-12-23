package com.avazon.ecommerce.api.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddressCreateBody {

    @NotNull
    String line;
    @NotNull
    String city;
    String country;
    String postCode;

}
