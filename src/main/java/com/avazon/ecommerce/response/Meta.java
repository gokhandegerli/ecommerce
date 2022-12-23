package com.avazon.ecommerce.response;

import lombok.Data;

@Data
public class Meta {

    int code =200;
    String description ="Success";

    public Meta(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public Meta() {
    }
}
