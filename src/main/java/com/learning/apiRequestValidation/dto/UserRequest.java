package com.learning.apiRequestValidation.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {
    @NotNull(message="username should not be null")
    private String name;
    @Email(message = "invalid email address")
    private String email;
    @Pattern(regexp = "^[6-9]\\d{9}$",message = "invalid mobile number entered")
    private String mobile;
    private String gender;
    @Min(18)
    @Max(80)
    private String age;
    @NotBlank
    private String nationality;
}
