package com.avazon.ecommerce.response;

import com.avazon.ecommerce.dto.CategoryDto;
import lombok.Data;

@Data
public class CategoryResponse {

    CategoryDto category;
    Meta meta = new Meta();

}
