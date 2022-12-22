package com.avazon.ecommerce.api.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserUpdateBody {

    @Email(message = "Fill a proper e-mail format")
    @NotNull
    String email;
    @Pattern(regexp ="^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$", message = "Please fill a strong password," +
            "Minimum six characters, at least one letter and one number!")
    String password;
    String name;
}
